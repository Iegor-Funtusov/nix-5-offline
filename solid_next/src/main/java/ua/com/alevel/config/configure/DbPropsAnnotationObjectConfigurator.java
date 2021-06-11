package ua.com.alevel.config.configure;

import ua.com.alevel.config.ApplicationContext;
import ua.com.alevel.config.annotation.Autowired;
import ua.com.alevel.config.annotation.DbProps;
import ua.com.alevel.util.ResourceUtil;

import java.lang.reflect.Field;
import java.util.Map;

public class DbPropsAnnotationObjectConfigurator implements ObjectConfigurator {

    @Override
    public void configure(Object o, ApplicationContext context) {
        Field[] declaredFields = o.getClass().getDeclaredFields();
        Map<String, String> map = ResourceUtil.getResource("db.properties");
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(DbProps.class)) {
                DbProps dbProps = declaredField.getAnnotation(DbProps.class);
                String value = dbProps.value();
                String props = map.get(value);
                if (props != null) {
                    declaredField.setAccessible(true);
                    try {
                        declaredField.set(o, props);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("problem from initial field");
                    }
                }
            }
        }
    }
}
