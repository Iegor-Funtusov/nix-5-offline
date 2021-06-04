package ua.com.alevel;

import java.util.Optional;

public class OptionalUser {

    private Optional<String> firstName;
    private Optional<String> lastName;
    private Optional<Integer> age;
    private Optional<Balance> balance;

    public OptionalUser() {
        this.firstName = Optional.empty();
        this.lastName = Optional.empty();
        this.age = Optional.empty();
        this.balance = Optional.empty();
    }

    public Optional<String> getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = Optional.of(firstName);
    }

    public Optional<String> getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = Optional.of(lastName);
    }

    public Optional<Integer> getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = Optional.of(age);
    }

    public Optional<Balance> getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = Optional.of(balance);
    }

    @Override
    public String toString() {
        return "OptionalUser{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", age=" + age +
                ", balance=" + balance +
                '}';
    }
}
