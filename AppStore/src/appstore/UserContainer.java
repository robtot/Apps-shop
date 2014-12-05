/*
 * ALL TRESPASSERS WILL BE PROSEC uuu Ted
 */

package appstore;

import java.util.Iterator;

/**
 *
 * @mage Robert
 */
public class UserContainer extends Container {

    public UserContainer() {
        //uses Container constructor
        super("User");
    }
    
    //calls method from Storage to store users ArrayList in this object
    public void storeUsers(){
        super.storeArrayList();
    }
    
    //adds user to ArrayList and stores new arraylist
    public void addUser(User user){
        super.addObject(user);
        storeUsers();
    }
    
    //searches userlist for 
    public User findUser(String username){
        
        //initializes iterator
        Iterator it = l.iterator();
        
        //checks username while a user exists
        while (it.hasNext()){
            User u = (User) it.next();
            if (u.getUsername().equals(username)){
                return u;
            }
        }
        
        //returns null if no match is found
        return null;
    }
    
    
}
