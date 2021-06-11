package ua.com.alevel;

import org.reflections.Reflections;
import ua.com.alevel.reder.AbstractReader;
import ua.com.alevel.writer.AbstractWriter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ApplicationConfig {

    private static final String ROOT_PACKAGE = "ua.com.alevel";
    private Set<Class<? extends AbstractReader>> abstractReaderSet;
    private Set<Class<? extends AbstractWriter>> abstractWriterSet;
    private Set<Class<? extends Start>> starts;

    private Map<String, Object> map = new HashMap<>();

    public ApplicationConfig() {
        Reflections reflections = new Reflections(ROOT_PACKAGE);
        abstractReaderSet = reflections.getSubTypesOf(AbstractReader.class);
        abstractWriterSet = reflections.getSubTypesOf(AbstractWriter.class);
        starts = reflections.getSubTypesOf(Start.class);
    }

    public void init() {
        for (Class<? extends AbstractReader> aClass : abstractReaderSet) {
            System.out.println("aClass = " + aClass.getSimpleName());
            try {
                Object o = aClass.getDeclaredConstructor().newInstance();
                map.put(o.getClass().getSimpleName().toLowerCase(), o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (Class<? extends AbstractWriter> aClass : abstractWriterSet) {
            System.out.println("aClass = " + aClass.getSimpleName());
            try {
                Object o = aClass.getDeclaredConstructor().newInstance();
                map.put(o.getClass().getSimpleName().toLowerCase(), o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (Class<? extends Start> start : starts) {
            Field[] declaredFields = start.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                String fieldName = declaredField.getName().toLowerCase();
                System.out.println("declaredField = " + fieldName);
                Object o = map.get(fieldName);
                if (o != null) {
                    System.out.println("o = " + o.getClass().getSimpleName());
                    declaredField.setAccessible(true);
                    try {
                        declaredField.set(start, o);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                if (declaredField.getType().isAssignableFrom(BufferedReader.class)) {
                    System.out.println("is Buffered");
                }
            }
        }
    }
}
