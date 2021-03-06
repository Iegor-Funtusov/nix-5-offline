package ua.com.alevel.app;

import ua.com.alevel.lib.BaseEntity;

public class Car extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + super.getId() + '\'' +
                "name='" + name + '\'' +
                '}';
    }
}
