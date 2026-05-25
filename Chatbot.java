/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package part1;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

 public class QuickChat {

    
    private static ArrayList<Message> allMessages = new ArrayList<>();
    private static ArrayList<Message> sentMessages = new ArrayList<>();
    private static final String JSON_FILE = "messages.json";

    private static String registeredFirstName;
    private static String registeredLastName;
    private static String registeredUsername;
    private static String registeredPassword;
    private static String registeredPhoneNumber;

/**
 *
 * @author Student
 */
public class PART1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);

        // Registration
        registerUser(scanner);

        // Login
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("=== LOGIN ===");
            System.out.print("Enter username: ");
            String loginUser = scanner.nextLine();
            System.out.print("Enter password: ");
            String loginPass = scanner.nextLine();

            loggedIn = loginUser(loginUser, loginPass);
            System.out.println(returnLoginStatus(loggedIn));
        }

   
    
      System.out.println("\nWelcome to Quick Chat");

        // Menu
        boolean quit = false;
        while (!quit) {
            System.out.println("\n=== QUICK CHAT MENU ===");
            System.out.println("1. Send a message");
            System.out.println("2. Show sent messages");
            System.out.println("3. Show stored messages");
            System.out.println("4. Quit");
            System.out.print("Choose an option (1-4): ");
            String choice = scanner.nextLine();
    
switch (choice) {
                case "1":
                    sendMessage(scanner);
                    break;
                case "2":
                    showSentMessages();
                    break;
                case "3":
                    showStoredMessages();
                    break;
                case "4":
                    quit = true;
                    System.out.println("Goodbye " + registeredFirstName + "!");
                    break;
                default:
                    System.out.println("Invalid option. Please enter 1-4.");
            }
        }

        saveMessagesToJson();
        scanner.close();
    }

    // ==================== HELPER METHODS ====================

    private static void registerUser(Scanner scanner) {
        System.out.println("=== USER REGISTRATION ===");
        System.out.print("Enter first name: ");
        registeredFirstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        registeredLastName = scanner.nextLine();

        while (true) {
            System.out.print("Choose a username (must contain '_' and be ≤ 5 chars): ");
            String username = scanner.nextLine();
            if (checkUserName(username)) {
                registeredUsername = username;
                break;
            }
            System.out.println("Invalid username. Try again.");
        }

        while (true) {
            System.out.print("Choose a password (8+ chars, capital, number, special): ");
            String password = scanner.nextLine();
            if (checkPasswordComplexity(password)) {
                registeredPassword = password;
                break;
            }
            System.out.println("Invalid password. Try again.");
        }

        while (true) {
            System.out.print("Enter cell phone number (e.g., +27123456789): ");
            String phone = scanner.nextLine();
            if (checkCellPhoneNumber(phone)) {
                registeredPhoneNumber = phone;
                break;
            }
            System.out.println("Invalid phone number. Try again.");
        }

        System.out.println("\nRegistration successful!\n");
    }

    private static boolean checkUserName(String username) {
        if (username == null) return false;
        return username.contains("_") && username.length() <= 5;
    }

    private static boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) return false;
        int capitalCount = 0, digitCount = 0, specialCount = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (ch >= 'A' && ch <= 'Z') capitalCount++;
            else if (ch >= '0' && ch <= '9') digitCount++;
            else if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))) specialCount++;
        }
        return capitalCount > 0 && digitCount > 0 && specialCount > 0;
    }

    private static boolean checkCellPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.startsWith("+")) return false;
        String digits = phoneNumber.substring(1);
        if (digits.isEmpty()) return false;
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) < '0' || digits.charAt(i) > '9') return false;
        }
        int len = phoneNumber.length();
        return len >= 10 && len <= 15;
    }

    private static boolean loginUser(String enteredUsername, String enteredPassword) {
        if (registeredUsername == null || registeredPassword == null) return false;
        return enteredUsername.equals(registeredUsername) && enteredPassword.equals(registeredPassword);
    }

    private static String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + registeredFirstName + ", " + registeredLastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    private static void sendMessage(Scanner scanner) {
        String recipient;
        while (true) {
            System.out.print("Enter recipient cell number (start with '+', max 10 chars): ");
            recipient = scanner.nextLine();
            if (validateRecipient(recipient)) break;
            System.out.println("Invalid recipient.");
        }

        String content;
        while (true) {
            System.out.print("Enter your message (max 250 characters): ");
            content = scanner.nextLine();
            if (validateMessageLength(content)) break;
            System.out.println("Please enter a message of less than 250 characters.");
        }

        Message msg = new Message(recipient, content);
        allMessages.add(msg);

        System.out.println("\n--- Message Composed ---");
        System.out.println("Message ID: " + msg.getMessageId());
        System.out.println("Message Hash: " + msg.getHash());

        boolean validChoice = false;
        while (!validChoice) {
            System.out.println("\nChoose an action:");
            System.out.println("  1 - Send message");
            System.out.println("  0 - Disregard / Delete message");
            System.out.println("  2 - Store message to send later");
            System.out.print("Your choice: ");
            String action = scanner.nextLine();

            switch (action) {
                case "1":
                    msg.setStatus("sent");
                    sentMessages.add(msg);
                    System.out.println("Message successfully sent.");
                    validChoice = true;
                    break;
                case "0":
                    msg.setStatus("disregarded");
                    System.out.println("Message deleted.");
                    validChoice = true;
                    break;
                case "2":
                    msg.setStatus("stored");
                    System.out.println("Message successfully stored.");
                    validChoice = true;
                    break;
                default:
                    System.out.println("Invalid choice. Enter 1, 0, or 2.");
            }
        }
    }

    private static boolean validateRecipient(String phone) {
        if (phone == null || !phone.startsWith("+")) return false;
        String digits = phone.substring(1);
        if (digits.isEmpty()) return false;
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) < '0' || digits.charAt(i) > '9') return false;
        }
        return phone.length() <= 10;
    }

    private static boolean validateMessageLength(String msg) {
        return msg != null && msg.length() <= 250;
    }

    private static void showSentMessages() {
        if (sentMessages.isEmpty()) {
            System.out.println("No sent messages yet.");
            return;
        }
        System.out.println("\n--- Sent Messages ---");
        for (Message m : sentMessages) {
            System.out.println("Message ID: " + m.getMessageId());
            System.out.println("Message Hash: " + m.getHash());
            System.out.println("Recipient: " + m.getRecipient());
            System.out.println("Message: " + m.getContent());
            System.out.println("-------------------");
        }
    }

    private static void showStoredMessages() {
        ArrayList<Message> stored = new ArrayList<>();
        for (Message m : allMessages) {
            if (m.getStatus().equals("stored")) stored.add(m);
        }
        if (stored.isEmpty()) {
            System.out.println("No stored messages.");
            return;
        }
        System.out.println("\n--- Stored Messages ---");
        for (Message m : stored) {
            System.out.println("Message ID: " + m.getMessageId());
            System.out.println("Message Hash: " + m.getHash());
            System.out.println("Recipient: " + m.getRecipient());
            System.out.println("Message: " + m.getContent());
            System.out.println("-------------------");
        }
    }

    private static void saveMessagesToJson() {
        try (FileWriter writer = new FileWriter(JSON_FILE)) {
            writer.write("[\n");
            for (int i = 0; i < allMessages.size(); i++) {
                writer.write(allMessages.get(i).toJson());
                if (i < allMessages.size() - 1) writer.write(",\n");
                else writer.write("\n");
            }
            writer.write("]\n");
            System.out.println("Messages saved to " + JSON_FILE);
        } catch (IOException e) {
            System.out.println("Error saving messages: " + e.getMessage());
        }
    }

    // ==================== INNER MESSAGE CLASS ====================
    static class Message {
        private static int nextMessageNumber = 1;
        private static Random random = new Random();

        private String messageId;
        private int messageNumber;
        private String recipient;
        private String content;
        private String hash;
        private String status;

        public Message(String recipient, String content) {
            this.recipient = recipient;
            this.content = content;
            this.messageNumber = nextMessageNumber++;
            this.messageId = generateMessageId();
            this.hash = generateHash();
            this.status = "pending";
        }

        private String generateMessageId() {
            int num = random.nextInt(1_000_000_000);
            return String.format("%010d", num);
        }

        private String generateHash() {
            String firstTwoDigits = messageId.substring(0, 2);
            String firstWord = getFirstWord(content);
            String lastWord = getLastWord(content);
            return (firstTwoDigits + ":" + messageNumber + " " + firstWord + " " + lastWord).toUpperCase();
        }

        private String getFirstWord(String text) {
            String trimmed = text.trim();
            int spaceIndex = trimmed.indexOf(' ');
            return (spaceIndex == -1) ? trimmed : trimmed.substring(0, spaceIndex);
        }

        private String getLastWord(String text) {
            String trimmed = text.trim();
            int lastSpace = trimmed.lastIndexOf(' ');
            return (lastSpace == -1) ? trimmed : trimmed.substring(lastSpace + 1);
        }

        public void setStatus(String status) { this.status = status; }
        public String getStatus() { return status; }
        public String getMessageId() { return messageId; }
        public String getHash() { return hash; }
        public String getRecipient() { return recipient; }
        public String getContent() { return content; }
        public int getMessageNumber() { return messageNumber; }

        public String toJson() {
            return "  {\n" +
                   "    \"messageId\": \"" + messageId + "\",\n" +
                   "    \"messageNumber\": " + messageNumber + ",\n" +
                   "    \"recipient\": \"" + recipient + "\",\n" +
                   "    \"content\": \"" + escapeJson(content) + "\",\n" +
                   "    \"hash\": \"" + hash + "\",\n" +
                   "    \"status\": \"" + status + "\"\n" +
                   "  }";
        }

        private String escapeJson(String s) {
            return s.replace("\\", "\\\\").replace("\"", "\\\"");
        }
    }
}
 }

 

