package com.baklanov.SpringBoot.services;

import com.baklanov.SpringBoot.models.User;
import java.util.List;

public interface UserService {
    void createUser(User user);
    void updateUser(User user);
    void deleteUserById(long id);
    User getUser(long id);
    List<User> getAllUsers();
}
