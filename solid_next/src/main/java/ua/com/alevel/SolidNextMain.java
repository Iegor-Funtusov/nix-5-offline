package ua.com.alevel;

import ua.com.alevel.config.Application;
import ua.com.alevel.config.ApplicationContext;
import ua.com.alevel.controller.UserController;

public class SolidNextMain {

    public static void main(String[] args) {
        ApplicationContext context = Application.start("ua.com.alevel");
        UserController controller = context.getObjectImpl(UserController.class);
        controller.start();
    }
}
