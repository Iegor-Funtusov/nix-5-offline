package ua.com.alevel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.persistence.entity.User;
import ua.com.alevel.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Boolean> create(@RequestBody User user) {
        userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@RequestBody User user, @PathVariable Integer id) {
        user.setId(id);
        userService.update(user);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }
}
