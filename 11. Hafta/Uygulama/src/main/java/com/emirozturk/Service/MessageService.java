package com.emirozturk.Service;

import com.emirozturk.Dao.IMessageDao;
import com.emirozturk.Entity.Message;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MessageService implements IMessageService{
    private final IMessageDao messageDao;

    public MessageService(IMessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    @Transactional
    public Message addMessage(Message message) {
        return messageDao.addMessage(message);
    }

    @Override
    @Transactional
    public Message deleteMessage(int id) {
        Message message = messageDao.getMessagebyId(id);
        return messageDao.deleteMessage(message);
    }
}
