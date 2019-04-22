package kr.hs.dgsw.spring_mini_blog.service;

import kr.hs.dgsw.spring_mini_blog.domain.Post;

import java.util.List;

public interface PostService {
    List<Post> list();
    Post get(Long id);
    Post create(Post post);
    Post update(Long id, Post post);
    Post remove(Long id);
}
