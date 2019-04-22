package kr.hs.dgsw.spring_mini_blog.service;

import kr.hs.dgsw.spring_mini_blog.domain.User;
import kr.hs.dgsw.spring_mini_blog.repository.UserRepository;
import kr.hs.dgsw.spring_mini_blog.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        if (!userRepository.findById(id).isPresent()) {
            return null;
        }

        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public User remove(Long id) {
        userRepository.deleteById(id);
        return null;
    }

    @Override
    public User login(User user) {
        return userRepository
                .findByAccountAndPassword(user.getAccount(), user.getPassword())
                .orElse(null);
    }
}
