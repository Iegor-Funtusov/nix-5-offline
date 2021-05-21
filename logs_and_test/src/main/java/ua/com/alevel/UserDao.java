package ua.com.alevel;

//import org.apache.log4j.Logger;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDao {

//    private static Logger logger = Logger.getLogger(UserDao.class);
//    private static Logger logger = LogManager.getLogger(UserDao.class);
//    private static Logger logger = LoggerFactory.getLogger(UserDao.class);

    private List<User> users = new ArrayList<>();

    public void create(User user) {
//        logger.info("Start create user: " + user.getName());
        user.setId(users.size() + 1);
        users.add(user);
//        logger.info("End create user");
    }

    public void update(User user) {
//        logger.warn("Start update user: " + user.getName());
        User current = findById(user.getId());
        current.setName(user.getName());
        current.setEmail(user.getEmail());
//        logger.warn("End update user");
    }

    public List<User> findByName(String name) {
        return users
                .stream()
                .filter(user -> user.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<User> findAll() {
        return users;
    }

    public void delete(Integer id) {
//        logger.warn("Start delete user: " + id);
        users.removeIf(user -> user.getId().equals(id));
//        logger.warn("End delete user");
    }

    public User findById(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public User findByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }
}
