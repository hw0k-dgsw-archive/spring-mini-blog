package kr.hs.dgsw.spring_mini_blog.service;

import kr.hs.dgsw.spring_mini_blog.domain.Post;
import kr.hs.dgsw.spring_mini_blog.protocol.ResponseFormat;

public interface PostService {
    ResponseFormat get(Long userid);
    ResponseFormat create(Post post);
    ResponseFormat update(Long id, Post post);
    ResponseFormat remove(Long id);
}
