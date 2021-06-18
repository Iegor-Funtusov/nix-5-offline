package ua.com.alevel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerialTest {

    public void start() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setFirstName("qq");
        user.setLastName("ww");
        user.setFullName("qq ww");
        users.add(user);
        user = new User();
        user.setFirstName("ee");
        user.setLastName("rr");
        user.setFullName("ee rr");
        users.add(user);

        try(
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("users.out"));
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("users.out"))
        ) {
            objectOutputStream.writeObject(users);
            users = (List<User>) objectInputStream.readObject();
            System.out.println("users = " + users);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
