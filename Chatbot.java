/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package part1;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
/**
 *
 * @author Student
 */
public class ChatBot {
  // USER DATA 
    static String registeredFirstName;
    static String registeredLastName;
    private static String registeredUsername;
    private static String registeredPassword;
    private static String registeredPhoneNumber;

    //MESSAGE STORAGE 
    private static int maxMessages;
    private static String[] messageIDs;
    private static String[] messageHashes;
    private static String[] messageRecipients;
    private static String[] messageContents;
    private static String[] messageStatuses; 

    //PARALLEL ARRAYS FOR STORED MESSAGES 
 static ArrayList<String> storedIDs = new ArrayList<>();
 static ArrayList<String> storedHashes = new ArrayList<>();
 static ArrayList<String> storedRecipients = new ArrayList<>();   
 static ArrayList<String> storedSenders = new ArrayList<>();
 static ArrayList<String> storedContents = new ArrayList<>();

    private static final String JSON_FILE = "messages.json";
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        loadMessagesFromJson();        
        Scanner scanner = new Scanner(System.in);

        //PART 1: REGISTRATION & LOGIN 
        registerUser(scanner);
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("\n=== LOGIN ===");
            System.out.print("Enter username: ");
            String lu = scanner.nextLine();
            System.out.print("Enter password: ");
            String lp = scanner.nextLine();
            loggedIn = loginUser(lu, lp);
            System.out.println(returnLoginStatus(loggedIn));
        }

        System.out.println("\nWelcome to Quick Chat");

        while (true) {
            try {
                System.out.print("How many messages do you want to send? ");
                maxMessages = Integer.parseInt(scanner.nextLine());
                if (maxMessages > 0) break;
                else System.out.println("Please enter a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            }
        }

       
        messageIDs = new String[maxMessages];
        messageHashes = new String[maxMessages];
        messageRecipients = new String[maxMessages];
        messageContents = new String[maxMessages];
        messageStatuses = new String[maxMessages];

      
        for (int i = 0; i < maxMessages; i++) {
            System.out.println("\n--- Message " + (i + 1) + " of " + maxMessages + " ---");

            String recipient = "";
            while (true) {
                System.out.print("Enter recipient cell number (start with '+', max 10 digits): ");
                recipient = scanner.nextLine();
                if (validateRecipient(recipient)) break;
                System.out.println("Invalid recipient.");
            }

            String content = "";
            while (true) {
                System.out.print("Enter message (max 250 chars): ");
                content = scanner.nextLine();
                if (validateMessageLength(content)) break;
                System.out.println("Please enter a message of less than 250 characters.");
            }

            int msgNumber = i + 1;
            String rawId = generateRawId(msgNumber);
            String messageId = rawId.substring(0, 10);
            String hash = generateHash(messageId, content, msgNumber);
            String sender = registeredFirstName + " " + registeredLastName;

            // Store in main arrays
            messageIDs[i] = messageId;
            messageHashes[i] = hash;
            messageRecipients[i] = recipient;
            messageContents[i] = content;

            // Display
            System.out.println("\n--- Message Details ---");
            System.out.println("Message ID: " + messageId);
            System.out.println("Message Hash: " + hash);
            System.out.println("Recipient: " + recipient);
            System.out.println("Content: " + content);

            boolean validChoice = false;
            while (!validChoice) {
                System.out.println("\nChoose action:");
                System.out.println("1 - Send message");
                System.out.println("0 - Disregard / Delete message");
                System.out.println("2 - Store message to send later");
                System.out.print("Your choice: ");
                String action = scanner.nextLine();

                switch (action) {
                    case "1":
                        messageStatuses[i] = "sent";
                        System.out.println("Message successfully sent.");
                        validChoice = true;
                        break;
                    case "0":
                        messageStatuses[i] = "disregarded";
                        System.out.println("Message deleted.");
                        validChoice = true;
                        break;
                    case "2":
                        messageStatuses[i] = "stored";
                        // --- PART 3: populate parallel arrays for stored messages ---
                        storedIDs.add(messageId);
                        storedHashes.add(hash);
                        storedRecipients.add(recipient);
                        storedSenders.add(sender);
                        storedContents.add(content);
                        System.out.println("Message successfully stored.");
                        validChoice = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } 

        // MAIN MENU 
        boolean quit = false;
        while (!quit) {
            System.out.println("\n=== QUICK CHAT MENU ===");
            System.out.println("1. Show sent messages");
            System.out.println("2. Show stored messages (Part 3)");
            System.out.println("3. Stored Messages Sub-Menu (Part 3)");
            System.out.println("4. Quit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showMessagesByStatus("sent");
                    break;
                case "2":
                    showMessagesByStatus("stored");
                    break;
                case "3":
                    storedMessagesMenu(scanner);
                    break;
                case "4":
                    quit = true;
                    System.out.println("Goodbye " + registeredFirstName + "!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        saveMessagesToJson();
        scanner.close();
    }

    //PART 1 METHODS 
    private static void registerUser(Scanner scanner) {
        System.out.println("====================");
        System.out.println("   USER REGISTRATION");
        System.out.println("====================");
        System.out.print("Enter first name: ");
        registeredFirstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        registeredLastName = scanner.nextLine();

        while (true) {
            System.out.print("Choose a username (must contain '_' and be <= 5 chars): ");
            String username = scanner.nextLine();
            if (checkUserName(username)) {
                registeredUsername = username;
                break;
            }
            System.out.println("Invalid username.");
        }
        while (true) {
            System.out.print("Choose a password (8+ chars, capital, number, special): ");
            String password = scanner.nextLine();
            if (checkPasswordComplexity(password)) {
                registeredPassword = password;
                break;
            }
            System.out.println("Invalid password.");
        }
        while (true) {
            System.out.print("Enter cell phone number (e.g., +27123456789): ");
            String phone = scanner.nextLine();
            if (checkCellPhoneNumber(phone)) {
                registeredPhoneNumber = phone;
                break;
            }
            System.out.println("Invalid phone number.");
        }
        System.out.println("\nRegistration successful!");
    }

    public static boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    public static boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) return false;
        boolean hasUpper = false, hasDigit = false, hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        return hasUpper && hasDigit && hasSpecial;
    }

    public static boolean checkCellPhoneNumber(String phone) {
        return phone != null && phone.matches("\\+\\d{9,14}");
    }

    public static boolean loginUser(String enteredUsername, String enteredPassword) {
        if (registeredUsername == null || registeredPassword == null) return false;
        return enteredUsername.equals(registeredUsername) &&
               enteredPassword.equals(registeredPassword);
    }

    public static String returnLoginStatus(boolean success) {
        if (success)
            return "Welcome " + registeredFirstName + ", " + registeredLastName +
                   " it is great to see you again.";
        else
            return "Username or password incorrect, please try again.";
    }

    
    private static boolean validateRecipient(String phone) {
        if (phone == null || !phone.startsWith("+")) return false;
        String digits = phone.substring(1);
        if (digits.isEmpty()) return false;
        for (char c : digits.toCharArray()) if (!Character.isDigit(c)) return false;
        return phone.length() <= 10;
    }

    private static boolean validateMessageLength(String msg) {
        return msg != null && msg.length() <= 250;
    }

    /** For testing, make public static */
    public static String generateRawId(int msgNum) {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        return timestamp + String.format("%03d", msgNum);
    }

    /** For testing, make public static */
    public static String generateHash(String messageId, String content, int msgNum) {
        String firstTwo = messageId.substring(0, 2);
        String firstWord = getFirstWord(content);
        String lastWord  = getLastWord(content);
        String part = (firstWord.length() >= 3 ? firstWord.substring(0, 3) : firstWord) + lastWord;
        return (firstTwo + ":" + msgNum + ":" + part).toUpperCase();
    }

    
    public static String getMessageIdMessage(String id) {
    return "Message ID generated: " + id;
    }
    
    
    public static String getFirstWord(String text) {
        text = text.trim();
        int sp = text.indexOf(' ');
        return sp == -1 ? text : text.substring(0, sp);
    }

    public static String getLastWord(String text) {
        text = text.trim();
        int sp = text.lastIndexOf(' ');
        return sp == -1 ? text : text.substring(sp + 1);
    }

    private static void showMessagesByStatus(String status) {
        System.out.println("\n--- " + status.substring(0,1).toUpperCase() +
                           status.substring(1) + " Messages ---");
        boolean found = false;
        for (int i = 0; i < maxMessages; i++) {
            if (messageStatuses[i] != null && messageStatuses[i].equals(status)) {
                System.out.println("ID: " + messageIDs[i]);
                System.out.println("Hash: " + messageHashes[i]);
                System.out.println("Recipient: " + messageRecipients[i]);
                System.out.println("Content: " + messageContents[i]);
                System.out.println("-------------------");
                found = true;
            }
        }
        if (!found) System.out.println("No " + status + " messages.");
    }

    // Stored Messages sub‑menu
    private static void storedMessagesMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Stored Messages ---");
            System.out.println("1. Show sender & recipient of all stored messages");
            System.out.println("2. Show longest stored message");
            System.out.println("3. Search by Message ID");
            System.out.println("4. Search by recipient");
            System.out.println("5. Delete by Message Hash");
            System.out.println("6. Full report of stored messages");
            System.out.println("7. Back to main menu");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": showSenderRecipient(); break;
                case "2": showLongestStoredMessage(); break;
                case "3": searchByMessageId(scanner); break;
                case "4": searchByRecipient(scanner); break;
                case "5": deleteByHash(scanner); break;
                case "6": fullReport(); break;
                case "7": back = true; break;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private static void showSenderRecipient() {
        if (storedIDs.isEmpty()) { System.out.println("No stored messages."); return; }
        System.out.println("Sender -> Recipient:");
        for (int i = 0; i < storedIDs.size(); i++) {
            System.out.println(storedSenders.get(i) + " -> " + storedRecipients.get(i));
        }
    }

    private static void showLongestStoredMessage() {
        if (storedIDs.isEmpty()) { System.out.println("No stored messages."); return; }
        int maxIdx = 0;
        for (int i = 1; i < storedContents.size(); i++) {
            if (storedContents.get(i).length() > storedContents.get(maxIdx).length()) {
                maxIdx = i;
            }
        }
        System.out.println("Longest stored message:");
        System.out.println("ID: " + storedIDs.get(maxIdx));
        System.out.println("Hash: " + storedHashes.get(maxIdx));
        System.out.println("Recipient: " + storedRecipients.get(maxIdx));
        System.out.println("Sender: " + storedSenders.get(maxIdx));
        System.out.println("Content: " + storedContents.get(maxIdx));
    }

    private static void searchByMessageId(Scanner scanner) {
        System.out.print("Enter Message ID: ");
        String id = scanner.nextLine();
        for (int i = 0; i < storedIDs.size(); i++) {
            if (storedIDs.get(i).equals(id)) {
                System.out.println("Recipient: " + storedRecipients.get(i));
                System.out.println("Message: " + storedContents.get(i));
                return;
            }
        }
        System.out.println("ID not found.");
    }

    private static void searchByRecipient(Scanner scanner) {
        System.out.print("Enter recipient phone: ");
        String recip = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < storedRecipients.size(); i++) {
            if (storedRecipients.get(i).equals(recip)) {
                System.out.println("ID: " + storedIDs.get(i) + " | Content: " + storedContents.get(i));
                found = true;
            }
        }
        if (!found) System.out.println("No messages for that recipient.");
    }

    private static void deleteByHash(Scanner scanner) {
        System.out.print("Enter Message Hash to delete: ");
        String hash = scanner.nextLine().toUpperCase();
        for (int i = 0; i < storedHashes.size(); i++) {
            if (storedHashes.get(i).equals(hash)) {
                storedIDs.remove(i);
                storedHashes.remove(i);
                storedRecipients.remove(i);
                storedSenders.remove(i);
                storedContents.remove(i);
                System.out.println("Message deleted.");
                return;
            }
        }
        System.out.println("Hash not found.");
    }

    public static void fullReport() {
        if (storedIDs.isEmpty()) { System.out.println("No stored messages."); return; }
        System.out.println("--- Full Stored Messages Report ---");
        for (int i = 0; i < storedIDs.size(); i++) {
            System.out.println("Message ID: " + storedIDs.get(i));
            System.out.println("Hash: " + storedHashes.get(i));
            System.out.println("Sender: " + storedSenders.get(i));
            System.out.println("Recipient: " + storedRecipients.get(i));
            System.out.println("Message: " + storedContents.get(i));
            System.out.println("-----------------------------");
        }
    }

    // JSON LOADING 
    private static void loadMessagesFromJson() {
        File file = new File(JSON_FILE);
        if (!file.exists()) return;

        try (Scanner fileScanner = new Scanner(file)) {
            StringBuilder sb = new StringBuilder();
            while (fileScanner.hasNextLine()) sb.append(fileScanner.nextLine().trim());
            String json = sb.toString();
            if (json.equals("[]") || json.isEmpty()) return;

            String inner = json.substring(1, json.length() - 1);
            String[] parts = inner.split("\\},\\s*\\{");
            for (String part : parts) {
                part = part.replace("{", "").replace("}", "").trim();
                String id = extractJsonValue(part, "messageId");
                String hash = extractJsonValue(part, "hash");
                String recipient = extractJsonValue(part, "recipient");
                String sender = extractJsonValue(part, "sender");
                String content = extractJsonValue(part, "content");
                String status = extractJsonValue(part, "status");

                if ("stored".equals(status)) {
                    storedIDs.add(id);
                    storedHashes.add(hash);
                    storedRecipients.add(recipient);
                    storedSenders.add(sender);
                    storedContents.add(content);
                }
            }
        } catch (IOException e) { }
    }

    private static String extractJsonValue(String block, String key) {
        String search = "\"" + key + "\": \"";
        int start = block.indexOf(search);
        if (start == -1) {
            search = "\"" + key + "\": ";
            start = block.indexOf(search);
            if (start == -1) return "";
            start += search.length();
            int end = block.indexOf(",", start);
            if (end == -1) end = block.length();
            return block.substring(start, end).trim();
        }
        start += search.length();
        int end = block.indexOf("\"", start);
        return block.substring(start, end);
    }

    // JSON SAVING 
    private static void saveMessagesToJson() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(JSON_FILE))) {
            writer.println("[");
            // Save all messages from the main arrays + stored ones (stored are already in main arrays with status)
            for (int i = 0; i < maxMessages; i++) {
                writer.println("  {");
                writer.println("    \"messageId\": \"" + messageIDs[i] + "\",");
                writer.println("    \"hash\": \"" + messageHashes[i] + "\",");
                writer.println("    \"recipient\": \"" + messageRecipients[i] + "\",");
                writer.println("    \"sender\": \"" + registeredFirstName + " " + registeredLastName + "\",");
                writer.println("    \"content\": \"" + escapeJson(messageContents[i]) + "\",");
                writer.println("    \"status\": \"" + messageStatuses[i] + "\"");
                writer.print("  }");
                if (i < maxMessages - 1) writer.println(",");
                else writer.println();
            }
            writer.println("]");
            System.out.println("Messages saved to " + JSON_FILE);
        } catch (IOException e) {
            System.out.println("Error saving messages: " + e.getMessage());
        }
    }

    private static String escapeJson(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}

    
       
    

    
        

