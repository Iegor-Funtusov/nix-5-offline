package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionTest {

    public void test1() {
        System.out.println("ExceptionTest.start transaction");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try(
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader reader3 = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader reader4 = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String s = reader.readLine();
//            System.exit(10);
            test2(s);
        } catch (IOException e) {
            System.out.println("e IOException = " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("e RuntimeException = " + e.getMessage());
        } finally {
            System.out.println("ExceptionTest.finally");
//            try {
//                reader.close();
//            } catch (IOException e) {
//                System.out.println("e = " + e.getMessage());
//            }
        }
    }

    private void test2(String s) throws NumberFormatException {
        Integer integer = Integer.parseInt(s);
        System.out.println("integer = " + integer);
    }
}
