package ua.com.alevel;

import java.util.HashSet;
import java.util.Set;

public class BaseClassMain {

    public static void main(String[] args) {
        System.out.println("BaseClassMain.main");

        Human human = new Man(123);
        Man man = new Man(124);

        Woman woman1;
        Woman woman2 = null;
        Woman woman3 = new Woman(125);


        System.out.println(man.equals(human));
        System.out.println(man.hashCode() == human.hashCode());

        Set<Human> humans = new HashSet<>();
        humans.add(man);
        humans.add(human);

        humans.forEach(System.out::println);
    }
}
