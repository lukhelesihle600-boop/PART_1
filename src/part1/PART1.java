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
public class User{ //this class holds the information for the user that is registered
   String Firstname;
   String Lastname;
   String Username;
   String Password;

 public User(String Firstname,String Lastname,String Username,String password){ // we're using th data that has been given to set up the user's profile
     this.Firstname= Fisrtname; //we specify which one of the objects in the first class we use for the registration
     this.Lastname= Lastname;
     this.Username= Username;
     this.Password= Password;
 }
    public boolean login(String createdUsername,String createdPassword){
        return createdUsername.equals(this.Username)&&createdPassword.equals(this.Password); //here we chck if the username and password match the ones the user created
    }
    public String welcomeMessage(){
        return "Welcome" + Firstname + Lastname + "it is great to see you again.";
    }
    
}
public class PART1 {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner=new scanner(System.in);

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

         String Password;
          while(true){
          System.out.println("Please enter your password (your password should contain captial letter,number,a special character and be at least eight characters long");//creation of password
            String userPassword=scanner.nextLine();
              
           boolean eightCharacters= userPassword.length>=8;// the password must be atleast 8 or more characters long

           boolean specialCharacter=false;//we pick false at first because we havent found the special character yet
           boolean containsNumber=false;
           boolean captialLetter=false;


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

             boolean isCorrect= specialCharacter &&containsNumber&&captialLetter&&eightCharacters;// we check wether the password has all the requirements

             if (isCorrect){ //isCorrect is assigned to all the requirements of the password  
                  System.out.println("Password successfully captured");// we output this message when the password meets all the requirements
                  break;
             }else{
                 System.out.println("Pasword is incorrectly formatted;please ensure that the password contains at least eight characters,a special character,a number and a capital letter");// we output this if doesn't
             }
         }
              User newUser= new User(Fisrtname,Lastname,Username,Password); //create new user object
              System.out.println("\nYou have successfully registered\n"); // this will be on its line to create neatness
                  System.out.println("User Login");
                System.out.println("Please enter your username");
                 String loginUsername=scanner.nextLine();
                System.out.println("Please enter your password");
                 String loginPassword=scanner.nextLine();
                     if(newUser.loginUsername,loginPassword){ //newUser is from the new user object that contains the collected information
                       System.out.println("\n" +newUser. welcomeMessage());
                 }else{
                     System.out.println("\nUsername or password is incorrect, please try again");
                 }
        scanner.close();
    }
    
}
