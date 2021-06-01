package ua.com.alevel;

import java.util.*;

public class MapClass {

    private static final Integer SIZE = 10_000_000;

    public void test() {

        long start = 0;
        long end = 0;

        System.out.println("HashMap");

        Map<String, User> userMap = new HashMap<>();

        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            userMap.put(Integer.toString(i), new User("qqq" + i));
        }
        end = System.currentTimeMillis() - start;
        System.out.println("end added = " + end);

        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            userMap.get(Integer.toString(i));
        }
        end = System.currentTimeMillis() - start;
        System.out.println("end getting = " + end);
//        userMap.forEach((k, v) -> {
//            System.out.println("k = " + k);
//            System.out.println("v = " + v);
//        });

        System.out.println("LinkedHashMap");

        userMap = new LinkedHashMap<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            userMap.put(Integer.toString(i), new User("qqq" + i));
        }
        end = System.currentTimeMillis() - start;
        System.out.println("end added = " + end);

        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            userMap.get(Integer.toString(i));
        }
        end = System.currentTimeMillis() - start;
        System.out.println("end getting = " + end);
//        userMap.forEach((k, v) -> {
//            System.out.println("k = " + k);
//            System.out.println("v = " + v);
//        });

        System.out.println("TreeMap");

        userMap = new TreeMap<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            userMap.put(Integer.toString(i), new User("qqq" + i));
        }
        end = System.currentTimeMillis() - start;
        System.out.println("end added = " + end);

        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            userMap.get(Integer.toString(i));
        }
        end = System.currentTimeMillis() - start;
        System.out.println("end getting = " + end);
//        userMap.forEach((k, v) -> {
//            System.out.println("k = " + k);
//            System.out.println("v = " + v);
//        });
    }
}
