package ua.com.alevel;

import java.util.*;

public class ListClass {

    private static final Integer SIZE = 1_000_000;

    public void test() {
//        List<Integer> listArrayList = new ArrayList<>();
        // add O(1)
        // get O(1)
        // remove O(n)
//        LinkedList<Integer> listLinkedList = new LinkedList<>();
        // add O(1)
        // get O(n)
        // remove O(n)

//        System.out.println("ADD");
//
//        long start = System.currentTimeMillis();
//
//        for (int i = 0; i < SIZE; i++) {
//            listArrayList.add(i);
//        }
//
//        long end = System.currentTimeMillis() - start;
//        System.out.println("end ArrayList = " + end);
//
//        start = System.currentTimeMillis();
//
//        for (int i = 0; i < SIZE; i++) {
//            listLinkedList.add(i);
//        }
//
//        end = System.currentTimeMillis() - start;
//        System.out.println("end LinkedList = " + end);

//        System.out.println("GET");
//
//        start = System.currentTimeMillis();
//
//        for (int i = 0; i < SIZE; i++) {
//            listArrayList.get(i);
//        }
//
//        end = System.currentTimeMillis() - start;
//        System.out.println("end ArrayList = " + end);
//
//        start = System.currentTimeMillis();
//
//        for (int i = 0; i < SIZE; i++) {
//            listLinkedList.get(i);
//        }
//
//        end = System.currentTimeMillis() - start;
//        System.out.println("end LinkedList = " + end);

//        System.out.println("DELETE");
//
//        start = System.currentTimeMillis();
//
//        Iterator<Integer> iterator = listArrayList.listIterator();
//        while (iterator.hasNext()) {
//            iterator.next();
//            iterator.remove();
//        }
//
//        end = System.currentTimeMillis() - start;
//        System.out.println("end ArrayList = " + end);
//
//        start = System.currentTimeMillis();
//
//        iterator = listLinkedList.listIterator();
//        while (iterator.hasNext()) {
//            iterator.next();
//            iterator.remove();
//        }
//
//        end = System.currentTimeMillis() - start;
//        System.out.println("end LinkedList = " + end);

        List<User> users = new ArrayList<>();
        users.add(new User("qqq", 1));
        users.add(new User("www", 2));
        users.add(new User("eee", 3));
        users.add(new User("qqq", 4));

        Collections.sort(users);

        users.forEach(System.out::println);
    }
}
