package kr.hs.dgsw.spring_mini_blog.service;

import kr.hs.dgsw.spring_mini_blog.domain.Post;
import kr.hs.dgsw.spring_mini_blog.protocol.ResponseFormat;
import kr.hs.dgsw.spring_mini_blog.protocol.ResponseType;
import kr.hs.dgsw.spring_mini_blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public ResponseFormat get(Long userid) {
        try {
            Post post = postRepository.findTopByUseridOrderByUpdatedDesc(userid).orElse(null);

            if (post == null) {
                throw new Exception("User or Post not found");
            }
            return new ResponseFormat(ResponseType.POST_GET, post, post.getId());
        }
        catch (Exception e) {
            return new ResponseFormat(ResponseType.FAIL, e.getMessage());
        }
    }

    @Override
    public ResponseFormat create(Post post) {
        try {
            Post createdPost = postRepository.save(post);

            if (post == null) {
                throw new Exception("Failed to create post");
            }

            return new ResponseFormat(ResponseType.POST_ADD, createdPost, createdPost.getId());
        }
        catch (Exception e) {
            return new ResponseFormat(ResponseType.FAIL, e.getMessage());
        }
    }

    @Override
    public ResponseFormat update(Long id, Post post) {
        try {
            if (!postRepository.findById(id).isPresent()) {
                throw new Exception("Post not found");
            }

            post.setId(id);
            Post updatedPost = postRepository.save(post);

            if (updatedPost == null) {
                throw new Exception("Failed to update post");
            }

            return new ResponseFormat(ResponseType.POST_ADD, updatedPost, updatedPost.getId());
        }
        catch (Exception e) {
            return new ResponseFormat(ResponseType.FAIL, e.getMessage());
        }
    }

    @Override
    public ResponseFormat remove(Long id) {
        try {
            if (!postRepository.findById(id).isPresent()) {
                throw new Exception("Post not found");
            }

            postRepository.deleteById(id);

            return new ResponseFormat(ResponseType.POST_DELETE, null, id);
        }
        catch (Exception e) {
            return new ResponseFormat(ResponseType.FAIL, e.getMessage());
        }
    }
}
