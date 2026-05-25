/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package part1;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class Login{
   private String userFirstname;
   private String userLastname;
   private String userPassword;
   private String userCellphone;
   private String userUsername;

   private Scanner scanner=new Scanner(System.in);
   
 }
//USERNAME CREATION
  public boolean checkUserName(String Username){ // we create a class that will check the validity of the created username
         return Username!= null&&username.contains("_")&&username.length<=5;
}

     //PASSWORD
    public boolean checkPasswordComplexity(String Password){
     if(Password==null||Password.length()<8){


       int capital = 0;
        int digit = 0;
        int specialcharacter = 0;

         for(int i=0;i<userPassword();i++){ //we loop to check each character of the password that the user has created 
             char character=password.charAt(i);

                 if(Character.isUpperCase(character)){ //now we use to check if we have a capital letter
                    capitalLetter=true;
             }else if(Character.isDigital(character)){ //we check if it has a digit
                 containsNumber=true;
             }else if(Character.isLetterOrDigit(character)){ //we check for a special character
                 specialCharacter=true;
             }
         }
                return capital > 0 && digit > 0 && specialcharacter > 0;
        
//WELCOME MESSAGE
    public String welcomeMessage(){
        return "Welcome" + Firstname + Lastname + "it is great to see you again.";
    }
    
}
  
       //USERNAME
        String userUsername;
           while(true){
        System.out.println("Please create a username (your username should contain an underscore and be no longer than five characters long)");//user input for creation of username
        String Username= scanner.nextLine();
        boolean Underscore= userName.contains("_");
        boolean fiveCharacters= userName.lenght<=5;//the username should contain 5 characters or less

        if(fiveCharacters&& Underscore){
            System.out.println("Username successfully captured");// output of the username created correctly
             break;// if the password is correct we use word break to exit the loop
        }else{
            System.out.println("Username is incorrectly formatted;please ensure that your username contains an underscore and is no longer than five characters long");//output of username created incorrectly
        }

   } 
       //CELLPHONE NUMBER
       public boolean checkCellPhoneNumber(String cellphoneNumber){
            if( cellphoneNumber==null|| cellphoneNumber.startsWith("+")){
            return false;
         }
         String digits=  cellphoneNumber.substring(1);
         if(digits.isEmpty())return false;
         for (char ch:digits.toCharArray()){
            if(!Character.isDigit(ch)) return false;
         }

         int distance=cellphoneNumber.length();
         return distance>=10&&distance<=15;
       
`

             if (isCorrect){ //isCorrect is assigned to all the requirements of the password  
                  System.out.println("Password successfully captured");// we output this message when the password meets all the requirements
                  break;
             }else{
                 System.out.println("Pasword is incorrectly formatted;please ensure that the password contains at least eight characters,a special character,a number and a capital letter");// we output this if doesn't
             }
         }
        
       public String registerUser() {
        System.out.println("USER REGISTRATION");
      
         System.out.println("Please enter your firstname"); //user input 
         String Firstname=scanner.nextLine();
          
         System.out.println("Please enter your lastname);
         String Lastname=scanner.nextLine();

        String Username;
          while(true){
          System.out.println("Please create a username (your username should contain an underscore and be no longer than five characters long)");//user input for creation of username
        String Username= scanner.nextLine();
        boolean Underscore= userName.contains("_");
        boolean fiveCharacters= userName.lenght<=5;//the username should contain 5 characters or less

            
        if(fiveCharacters&& Underscore){
            System.out.println("Username successfully captured");// output of the username created correctly
             break;// if the password is correct we use word break to exit the loop
        }else{
            System.out.println("Username is incorrectly formatted;please ensure that your username contains an underscore and is no longer than five characters long");//output of username created incorrectly
        }

   }
        userUsername =Username;

            String Password;
        while (true) {
            System.out.println("Choose a password (password must contain 8 or more characters, a capital letter, a number and a special character)");
            String Password = scanner.nextLine();
            if ( checkPassword(String Password))break;
            System.out.println("Password is incorrectly formatted;please ensure that the password has at least 8 characters,a captial letter, a number and a special character.");
        }
          userPassword= Password;
          
            String Phone;
        while (true) {
            System.out.println("Please enter your cellphone number (with country code, e.g., +27123456789) ");
            phone = scanner.nextLine();
            if (checkCellphone(String cellphoneNumber)) break;
            System.out.println("Invalid phone number. Try again.");
        }
        userCellphone=Phone;

          public boolean loginUser(String Username, String Password) {
        if (userUsername == null || userPassword == null) return false;
        return enteredUsername.equals(userUsername) &&
               enteredPassword.equals(userPassword);

       public String returnLoginStatus(boolean loginSuccess){
          if(loginSuccess){
        return "Welcome" + Firstname + Lastname + "it is great to see you again.";
       }else{
          return "Password or Username is incorrect.Please try again";
       }
           public void performLogin(){
                System.out.println("--User Login--");
              
                System.out.println("Please enter your username");
                 String loginUserName=scanner.nextLine();
         
                System.out.println("Please enter your password");
                 String loginPassWord=scanner.nextLine();
         
                     if(newUser.loginUsername,loginPassword){ //newUser is from the new user object that contains the collected information
                       System.out.println("\n" +newUser. welcomeMessage());
                 }else{
                     System.out.println("\nUsername or password is incorrect, please try again");

   import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// ==================== LOGIN CLASS ====================
class Login {
    private String registeredFirstName;
    private String registeredLastName;
    private String registeredUsername;
    private String registeredPassword;
    private String registeredPhoneNumber;
    private Scanner scanner;

    // Constructor used by main application
    public Login(Scanner scanner) {
        this.scanner = scanner;
    }

    // Test‑friendly constructor (no Scanner needed for unit tests)
    public Login(String firstName, String lastName, String username, 
                 String password, String phone) {
        this.registeredFirstName = firstName;
        this.registeredLastName = lastName;
        this.registeredUsername = username;
        this.registeredPassword = password;
        this.registeredPhoneNumber = phone;
    }

    /**
     * Validates username: must contain '_' and be ≤ 5 characters.
     */
    public boolean checkUserName(String username) {
        return username != null && 
               username.contains("_") && 
               username.length() <= 5;
    }

    /**
     * Validates password complexity:
     * - At least 8 characters
     * - At least one capital letter
     * - At least one digit
     * - At least one special character
     */
    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        int capitalCount = 0, digitCount = 0, specialCount = 0;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                capitalCount++;
            } else if (Character.isDigit(ch)) {
                digitCount++;
            } else if (!Character.isLetterOrDigit(ch)) {
                specialCount++;
            }
        }

        return capitalCount > 0 && digitCount > 0 && specialCount > 0;
    }

    /**
     * Validates cell phone number:
     * - Must start with '+'
     * - After '+', only digits
     * - Total length between 10 and 15 characters
     */
    public boolean checkCellPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.startsWith("+")) {
            return false;
        }

        String digits = phoneNumber.substring(1);
        if (digits.isEmpty()) {
            return false;
        }

        for (char ch : digits.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        int len = phoneNumber.length();
        return len >= 10 && len <= 15;
    }

    /**
     * Full registration process with input validation loops.
     */
    public void registerUser() {
        System.out.println("====================");
        System.out.println("   USER REGISTRATION");
        System.out.println("====================");

        // First Name
        System.out.print("Enter first name: ");
        registeredFirstName = scanner.nextLine();

        // Last Name
        System.out.print("Enter last name: ");
        registeredLastName = scanner.nextLine();

        // Username (loops until valid)
        while (true) {
            System.out.print("Choose a username (must contain '_' and be ≤ 5 chars): ");
            String username = scanner.nextLine();
            if (checkUserName(username)) {
                registeredUsername = username;
                break;
            }
            System.out.println("Username is not correctly formatted; please ensure that your " +
                               "username contains an underscore and is no more than five characters in length.");
        }

        // Password (loops until valid)
        while (true) {
            System.out.print("Choose a password (8+ chars, capital, digit, special): ");
            String password = scanner.nextLine();
            if (checkPasswordComplexity(password)) {
                registeredPassword = password;
                break;
            }
            System.out.println("Password is not correctly formatted; please ensure that the " +
                               "password contains at least eight characters, a capital letter, " +
                               "a number, and a special character.");
        }

        // Cell Phone (loops until valid)
        while (true) {
            System.out.print("Enter cell phone number (e.g., +27123456789): ");
            String phone = scanner.nextLine();
            if (checkCellPhoneNumber(phone)) {
                registeredPhoneNumber = phone;
                break;
            }
            System.out.println("Cell phone number incorrectly formatted; please ensure it " +
                               "starts with '+' followed by the country code and contains only digits.");
        }

        System.out.println("\n✅ Registration successful!\n");
    }

    /**
     * Verifies login credentials against stored registration data.
     */
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        if (registeredUsername == null || registeredPassword == null) {
            return false;
        }
        return enteredUsername.equals(registeredUsername) && 
               enteredPassword.equals(registeredPassword);
    }

    /**
     * Returns the appropriate login status message.
     */
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + registeredFirstName + ", " + registeredLastName + 
                   " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // Getters
    public String getFirstName() { return registeredFirstName; }
    public String getLastName()  { return registeredLastName; }
}

// ==================== MESSAGE CLASS ====================
class Message {
    private static int nextMessageNumber = 1;
    private static Random random = new Random();

    private String messageId;      // 10‑digit random ID
    private int messageNumber;     // Sequential number (auto‑increment)
    private String recipient;      // Validated cell number
    private String content;        // Message text (≤250 characters)
    private String hash;           // Generated hash (all caps)
    private String status;         // "sent", "stored", or "disregarded"

    /**
     * Creates a new message with the given recipient and content.
     * Message ID, message number, and hash are generated automatically.
     */
    public Message(String recipient, String content) {
        this.recipient = recipient;
        this.content = content;
        this.messageNumber = nextMessageNumber++;
        this.messageId = generateMessageId();
        this.hash = generateHash();
        this.status = "pending";
    }

    /**
     * Generates a random 10‑digit message ID (padded with leading zeros if needed).
     */
    private String generateMessageId() {
        int num = random.nextInt(1_000_000_000);   // 0 to 999,999,999
        return String.format("%010d", num);        // Pads to exactly 10 digits
    }

    /**
     * Validates recipient: must start with '+', contain only digits,
     * and be ≤ 10 characters total.
     */
    public static boolean validateRecipient(String phone) {
        if (phone == null || !phone.startsWith("+")) {
            return false;
        }

        String digits = phone.substring(1);
        if (digits.isEmpty()) {
            return false;
        }

        for (char ch : digits.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return phone.length() <= 10;   // Including the '+'
    }

    /**
     * Validates that the message content is ≤ 250 characters.
     */
    public static boolean validateMessageLength(String msg) {
        return msg != null && msg.length() <= 250;
    }

    /**
     * Generates the message hash:
     * First two digits of Message ID + ":" + Message Number + " " + First Word + " " + Last Word
     * All in uppercase.
     */
    private String generateHash() {
        String firstTwoDigits = messageId.substring(0, 2);
        String firstWord = getFirstWord(content);
        String lastWord = getLastWord(content);
        return (firstTwoDigits + ":" + messageNumber + " " + firstWord + " " + lastWord)
               .toUpperCase();
    }

    /**
     * Returns the first word of a text string.
     */
    private String getFirstWord(String text) {
        String trimmed = text.trim();
        int spaceIndex = trimmed.indexOf(' ');
        return (spaceIndex == -1) ? trimmed : trimmed.substring(0, spaceIndex);
    }

    /**
     * Returns the last word of a text string.
     */
    private String getLastWord(String text) {
        String trimmed = text.trim();
        int lastSpace = trimmed.lastIndexOf(' ');
        return (lastSpace == -1) ? trimmed : trimmed.substring(lastSpace + 1);
    }

    // Getters and Setters
    public void setStatus(String status) { this.status = status; }
    public String getStatus()            { return status; }
    public String getMessageId()         { return messageId; }
    public String getHash()              { return hash; }
    public String getRecipient()         { return recipient; }
    public String getContent()           { return content; }
    public int getMessageNumber()        { return messageNumber; }

    /**
     * Returns a JSON representation of this message.
     */
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

    /**
     * Escapes special characters for valid JSON output.
     */
    private String escapeJson(String s) {
        return s.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\t", "\\t");
    }
}

// ==================== MAIN APPLICATION ====================
public class QuickChat {
    // Store all messages for JSON output
    private static ArrayList<Message> allMessages = new ArrayList<>();
    // Store only sent messages for display
    private static ArrayList<Message> sentMessages = new ArrayList<>();
    private static final String JSON_FILE = "messages.json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login loginSystem = new Login(scanner);

        // ----- REGISTRATION & LOGIN -----
        loginSystem.registerUser();

        // Login loop (keeps asking until correct credentials)
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("=== LOGIN ===");
            System.out.print("Enter username: ");
            String loginUser = scanner.nextLine();
            System.out.print("Enter password: ");
            String loginPass = scanner.nextLine();

            loggedIn = loginSystem.loginUser(loginUser, loginPass);
            System.out.println("\n" + loginSystem.returnLoginStatus(loggedIn));

            if (!loggedIn) {
                System.out.println();   // blank line before next attempt
            }
        }

        // ----- WELCOME & MAIN MENU -----
        System.out.println("\nWelcome to Quick Chat");

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
                    System.out.println("Goodbye " + loginSystem.getFirstName() + "! 👋");
                    break;
                default:
                    System.out.println("Invalid option. Please enter 1-4.");
            }
        }

        // Save all messages to JSON file before exiting
        saveMessagesToJson();
        scanner.close();
    }

    /**
     * Handles the complete message‑creation flow:
     * 1. Validate recipient
     * 2. Validate message content
     * 3. Present send/disregard/store options
     */
    private static void sendMessage(Scanner scanner) {
        // Step 1: Recipient validation
        String recipient;
        while (true) {
            System.out.print("Enter recipient cell number (start with '+', max 10 chars): ");
            recipient = scanner.nextLine();
            if (Message.validateRecipient(recipient)) {
                break;
            }
            System.out.println("Invalid recipient. Must start with '+' and contain only digits, " +
                               "max 10 characters total.");
        }

        // Step 2: Message content validation
        String content;
        while (true) {
            System.out.print("Enter your message (max 250 characters): ");
            content = scanner.nextLine();
            if (Message.validateMessageLength(content)) {
                break;
            }
            System.out.println("Please enter a message of less than 250 characters.");
        }

        // Create the message object
        Message msg = new Message(recipient, content);
        allMessages.add(msg);

        // Show composed message details
        System.out.println("\n📝 Message Composed:");
        System.out.println("  Message ID: " + msg.getMessageId());
        System.out.println("  Message Hash: " + msg.getHash());
        System.out.println("  Recipient: " + recipient);
        System.out.println("  Content: " + content);

        // Step 3: Choose action
        boolean validChoice = false;
        while (!validChoice) {
            System.out.println("\nChoose an action:");
            System.out.println("  1 – Send message");
            System.out.println("  0 – Disregard / Delete message");
            System.out.println("  2 – Store message to send later");
            System.out.print("Your choice: ");
            String action = scanner.nextLine();

            switch (action) {
                case "1":
                    msg.setStatus("sent");
                    sentMessages.add(msg);
                    System.out.println("✅ Message successfully sent.");
                    validChoice = true;
                    break;
                case "0":
                    msg.setStatus("disregarded");
                    System.out.println("🗑️  Message deleted.");
                    validChoice = true;
                    break;
                case "2":
                    msg.setStatus("stored");
                    System.out.println("💾 Message successfully stored.");
                    validChoice = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 0, or 2.");
            }
        }
    }

    /**
     * Displays all sent messages in the required order:
     * Message ID, Message Hash, Recipient, Message
     */
    private static void showSentMessages() {
        if (sentMessages.isEmpty()) {
            System.out.println("📭 No sent messages yet.");
            return;
        }
        System.out.println("\n--- 📨 Sent Messages ---");
        for (Message m : sentMessages) {
            System.out.println("Message ID: " + m.getMessageId());
            System.out.println("Message Hash: " + m.getHash());
            System.out.println("Recipient: " + m.getRecipient());
            System.out.println("Message: " + m.getContent());
            System.out.println("-------------------");
        }
    }

    /**
     * Displays all stored (unsent) messages.
     */
    private static void showStoredMessages() {
        ArrayList<Message> stored = new ArrayList<>();
        for (Message m : allMessages) {
            if (m.getStatus().equals("stored")) {
                stored.add(m);
            }
        }
        if (stored.isEmpty()) {
            System.out.println("📭 No stored messages.");
            return;
        }
        System.out.println("\n--- 💾 Stored Messages ---");
        for (Message m : stored) {
            System.out.println("Message ID: " + m.getMessageId());
            System.out.println("Message Hash: " + m.getHash());
            System.out.println("Recipient: " + m.getRecipient());
            System.out.println("Message: " + m.getContent());
            System.out.println("-------------------");
        }
    }

    /**
     * Writes all messages (sent, stored, disregarded) to a JSON file.
     */
    private static void saveMessagesToJson() {
        try (FileWriter writer = new FileWriter(JSON_FILE)) {
            writer.write("[\n");
            for (int i = 0; i < allMessages.size(); i++) {
                writer.write(allMessages.get(i).toJson());
                if (i < allMessages.size() - 1) {
                    writer.write(",\n");
                } else {
                    writer.write("\n");
                }
            }
            writer.write("]\n");
            System.out.println("\n💾 Messages saved to " + JSON_FILE);
        } catch (IOException e) {
            System.out.println("❌ Error saving messages: " + e.getMessage());
        }
    }
}

     
public class PART1 {
    

    /**
     * @param args the command line arguments
     */
     
    public static void main(String[] args) {
        // TODO code application logic here
             Login loginSystem = new Login();
        loginSystem.registeredUser();    // Handles all registration input
        loginSystem.loginUser();    // handles login input and details
       
        loginSystem.scanner.close();
                 
    }
    
}
