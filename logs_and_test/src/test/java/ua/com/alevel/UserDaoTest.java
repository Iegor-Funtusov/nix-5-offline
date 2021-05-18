package ua.com.alevel;

import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDaoTest {

    private static final String NAME = "test";
    private static final String NAME_UPDATE = "test10";
    private static UserDao userDao = new UserDao();

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName(NAME + i);
            userDao.create(user);
        }
        List<User> users = userDao.findAll();
        Assert.assertTrue(users != null && users.size() == 10);
    }

    @Test
    @Order(1)
    public void create() {
        User user = new User();
        user.setName(NAME);

        userDao.create(user);

        List<User> users = userDao.findByName(NAME);
        Assert.assertTrue(users != null && users.size() == 1);
    }

    @Test
    @Order(2)
    public void delete() {
        List<User> users = userDao.findByName(NAME);
        Assert.assertTrue(users != null && users.size() == 1);

        userDao.delete(users.get(0).getId());

        users = userDao.findAll();
        Assert.assertTrue(users != null && users.size() == 10);
    }

    @Test
    @Order(3)
    public void update() {
        User user = userDao.findById(5);
        user.setName(NAME_UPDATE);
        userDao.update(user);

        user = userDao.findById(5);
        Assert.assertEquals(user.getName(), NAME_UPDATE);
    }
}
