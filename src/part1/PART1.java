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
