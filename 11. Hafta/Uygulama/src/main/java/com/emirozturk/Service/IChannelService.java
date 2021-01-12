package com.emirozturk.Service;

import com.emirozturk.Entity.Channel;

import java.util.List;

public interface IChannelService {
    Channel addChannel(Channel channel);
    Channel updateChannel(Channel channel);
    Channel deleteChannel(int id);
    Channel getChannel(int id);
    List<Channel> getChannels();
    Channel addUserToChannel(int cid, int uid,int auth);
    Channel deleteUserFromChannel(int cid, int uid);
}
