package ua.com.alevel.image;

import java.io.File;
import java.util.Random;

public class AmazonImageTest {

    public void upload(File file) {
        // call some sdk aws api
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 0) {
            throw new AmazonImageException("AWS not working !!! ");
        }
        System.out.println("i = " + i);
    }
}
