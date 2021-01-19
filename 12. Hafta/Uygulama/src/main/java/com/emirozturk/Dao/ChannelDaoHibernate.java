package com.emirozturk.Dao;

import com.emirozturk.Entity.Channel;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ChannelDaoHibernate implements IChannelDao{
    private final EntityManager entityManager;

    public ChannelDaoHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Channel addChannel(Channel channel) {
        var session = entityManager.unwrap(Session.class);
        session.save(channel);
        return channel;
    }

    @Override
    public Channel updateChannel(Channel channel) {
        var session = entityManager.unwrap(Session.class);
        session.update(channel);
        return channel;
    }

    @Override
    public Channel getChannelbyId(int id) {
        var session = entityManager.unwrap(Session.class);
        return session.get(Channel.class,(long)id);
    }

    @Override
    public Channel deleteChannel(Channel channel) {
        var session = entityManager.unwrap(Session.class);
        session.delete(channel);
        return channel;
    }

    @Override
    public List<Channel> getChannels() {
        var session = entityManager.unwrap(Session.class);
        return session.createQuery("from Channel ",Channel.class).getResultList();
    }
}
