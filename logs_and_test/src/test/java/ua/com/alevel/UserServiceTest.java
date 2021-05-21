package ua.com.alevel;

import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.stream.Collectors;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTest {

    private static final String NAME = "test";
    private static final String EMAIL = "email";
    private static final String NAME_UPDATE = "test10";
    private static final UserService USER_SERVICE = new UserService();

//    @BeforeAll
//    public static void setUp() {
//        for (int i = 0; i < 10; i++) {
//            User user = new User();
//            user.setName(NAME + i);
//            user.setEmail(EMAIL + i);
//            USER_SERVICE.create(user);
//        }
//        List<User> users = USER_SERVICE.findAll();
//        Assert.assertTrue(users != null && users.size() == 10);
//    }

    @Test
    @Order(1)
    public void existByEmailIsFalse() {
        User user = USER_SERVICE.findByEmail(EMAIL);
        Assert.assertTrue(user == null);
    }

    @Test
    @Order(2)
    public void existByEmailIsTrue() {
        User user = createUser();
        Assert.assertFalse(user == null);
    }

    @Test
    @Order(3)
    public void update() {
        User user1 = createUser();
        User user2 = user1;
        USER_SERVICE.update(user2);
        List<User> users = USER_SERVICE.findAll();
        users = users.stream().filter(user -> user.getEmail().equals(EMAIL)).collect(Collectors.toList());
        Assert.assertEquals(1, users.size());
    }

    private User createUser() {
        User user = new User();
        user.setName(NAME);
        user.setEmail(EMAIL);
        USER_SERVICE.create(user);

        return USER_SERVICE.findByEmail(EMAIL);
    }
}
