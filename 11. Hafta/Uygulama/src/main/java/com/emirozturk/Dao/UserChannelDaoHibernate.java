package com.emirozturk.Dao;

import com.emirozturk.Entity.Channel;
import com.emirozturk.Entity.UserChannel;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserChannelDaoHibernate implements IUserChannelDao{
    private final EntityManager entityManager;

    public UserChannelDaoHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Channel addUserChannel(UserChannel userChannel) {
        var session = entityManager.unwrap(Session.class);
        session.save(userChannel);
        return userChannel.getChannel();
    }

    @Override
    public Channel deleteUserChannel(int cid, int uid) {
        var session = entityManager.unwrap(Session.class);
        var result = session.createQuery("from UserChannel uc where uc.user.id = :uid and uc.channel.id = :cid",UserChannel.class)
                .setParameter("uid",uid)
                .setParameter("cid",cid)
                .getSingleResult();
        session.delete(result);
        return result.getChannel();
    }
}
