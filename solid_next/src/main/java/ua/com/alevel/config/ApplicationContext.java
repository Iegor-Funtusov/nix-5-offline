package ua.com.alevel.config;

import ua.com.alevel.config.annotation.Service;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private ObjectFactory objectFactory;
    private ApplicationConfiguration applicationConfiguration;
    private Map<Class, Object> implClasses;

    public ApplicationContext(ApplicationConfiguration applicationConfiguration) {
        this.applicationConfiguration = applicationConfiguration;
        implClasses = new HashMap<>();
    }

    public void setObjectFactory(ObjectFactory objectFactory) {
        this.objectFactory = objectFactory;
    }

    public ApplicationConfiguration getApplicationConfiguration() {
        return applicationConfiguration;
    }

    public <I> I getObjectImpl(Class<I> type) {
        Class<? extends I> impl = type;
        if (implClasses.containsKey(type)) {
            return (I) implClasses.get(type);
        }
        if (type.isInterface()) {
            impl = applicationConfiguration.getImplementation(type);
        }
        I i = objectFactory.createObject(impl);
        if (impl.isAnnotationPresent(Service.class)) {
            implClasses.put(type, i);
        }
        return i;
    }
}
