package ua.com.alevel;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public void optionalTest() {

        User userFrom = new User();
        User userTo = new User();

        Balance balanceFrom = userFrom.getBalance();
        if (balanceFrom != null) {
            BigDecimal from = balanceFrom.getBalance();
            if (from != null) {

            }
        }

    }

    public void reference() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(i);
            user.setFirstName(i + "first");
            user.setLastName(i + "last");
            list.add(user);
        }
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : list) {
            userDtos.add(generateUserDto(user));
        }
        System.out.println("userDtos = " + userDtos);


        userDtos = list.stream().map(this::generateUserDto).collect(Collectors.toList());
        userDtos = list.stream().map(UserDto::converterUserDto).collect(Collectors.toList());
        userDtos = list.stream().map(UserDto::new).collect(Collectors.toList());

        System.out.println("userDtos = " + userDtos);
    }

    private UserDto generateUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setAge(user.getAge());
        dto.setFullName(user.getFirstName() + " " + user.getLastName());
        return dto;
    }

    public void createStream() {
        List<Integer> list = Arrays.asList(1,0,2,3,14,9,7,4,3,5,14,6,7,8);

        Stream<Integer> integerStream = list.stream();

        List<Integer> integers = new ArrayList<>();

        for (Integer integer : list) {
            if (integer % 2 == 0) {
                integers.add(integer);
            }
        }
        Set<Integer> set = new TreeSet<>(integers);
        System.out.println("integers = " + set);
        int sum = 0;
        for (Integer integer : set) {
            sum += integer;
        }
        System.out.println("sum = " + sum);

        integers = integerStream
                .distinct()
                .filter(i -> i % 2 == 0)
                .sorted()
                .collect(Collectors.toList());

        sum = list.stream()
                .distinct()
                .filter(i -> i % 2 == 0)
                .reduce(this::sum)
                .get();

        System.out.println("sum = " + sum);
        System.out.println("integers = " + integers);


        list = Arrays.asList(1,0,2,3,14,9,7,4,3,5,14,6,7,8);

        List<String> strings = list.stream().map(i -> String.valueOf(i)).collect(Collectors.toList());
        strings = list.stream().map(String::valueOf).collect(Collectors.toList());
        String s = list.stream().map(String::valueOf).reduce(String::concat).get();
        System.out.println("s = " + s);
        s = list.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println("s = " + s);

        s = list.stream()
                .distinct()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("s = " + s);
    }

    private int sum(int a, int b) {
        return a + b;
    }
}
