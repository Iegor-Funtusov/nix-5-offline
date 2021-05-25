package ua.com.alevel;

import java.util.Random;

public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        System.out.println("ExceptionThread.run");
        Random random = new Random();
        int r = random.nextInt(2);
        try {
            System.out.println(10 / r);
        } catch (ArithmeticException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
