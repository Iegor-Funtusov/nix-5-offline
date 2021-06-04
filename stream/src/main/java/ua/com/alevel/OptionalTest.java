package ua.com.alevel;

public class OptionalTest {

    public void test() {
        OptionalUser user = new OptionalUser();
        System.out.println("user = " + user);
        System.out.println("age = " + user.getBalance()
                .orElseThrow(() ->  new RuntimeException("Idiot")));
    }
}
