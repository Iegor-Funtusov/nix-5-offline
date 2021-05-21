package ua.com.alevel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private UserDao userDao = new UserDao();

    public void create(User user) {
        LOGGER_INFO.info("Start create user: " + user.getName());
        if (!isUserExistByEmail(user)) {
            userDao.create(user);
        }
        LOGGER_INFO.info("End create user");
    }

    public void update(User user) {
        LOGGER_WARN.warn("Start update user: " + user.getName());
        if (!isUserExistByEmail(user)) {
            userDao.update(user);
        }
        LOGGER_WARN.warn("End update user");
    }

    public List<User> findByName(String name) {
        return userDao.findByName(name);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void delete(Integer id) {
        userDao.delete(id);
    }

    public User findById(Integer id) {
        return userDao.findById(id);
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    private boolean isUserExistByEmail(User user) {
        if (user.getEmail() != null) {
            User user1 = findByEmail(user.getEmail());
            if (user1 == null) {
                return false;
            } else {
                LOGGER_ERROR.error("this user is exist: " + user.getEmail());
            }
        } else {
            LOGGER_ERROR.error("email can't be empty");
        }
        return true;
    }
}
