package kr.hs.dgsw.spring_mini_blog.service;

import kr.hs.dgsw.spring_mini_blog.domain.User;

import java.util.List;

public interface UserService {
    List<User> list();
    User get(Long id);
    User create(User user);
    User update(Long id, User user);
    User remove(Long id);

    User login(User user);
}
