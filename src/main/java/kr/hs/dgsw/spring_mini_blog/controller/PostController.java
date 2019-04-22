package kr.hs.dgsw.spring_mini_blog.controller;

import kr.hs.dgsw.spring_mini_blog.domain.Post;
import kr.hs.dgsw.spring_mini_blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    public List<Post> list() {
        return postService.list();
    }

    @GetMapping("/post/{id}")
    public Post get(@PathVariable Long id) {
        return postService.get(id);
    }

    @PostMapping("/post")
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @PutMapping("/post/{id}")
    public Post update(@PathVariable Long id, @RequestBody Post post) {
        return postService.update(id, post);
    }

    @DeleteMapping("/post/{id}")
    public Post remove(@PathVariable Long id) {
        return postService.remove(id);
    }
}
