package ua.com.alevel;

import java.util.List;

public class LogsAndTest {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        System.out.println("LogsAndTest.main");
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("NAME" + i);
            userDao.create(user);
        }
        List<User> users = userDao.findAll();
        System.out.println("users = " + users.size());
    }
}
