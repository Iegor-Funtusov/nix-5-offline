package ua.com.alevel;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class BaseMain {

    private static void test() {}
//    private static void test(int ... a) {}
    private static void test(int[] a) {}

    private static void arr(int[] ... ints) {
        test();
    }

    public static void main(String ... args) {
        int[][] bb = new int[10][];
        arr(bb);
        arr(new int[10], new int[10], new int[10]);

//        System.out.println("BaseMain.main");
//        System.out.println(2.0 - 1.1);
//        System.out.println(new BigDecimal("2.0").subtract(new BigDecimal("1.1")));
//        primitive();
//        binary();
//        final double coeff = 5.4;
//
//        byte b = 10;
//        b *= coeff;
//        System.out.println(b);
//
//        byte a = 10;
//        a = (byte) (a * coeff);
//        System.out.println(a);
//        event();
//        forCircle();
    }

    private static void forCircle() {
        for (int i = 0; i < 10; i++) {

        }

        int a = 0;
        while (a < 10) {
            a++;
        }

        Integer[] aa = new Integer[]{1, 2, 3, 5};
        for (int i = 0; i < aa.length; i++) {
            aa[i] *= 2;
        }
        for (int i : aa) {
            System.out.println("i = " + i);
        }

        for (Integer i : aa) {
            i *= 2;
        }
        for (int i : aa) {
            System.out.println("i = " + i);
        }

        a = 1;
        do {
            System.out.println("do");
        } while (a == 0);

        Arrays.asList(aa).forEach(System.out::println);
    }

    private static void event() {
//        int a = 10 > 11 ? 10 : 11;
//        a = 10 > 11 ? (10 > 11 ? 10 : 11) : 11;
//        System.out.println("a = " + a);

        int a = 10;
        if (a == 1) {
            System.out.println(" 1 ");
        } else if (a == 5) {
            System.out.println(" 2 ");
        } else if (a == 10) {
            System.out.println(" 3 ");
        } else {}

        switch (a) {
            case 1 : {
                System.out.println(" 1 ");
            } break;
            case 5 : {
                System.out.println(" 2 ");
            } break;
            case 10 : {
                System.out.println(" 3 ");
            } break;
            default: {

            }
        }
    }

    private static void binary() {
        int a = Integer.MAX_VALUE / 2;
        System.out.println("a = " + ConvertUtil.convertNumberToBinary(a, Byte.class));
        long start = System.nanoTime();
        a *= 2;
        long end = System.nanoTime() - start;
        System.out.println("end = " + end);
        System.out.println("a = " + a);
        System.out.println("a = " + ConvertUtil.convertNumberToBinary(a, Byte.class));
        a = Integer.MAX_VALUE / 2;
        start = System.nanoTime();
        int b = ~(a << 1);
        end = System.nanoTime() - start;
        System.out.println("end = " + end);
        System.out.println("b = " + b);
        System.out.println("b = " + ConvertUtil.convertNumberToBinary(b, Byte.class));
    }

    private static void primitive() {
        byte a  = Byte.MAX_VALUE;
        System.out.println("a = " + ConvertUtil.convertNumberToBinary(a, Byte.class));
//        byte b = (byte) (a + 1);
//        System.out.println("b = " + ConvertUtil.convertNumberToBinary(b, Byte.class));
        byte b = Byte.MAX_VALUE;
        b = (byte) (a + b);
        System.out.println("b = " + ConvertUtil.convertNumberToBinary(b, Byte.class));

        int i = 128;
        a = (byte) i;
        System.out.println("a = " + ConvertUtil.convertNumberToBinary(a, Byte.class));
    }
}
