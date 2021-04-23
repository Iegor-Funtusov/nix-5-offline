package ua.com.alevel.print;

import org.apache.commons.lang3.*;

public class Print {

    public void print() {
        String s = "Hello";
        System.out.println(s);
        s = StringUtils.upperCase(s);
        System.out.println(s);
    }
}
