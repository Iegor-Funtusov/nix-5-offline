package com.example.spring_data_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String index() {

        User user = new User();
        user.setAge(10);
        user.setName("qq");
        userRepository.save(user);

        user = new User();
        user.setAge(12);
        user.setName("qq");
        userRepository.save(user);

        user = new User();
        user.setAge(20);
        user.setName("qq");
        userRepository.save(user);

        user = new User();
        user.setAge(25);
        user.setName("qq");
        userRepository.save(user);

        List<User> users = userRepository.findByAgeBetween(12, 20);

        users.forEach(System.out::println);

        return "index";
    }
}
