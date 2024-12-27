package controller;

import java.io.*;
import java.util.ArrayList;

public class dataController {
    public static ArrayList<User> userArray = new ArrayList<>();

    public static void retrive() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("CssFiles/store.ser"))) {
            while (true) {
                try {
                    User user = (User) ois.readObject();
                    userArray.add(user);
                } catch (Exception e) {

                }
            }
        } catch (Exception e) {

        }

    }

    public void pushdata() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("CssFiles/store.ser"))) {
            for (User object : userArray) {
                oos.writeObject(object);
            }

        }
    }

    public static boolean validateuserAndpass(String user_name, String password) {
        for (User user : userArray) {
            if (user.getUser_name().equals(user_name)) {
                if (user.getPassword().equals(password)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
