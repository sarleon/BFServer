package ControlCenter;

import DB.User;

import java.util.ArrayList;

/**
 * Created by sarleon on 16-5-6.
 */
public class UserController {
    private static UserController ourInstance = new UserController();

    public static UserController getInstance() {
        return ourInstance;
    }

    private UserController() {
    }

    private ArrayList<String> currentUsers=new ArrayList<String >();

    public void userLogin(User user){
        currentUsers.add(user.getUsername());
        for (int i = 0; i < currentUsers.size(); i++) {
            System.out.println(currentUsers.get(i));
        }
    }

    public void userLogout(String  username){
        for (int i = 0; i < currentUsers.size(); i++) {
            if(currentUsers.get(i).equals(username)){
                currentUsers.remove(i);
            }
        }
    }
}
