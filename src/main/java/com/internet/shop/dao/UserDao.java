package com.internet.shop.dao;

import com.internet.shop.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {

    User createUser(User user);

    Optional<User> getUser(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    boolean deleteUser(Long id);
}
