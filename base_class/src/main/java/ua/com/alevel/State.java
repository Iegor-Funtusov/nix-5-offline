package ua.com.alevel;

import java.util.ArrayList;
import java.util.List;

public class State {

    private static State instance;

    private State() { }

    public static State getInstance() {
        if (instance == null) {
            instance = new State();
        }
        return instance;
    }

    private final List<Long> humansInns = new ArrayList<>();

    public boolean addHumanInn(long inn) {
        for (Long humansInn : humansInns) {
            if (humansInn == inn) {
                return false;
            }
        }
        humansInns.add(inn);
        return true;
    }
}
