package kr.hs.dgsw.spring_mini_blog.controller;

import kr.hs.dgsw.spring_mini_blog.domain.User;
import kr.hs.dgsw.spring_mini_blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> list() {
        return userService.list();
    }

    @GetMapping("/user/{id}")
    public User get(@PathVariable Long id) {
        return userService.get(id);
    }

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/user/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/user/{id}")
    public User remove(@PathVariable Long id) {
        return userService.remove(id);
    }

    @PostMapping("/user/login")
    public User login(@RequestBody User user) {
        return userService.login(user);
    }
}
