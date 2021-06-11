package ua.com.alevel.service;

import ua.com.alevel.config.ObjectFactory;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = ObjectFactory.getInstance().getObjectImpl(UserDao.class); // lookup

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public User find(long id) {
        return userDao.find(id);
    }

    @Override
    public List<User> find() {
        return userDao.find();
    }
}
