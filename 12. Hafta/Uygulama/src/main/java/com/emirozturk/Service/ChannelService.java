package com.emirozturk.Service;


import com.emirozturk.Dao.IChannelDao;
import com.emirozturk.Dao.IUserChannelDao;
import com.emirozturk.Dao.IUserDao;
import com.emirozturk.Entity.Channel;
import com.emirozturk.Entity.User;
import com.emirozturk.Entity.UserChannel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class ChannelService implements IChannelService {
    private final IUserDao userDao;
    private final IChannelDao channelDao;
    private final IUserChannelDao userChannelDao;

    public ChannelService(IUserDao userDao, IChannelDao channelDao, IUserChannelDao userChannelDao) {
        this.userDao = userDao;
        this.channelDao = channelDao;
        this.userChannelDao = userChannelDao;
    }

    @Override
    @Transactional
    public Channel addChannel(Channel channel) {
        return channelDao.addChannel(channel);
    }

    @Override
    @Transactional
    public Channel updateChannel(Channel channel) {
        return channelDao.updateChannel(channel);
    }

    @Override
    @Transactional
    public Channel deleteChannel(int id) {
        Channel channel = channelDao.getChannelbyId(id);
        return channelDao.deleteChannel(channel);
    }

    @Override
    @Transactional
    public Channel getChannel(int id) {
        return channelDao.getChannelbyId(id);
    }

    @Override
    @Transactional
    public List<Channel> getChannels() {
        return channelDao.getChannels();
    }

    @Override
    @Transactional
    public Channel addUserToChannel(int cid, int uid,int auth) {
        Channel channel = channelDao.getChannelbyId(cid);
        User user = userDao.getUserbyUserbyId(uid);
        UserChannel userChannel = new UserChannel(user,channel,auth, Date.valueOf(LocalDate.now()));
        return userChannelDao.addUserChannel(userChannel);
    }

    @Override
    @Transactional
    public Channel deleteUserFromChannel(int cid, int uid) {
        return userChannelDao.deleteUserChannel(cid,uid);
    }
}
