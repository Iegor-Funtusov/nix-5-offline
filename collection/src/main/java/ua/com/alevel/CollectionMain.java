package ua.com.alevel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionMain {

    public static void main(String[] args) {
        System.out.println("CollectionMain.main");

        List<String> strings = Arrays.asList("q", "w", "e");
        List<String> list = strings.stream()
                .distinct()
                .filter(s -> s.equals("w"))
                .sorted()
                .skip(3)
                .collect(Collectors.toList());

        System.out.println("list = " + list);

//        ListClass listClass = new ListClass();
//        listClass.test();
//        SetClass setClass = new SetClass();
//        setClass.test();
//        new MapClass().test();
    }
}
