package ua.com.alevel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.UserService;

import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String users(Model model) {
        model.addAttribute("users", userService.find());
        return "users";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "user_new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.find(id));
        return "user_details";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.find(id));
        return "user_update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user, @RequestParam Integer id) {
        user.setId(id);
        userService.update(user);
        return "redirect:/users";
    }

    @ResponseBody
    @GetMapping("/json")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.find());
    }

    @ResponseBody
    @PostMapping("/json")
    public ResponseEntity<Boolean> createUser(@RequestBody User user) {
        userService.create(user);
        return ResponseEntity.status(201).body(true);
    }
}
