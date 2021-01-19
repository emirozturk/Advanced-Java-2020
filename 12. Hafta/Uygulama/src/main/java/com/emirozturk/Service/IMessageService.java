package com.emirozturk.Service;

import com.emirozturk.Entity.Message;

public interface IMessageService {
    Message addMessage(Message message);
    Message deleteMessage(int id);
}
