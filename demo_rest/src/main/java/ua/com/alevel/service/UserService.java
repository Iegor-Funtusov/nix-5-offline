package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.User;

import java.util.List;

public interface UserService {

    void create(User user);
    void update(User user);
    void delete(Integer id);
    User findById(Integer id);
    List<User> findAll();
}
