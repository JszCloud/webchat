package com.bs.project.chat.dao;

import com.bs.project.chat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nominal on 2018/3/22 0022.
 * 微博：@Mr丶Li_Anonym
 */
public interface MessageDao extends JpaRepository<Message,Long> {
    Message findAllByIdEquals(Long id);
}
