package com.emirozturk.Dao;

import com.emirozturk.Entity.Channel;
import com.emirozturk.Entity.UserChannel;

public interface IUserChannelDao {
    Channel addUserChannel(UserChannel userChannel);
    Channel deleteUserChannel(int cid, int uid);
}
