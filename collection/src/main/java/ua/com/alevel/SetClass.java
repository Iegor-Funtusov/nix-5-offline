package ua.com.alevel;

import java.util.*;

public class SetClass {

    public void test() {
        System.out.println("HashSet");

        Set<User> users = new HashSet<>();
        users.add(new User("qqq"));
        users.add(new User("www"));
        users.add(new User("eee"));
        users.add(new User("qqq"));

        users.forEach(System.out::println);

        System.out.println("LinkedHashSet");

        users = new LinkedHashSet<>();
        users.add(new User("qqq", 10));
        users.add(new User("www", 11));
        users.add(new User("eee", 12));
        users.add(new User("qqq", 13));

        users.forEach(System.out::println);

        System.out.println("TreeSet");

        users = new TreeSet<>();
        users.add(new User("qqqq", 44));
        users.add(new User("www", 2));
        users.add(new User("eee", 3));
        users.add(new User("qqq", 44));

        users.forEach(System.out::println);
    }
}
