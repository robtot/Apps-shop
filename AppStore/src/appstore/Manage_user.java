/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package appstore;

import java.util.Scanner;

/**
 *
 * @author Valentin
 */
public class Manage_user {
    public static void Registration(){
        //opening Scanner
        Scanner input=new Scanner(System.in);
        //user_input:the variable for what user input
        String user_input;
        //as far as container can't be static I have to create object of UserContainer
        UserContainer container=new UserContainer();
        String[] array={"username","name","address","profession"};
        for(int i=0;i<array.length;i++){
            System.out.println("Please write "+array[i]+":");
            user_input=input.nextLine();
            array[i]=user_input;
        }
        User user=new User(array[0],array[1],array[2],array[3]);
        container.addUser(user);
    }
}