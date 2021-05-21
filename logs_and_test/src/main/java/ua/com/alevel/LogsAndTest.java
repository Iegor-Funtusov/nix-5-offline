package ua.com.alevel;

import java.util.List;

public class LogsAndTest {

    public static void main(String[] args) {
        UserService userService = new UserService();
        System.out.println("LogsAndTest.main");
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("NAME" + i);
            user.setEmail("EMAIL" + i);
            user.setEmail(null);
            userService.create(user);
        }
        List<User> users = userService.findAll();
        System.out.println("users = " + users.size());

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("NAME" + i);
            user.setEmail("EMAIL" + i);
            user.setEmail(null);
            userService.update(user);
        }
    }
}
