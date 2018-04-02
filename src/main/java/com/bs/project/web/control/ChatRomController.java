package com.bs.project.web.control;

import com.alibaba.fastjson.JSON;
import com.bs.project.chat.model.ChatMessage;
import com.bs.project.chat.model.Message;
import com.bs.project.chat.service.MessageService;
import com.bs.project.consumer.model.SysUser;
import com.bs.project.consumer.service.UserService;
import com.bs.project.web.FileController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);
    //通过simpMessagingTemplate向浏览器发送消息
    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private UserService userService;

    @Autowired
    MessageService messageService;

    @MessageMapping("/all")
    public void all(Principal principal, String message) {
        logger.info("群聊消息："+message);
        ChatMessage chatMessage = createMessage(principal.getName(), message);

        //向用户发送消息,第一个参数:接收消息的用户,第二个参数:浏览器订阅地址,第三个参数:消息
        template.convertAndSend("/topic/notice", JSON.toJSONString(chatMessage));
    }


    @MessageMapping("/chat")
    //在springmvc中,可以直接在参数中获得principal,pinciple中包含当前用户信息
    public void chat(Principal principal, String message) {
        Message baseMessage = JSON.parseObject(message, Message.class);
        logger.info("私聊消息："+baseMessage);
        //发送者名字
        baseMessage.setSender(principal.getName());
        this.send(baseMessage);
    }

    private void send(Message message) {
        //消息发送当前时间
        message.setSendTime(new Date());
        System.out.println("聊天消息:"+message);
        messageService.save(message);
        ChatMessage chatMessage = createMessage(message.getSender(), message.getContent());
        template.convertAndSendToUser(message.getReceiver(), "/topic/chat", JSON.toJSONString(chatMessage));
        template.convertAndSendToUser(message.getSender(), "/topic/chat", JSON.toJSONString(chatMessage));

    }

    private ChatMessage createMessage(String username, String message) {
        ChatMessage chatMessage = new ChatMessage();
        System.out.println("存入格式："+chatMessage);
        chatMessage.setUsername(username);
        SysUser sysUser = userService.findAll(username);
        chatMessage.setAvatar(sysUser.getAvatar());
        chatMessage.setNickname(sysUser.getNickname());
        chatMessage.setContent(message);
        chatMessage.setSendTime(simpleDateFormat.format(new Date()));
        return chatMessage;
    }
}
