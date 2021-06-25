package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.entity.User;
import ua.com.alevel.persistence.repository.UserRepository;
import ua.com.alevel.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public void create(User user) {
        if (!userRepository.existsByEmail(user.getEmail())) {
            userRepository.save(user);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public void update(User user) {
        if (userRepository.existsById(user.getId())) {
            userRepository.save(user);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public void delete(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("user not found");
        }
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Integer id) {
        if (userRepository.existsById(id)) {
            return userRepository.getById(id);
        }
        throw new RuntimeException("user not found");
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
