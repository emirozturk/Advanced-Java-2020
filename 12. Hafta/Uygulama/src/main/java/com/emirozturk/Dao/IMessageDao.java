package com.emirozturk.Dao;

import com.emirozturk.Entity.Message;

public interface IMessageDao {
    Message addMessage(Message message);
    Message getMessagebyId(int id);
    Message deleteMessage(Message message);
}
