package com.internet.shop.dao.implementation;

import com.internet.shop.dao.UserDao;
import com.internet.shop.db.Storage;
import com.internet.shop.lib.Dao;
import com.internet.shop.model.User;
import java.util.List;
import java.util.Optional;

@Dao
public class UserDaoImpl implements UserDao {

    @Override
    public User createUser(User user) {
        Storage.addUser(user);
        return user;
    }

    @Override
    public Optional<User> getUser(Long userId) {
        return Storage.users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst();
    }

    @Override
    public List<User> getAllUsers() {
        return Storage.users;
    }

    @Override
    public User updateUser(User user) {
        User userToUpdate = getUser(user.getId()).get();
        userToUpdate.setName(user.getName());
        userToUpdate.setLogin(user.getLogin());
        userToUpdate.setPassword(user.getPassword());
        return userToUpdate;
    }

    @Override
    public boolean deleteUser(Long id) {
        return Storage.users.removeIf(user -> user.getId().equals(id));
    }
}
