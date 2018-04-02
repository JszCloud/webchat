package com.bs.project.chat.service;

import com.bs.project.chat.model.Message;

/**
 * Created by Nominal on 2018/3/22 0022.
 * 微博：@Mr丶Li_Anonym
 */
public interface MessageService {
    Message save(Message message);
    Message findById(Long id);
}
