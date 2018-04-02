package com.bs.project.chat.service.impl;

import com.bs.project.chat.dao.MessageDao;
import com.bs.project.chat.model.Message;
import com.bs.project.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Nominal on 2018/3/22 0022.
 * 微博：@Mr丶Li_Anonym
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageDao messageDao;

    @Override
    public Message save(Message message) {

        return messageDao.save(message);
    }

    @Override
    public Message findById(Long id) {
        return messageDao.findAllByIdEquals(id);
    }
}
