package com.baklanov.SpringBoot.dao;

import com.baklanov.SpringBoot.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(User user) { entityManager.remove(user); }

    @Override
    public void updateUser(User user) { entityManager.merge(user); }

    @Override
    public User getUser(long id) {
        return entityManager.createQuery("select u from User u where u.id=:id", User.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }
}
