package kr.hs.dgsw.spring_mini_blog.service;

import kr.hs.dgsw.spring_mini_blog.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostService postService;

    @Autowired
    public PostServiceImpl(PostService postService) {
        this.postService = postService;
    }

    @Override
    public List<Post> list() {
        return null;
    }

    @Override
    public Post get(Long id) {
        return null;
    }

    @Override
    public Post create(Post post) {
        return null;
    }

    @Override
    public Post update(Long id, Post post) {
        return null;
    }

    @Override
    public Post remove(Long id) {
        return null;
    }
}
