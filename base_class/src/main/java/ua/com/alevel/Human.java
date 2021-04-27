package ua.com.alevel;

import java.util.Objects;

public abstract class Human {

    private long inn;
    private int age;
    private String name;

    public Human(long inn) {
        if (State.getInstance().addHumanInn(inn)) {
            this.inn = inn;
        } else {
            throw new RuntimeException("inn is exist");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        }
    }

    public long getInn() {
        return inn;
    }

    abstract void life();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return inn == human.inn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inn, age, name);
    }

    @Override
    public String toString() {
        return "Human{" +
                "inn=" + inn +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
