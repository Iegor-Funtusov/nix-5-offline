package ua.com.alevel;

import ua.com.alevel.image.AmazonImageTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionMain {

    public static void main(String[] args) {
//        Thread thread = Thread.currentThread();
//        System.out.println("thread = " + thread.getName());
//        ClassLoader classLoader = thread.getContextClassLoader();
//        System.out.println("classLoader = " + classLoader.getName());

        AmazonImageTest amazonImageTest = new AmazonImageTest();
        try {
            amazonImageTest.upload(new File("test.txt"));
        } catch (RuntimeException exception) {
            System.out.println("exception = " + exception.getClass().getName());
        }

//        ExceptionTest exceptionTest = new ExceptionTest();
//        exceptionTest.test1();
        System.out.println("ExceptionMain.main finish");
//        for (int i = 0; i < 10; i++) {
//            System.out.println("i = " + i);
//            ExceptionThread thread = new ExceptionThread();
//            try {
//                thread.run();
//            } catch (RuntimeException e) {
//                System.out.println("e = " + e.getMessage());
//            }
//        }
    }
}
