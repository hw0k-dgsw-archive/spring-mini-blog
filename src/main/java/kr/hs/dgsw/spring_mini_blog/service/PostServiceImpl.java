package kr.hs.dgsw.spring_mini_blog.service;

import kr.hs.dgsw.spring_mini_blog.domain.Post;
import kr.hs.dgsw.spring_mini_blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> list() {
        return postRepository.findAll();
    }

    @Override
    public Post get(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post update(Long id, Post post) {
        if (!postRepository.findById(id).isPresent()) {
            return null;
        }

        post.setId(id);
        return postRepository.save(post);
    }

    @Override
    public Post remove(Long id) {
        postRepository.deleteById(id);
        return null;
    }
}
