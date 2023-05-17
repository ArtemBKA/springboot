package com.baklanov.SpringBoot.services;

import com.baklanov.SpringBoot.dao.UserDao;
import com.baklanov.SpringBoot.models.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDAO;

    @Autowired
    public UserServiceImpl(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        User user = userDAO.getUser(id);
        userDAO.deleteUser(user);
    }

    @Override
    public User getUser(long id) { return userDAO.getUser(id); }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

}
