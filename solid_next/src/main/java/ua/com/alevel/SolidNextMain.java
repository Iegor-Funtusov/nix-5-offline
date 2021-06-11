package ua.com.alevel;

import ua.com.alevel.config.ObjectFactory;
import ua.com.alevel.controller.UserController;

public class SolidNextMain {

    public static void main(String[] args) {
        UserController controller = ObjectFactory.getInstance().getObjectImpl(UserController.class);
        controller.start();
    }
}
