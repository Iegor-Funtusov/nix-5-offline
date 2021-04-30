package ua.com.alevel.app;

import ua.com.alevel.lib.CrudService;
import ua.com.alevel.lib.ListCrudService;

import java.util.Collection;
import java.util.List;

// SOLID
public class AppMain {

    public static void main(String[] args) {
        System.out.println("AppMain.main");

        UserService userService = new UserService();

        User user = new User();
        user.setName("qq");
        user.setAge(10);
        userService.create(user);

        user = new User();
        user.setName("ww");
        user.setAge(20);
        userService.create(user);

        Collection<User> users = userService.read();
        users.forEach(System.out::println);
    }
}
