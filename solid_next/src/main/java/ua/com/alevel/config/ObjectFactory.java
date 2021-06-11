package ua.com.alevel.config;

import ua.com.alevel.config.configure.ObjectConfigurator;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ObjectFactory {

    private final ApplicationContext context;
    private final List<ObjectConfigurator> objectConfigurators;

    public ObjectFactory(ApplicationContext context) {
        this.objectConfigurators = new ArrayList<>();
        this.context = context;

        Set<Class<? extends ObjectConfigurator>> subTypesOf = this.context.getApplicationConfiguration().getScanner().getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> aClass : subTypesOf) {
            try {
                objectConfigurators.add(aClass.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public <I> I createObject(Class<I> impl) {
        I i;
        try {
            i = create(impl);
            configure(i);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return i;
    }

    private <I> I create(Class<? extends I> impl) {
        try {
            return impl.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("can not create");
    }

    private <I> void configure(I i) {
        objectConfigurators.forEach(objectConfigurator -> objectConfigurator.configure(i, context));
    }
}
