package ua.com.alevel.dao;

import ua.com.alevel.entity.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void create(User user) {
        System.out.println("UserDaoImpl.create");
    }

    @Override
    public void update(User user) {
        System.out.println("UserDaoImpl.update");
    }

    @Override
    public void delete(long id) {
        System.out.println("UserDaoImpl.delete");
    }

    @Override
    public User find(long id) {
        System.out.println("UserDaoImpl.findById");
        return null;
    }

    @Override
    public List<User> find() {
        System.out.println("UserDaoImpl.find");
        return null;
    }
}
