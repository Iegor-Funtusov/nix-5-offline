package ua.com.alevel;

import java.util.*;

public class SetClass {

    private static final Integer SIZE = 10_000_000;

    public void test() {
        System.out.println("HashSet");

        long start = System.currentTimeMillis();
        Set<User> users = new HashSet<>();
        for (int i = 0; i < SIZE; i++) {
            users.add(new User(Integer.toString(i)));
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("end added = " + end);

        System.out.println("LinkedHashSet");

        users = new LinkedHashSet<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            users.add(new User(Integer.toString(i)));
        }
        end = System.currentTimeMillis() - start;
        System.out.println("end added = " + end);

        System.out.println("TreeSet");

        users = new TreeSet<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            users.add(new User(Integer.toString(i)));
        }
        end = System.currentTimeMillis() - start;
        System.out.println("end added = " + end);
    }
}
