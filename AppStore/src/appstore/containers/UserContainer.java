/*
 * ALL TRESPASSERS WILL BE PROS
 */

package appstore.containers;

import appstore.User;
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
    public void store(){
        super.storeArrayList();
    }
    
    //adds user to ArrayList and stores new arraylist
    public void add(User user){
        //checks if username already exists
        if (this.find(user.getUsername())==null){
            super.add(user);
        }
    }
    
    //searches userlist for username
    public User find(String username){
        
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
    
    //deletes user with given username
    public void delete(String username){
        User u = this.find(username);
        l.remove(u);
    }
    
    
    
}
