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
public class PART1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner=new scanner(System.in);
        System.out.println("Please create a username (your username should contain an underscore and be no longer than five characters long");
        String userName= scanner.nextLine();
        boolean Underscore= userName.contains("_");
        boolean fiveCharacters= userName.lenght<=5;

        if(fiveCharacters&& Underscore){
            System.out.println("Username successfully captured");
        }else{
            System.out.println("Username is incorrectly formatted;please ensure that your username contains an underscore and is no longer than five characters long")
        }
       System.out.println("Please enter your password (your password should contain captial letter,number,a special character and be at least eight characters long");
        String userPassword=scanner.nextLine();
        boolean specialCharacter=false;
        boolean containsNumber=false;
        boolean captialLetter=false;
        boolean eightCharacters= userPassword.length>=8;

         for(int i=0;i<userPassword();i++){
             char character=password.charAt(i):

                 if(Character.isUpperCase(character)){
                    capitalLetter=true;
             }else if(Character.isDigital(character)){
                 containsNumber=true;
             }else if(Character.isLetterOrDigit(character)){
                 specialCharacter=true;
             }

             boolean isCorrect= specialCharacter &&containsNumber&&captialLetter&&eightCharacters;

             if (isCorrect){
                 System.out.println("Password successfully captured");
             }else{
                 System.out.println("Pasword is incorrectly formatted;please ensure that the password contains at least eight characters,a special character,a number and a capital letter");
             }
        scanner.close();
    }
    
}
