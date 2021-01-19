package com.emirozturk.Dao;

import com.emirozturk.Entity.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoHibernate implements IUserDao{
    private final EntityManager entityManager;

    public UserDaoHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User addUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.save(user);
        return user;
    }

    @Override
    public User deleteUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.update(user);
        return user;
    }

    @Override
    public List<User> getUsers() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from User u",User.class).getResultList();
    }

    @Override
    public User getUserbyUserName(String name) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from User u where u.name=:name",User.class)
                .setParameter("name",name)
                .getSingleResult();
    }

    @Override
    public User getUserbyUserbyId(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(User.class,id);
    }

    @Override
    public User getUserbyMail(String s) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from User u where u.mail=:mail",User.class)
                .setParameter("mail",s)
                .getSingleResult();
    }
}
