package com.emirozturk.Dao;

import com.emirozturk.Entity.Channel;

import java.util.List;

public interface IChannelDao {
    Channel addChannel(Channel channel);

    Channel updateChannel(Channel channel);

    Channel getChannelbyId(int id);

    Channel deleteChannel(Channel channel);

    List<Channel> getChannels();
}
