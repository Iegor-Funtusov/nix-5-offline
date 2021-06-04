package ua.com.alevel;

public class UserDto {

    private String fullName;
    private int age;

    public UserDto() { }

    public UserDto(User user) {
        this.age = user.getAge();
        this.fullName = user.getFirstName() + " " + user.getLastName();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                '}';
    }

    public static UserDto converterUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setAge(user.getAge());
        dto.setFullName(user.getFirstName() + " " + user.getLastName());
        return dto;
    }
}
