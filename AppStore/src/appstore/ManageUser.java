/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package appstore;

import appstore.containers.UserContainer;
import java.util.Scanner;

/**
 *
 * @author Valentin
 */
public class ManageUser {
    //Login class that is asking for the correct login until it is correct or user typed exit
    public static User Login() {
        UserContainer container=new UserContainer();
        System.out.println("Write down your username,please:");
        Scanner input=new Scanner(System.in);
        //the input of the user
        String user_input;
        //the loop return 
        do{
        user_input=input.nextLine();
        if(container.find(user_input)!=null){
            return container.find(user_input);
        }
        else{
            System.out.println("Wrong username.\n"
                    + "Type exit to go to the main menu.\n"
                    + "Please try again:");
        }
        }while(user_input.equals("exit"));
        return null;
    }
    public static void Registration(){
        //opening Scanner
        Scanner input=new Scanner(System.in);
        //user_input:the variable for what user input
        String user_input;
        //as far as container can't be static I have to create object of UserContainer
        UserContainer container=new UserContainer();
        //the array that will be overwritten by the real values in "for" loop.
        String[] array={"username","name","address","profession"};
        //the next loop overwrite array above with real values.For example element "username" will have have the the real username of user
        for(int i=0;i<array.length;i++){
            //display menu
            System.out.println("Please write "+array[i]+":");
            //ask for input until it meets Validation criteria
            do{
            user_input=input.nextLine();
            }while(Validation(array[i],user_input));
            //push the user input at the following array position
            array[i]=user_input;
        }
        //create an object of type User which has the info from the registration(our registered user)
        User user=new User(array[0],array[1],array[2],array[3]);
        //add registered user to the array of all users
        container.add(user);
        //saves changes made to user array into file
        container.store();
    }
    public static boolean Validation(String key,String value){
        String[] censored_words={"fuck","suck","wanker","noob","dick"};
        for (String censored_word : censored_words) {
            if (value.contains(censored_word)) {
                System.out.println("You can't use censored words.");
                return true;
            }
        }
        UserContainer container= new UserContainer();
        switch(key){
            case "username":
                if(container.find(value)!=null){
                    System.out.println("The username: "+value+" belongs to another user. Please write another name:");
                    return true;
                }
                else if(value == null||value.contains(" ")||value.isEmpty()||value.length()>10){
                    System.out.println("Your username must not have free spaces,be empty or has more than 10 characters.Please write your name again:");
                    return true;
                }
                else if(value.length()<5){
                    System.out.println("Username is too short. Please type your name again: ");
                    return true;
                }
                return false;
                
            case "name":
                if(value == null||value.isEmpty()){
                    System.out.println("Your name is required.Please type your name:");
                }
                else if(value == null||value.contains("#")|| value.contains("*") || value.contains("$")){
                   System.out.println("Your name cannot contain numbers or symbols, it should only contain characters. Please write your name again:");
                   return true;
                }
                return false;
                
            case "address":
                if(value == null||value.isEmpty()){
                    System.out.println("The address can't be empty.Please write your address again:");
                    return true;
                }
                return false;
                
            case "profession":
                if(value.equals("student")){
                    System.out.println("Great news! You are eligible for a 25% discount:)");
                    return false;
                }
                else if(value.isEmpty()||value == null){
                    System.out.println("The profession can't be empty.Please write your profession again:");
                    return true;
                }
                return false;
        }
        return false;
    }
}
