package ua.com.alevel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnonimClass {

//    public AnonimInterface anonimInterface = new AnonimInterfaceImpl();

    public AnonimInterface getAnonimInterface() {
        return new AnonimInterface() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };
    }

    public AnonimInterface getNewAnonimInterface() {
//        AnonimInterface anonimInterface = (int a, int b) -> {
//            return a + b;
//        };

        AnonimI anonimI = (s, i, user) -> {
            return s;
        };

        return (a, b) -> a + b;
    }
}
