package com.emirozturk.Dao;

import com.emirozturk.Entity.Message;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class MessageDaoHibernate implements IMessageDao{

    private final EntityManager entityManager;

    public MessageDaoHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Message addMessage(Message message) {
        var session = entityManager.unwrap(Session.class);
        session.save(message);
        return message;
    }

    @Override
    public Message getMessagebyId(int id) {
        var session = entityManager.unwrap(Session.class);
        return session.get(Message.class,id);
    }

    @Override
    public Message deleteMessage(Message message) {
        var session = entityManager.unwrap(Session.class);
        session.delete(message);
        return message;
    }
}
