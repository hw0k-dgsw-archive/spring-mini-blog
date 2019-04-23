package kr.hs.dgsw.spring_mini_blog.controller;

import kr.hs.dgsw.spring_mini_blog.domain.Post;
import kr.hs.dgsw.spring_mini_blog.protocol.ResponseFormat;
import kr.hs.dgsw.spring_mini_blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post/{userid}")
    public ResponseFormat get(@PathVariable Long userid) {
        return postService.get(userid);
    }

    @PostMapping("/post")
    public ResponseFormat create(@RequestBody Post post) {
        return postService.create(post);
    }

    @PutMapping("/post/{id}")
    public ResponseFormat update(@PathVariable Long id, @RequestBody Post post) {
        return postService.update(id, post);
    }

    @DeleteMapping("/post/{id}")
    public ResponseFormat remove(@PathVariable Long id) {
        return postService.remove(id);
    }
}
