package ua.com.alevel;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class StringDemo {

    static public class A {}
    private class AA {}
    protected class AAA {}
    class AAAA {}
    static class AAAAA {}
    final class AAAAAA {}
    static abstract class AAAAAAA {}

    static class B extends AAAAAAA { }

    StringDemo() { }

    public String ss = "";
    StringDemo stringDemo;

    public void test1() {
        A a = new A();
    }

    public static void test() {
        final int i = 10;
        StringDemo stringDemo = new StringDemo();
    }

    public static void main(String[] args) {
        System.out.println("StringDemo.main");


//        System.currentTimeMillis();

//        int i;

//        String s = " ";
//        byte[] ints = s.getBytes(StandardCharsets.UTF_8);
//        for (byte anInt : ints) {
//            System.out.println("anInt = " + anInt);
//        }

//        System.out.println("s = " + s.isEmpty());
//        System.out.println("s = " + s.isBlank());

//        String s = "he12llo3";

//        s = s.replaceAll("[0-9]", "");

//        String s = "hElLo";
//
//        StringBuilder builder = new StringBuilder(s);
//
//        s = builder.reverse().toString();
//
//        System.out.println("s = " + s);

//        s = s.toLowerCase();
//        System.out.println("s = " + s);
//
//        s = s.toUpperCase();
//        System.out.println("s = " + s);

//        s = s.substring(1, 3);
//        System.out.println("s = " + s);


//        String[] strings = s.split("\\s+");
//        String[] strings = s.split("\\t+");
//        System.out.println("strings = " + strings.length);
//        for (String string : strings) {
//            System.out.println("string = " + string);
//        }

//        s = s.replaceAll(" ", "");
//        System.out.println("s = " + s);
//        s = s.replace("1", "");
//        s = s.replace("3", "");
//        System.out.println("s = " + s);

//        s = s.replace('h', 't');
//        System.out.println("s = " + s);
//
//        s = s.replaceAll("te", "vv");
//        System.out.println("s = " + s);

//        char[] chars = s.toCharArray();
//        for (char aChar : chars) {
//            System.out.println("aChar = " + aChar);
//        }

//        int length = s.length();
//        System.out.println("length = " + length);


        Map<String, String> map = new HashMap<>();
        StringBuilder sql = new StringBuilder("select p from Product p");
        if (!map.isEmpty()) {
            sql.append(" where ");
            map.forEach((key, value) -> {
                sql.append(key)
                        .append(" = ")
                        .append(value);
            });
        }
    }
}
