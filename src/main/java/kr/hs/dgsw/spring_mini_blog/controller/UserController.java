package kr.hs.dgsw.spring_mini_blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping
    public String list() {
        return "list!";
    }
}
