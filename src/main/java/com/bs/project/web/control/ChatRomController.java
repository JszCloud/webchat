package com.bs.project.web.control;

import com.alibaba.fastjson.JSON;
import com.bs.project.chat.model.ChatMessage;
import com.bs.project.chat.model.Message;
import com.bs.project.consumer.model.SysUser;
import com.bs.project.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Nominal on 2018/3/21 0021.
 * 微博：@Mr丶Li_Anonym
 */
@Controller
public class ChatRomController {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm");

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private UserService userService;

    @MessageMapping("/all")
    public void all(Principal principal, String message) {
        ChatMessage chatMessage = createMessage(principal.getName(), message);
        template.convertAndSend("/topic/notice", JSON.toJSONString(chatMessage));
    }


    @MessageMapping("/chat")
    public void chat(Principal principal, String message) {
        Message baseMessage = JSON.parseObject(message, Message.class);
        //发送者名字
        baseMessage.setSender(principal.getName());
        this.send(baseMessage);
    }

    private void send(Message message) {
        //消息发送当前时间
        message.setSendTime(new Date());

        ChatMessage chatMessage = createMessage(message.getSender(), message.getContent());
        template.convertAndSendToUser(message.getReceiver(), "/topic/chat", JSON.toJSONString(chatMessage));
    }

    private ChatMessage createMessage(String username, String message) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername(username);
        SysUser sysUser = userService.findAll(username);
        chatMessage.setAvatar(sysUser.getAvatar());
        chatMessage.setNickname(sysUser.getNickname());
        chatMessage.setContent(message);
        chatMessage.setSendTime(simpleDateFormat.format(new Date()));
        return chatMessage;
    }
}
