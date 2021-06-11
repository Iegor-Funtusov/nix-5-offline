package ua.com.alevel.config;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ObjectFactory {

    private static ObjectFactory instance;
    private final Reflections reflections;

    private ObjectFactory() {
        reflections = new Reflections("ua.com.alevel");
    }

    public static ObjectFactory getInstance() {
        if (instance == null) {
            instance = new ObjectFactory();
        }
        return instance;
    }

    public <I> I getObjectImpl(Class<I> iClass) {
        Set<Class<? extends I>> classes = reflections.getSubTypesOf(iClass);
        for (Class<? extends I> aClass : classes) {
            try {
                return aClass.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException("can not create object");
    }
}
