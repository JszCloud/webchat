package com.bs.project.chat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 消息显示
 */

@Entity
public class ChatMessage {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;

  private String nickname;

  private String avatar;

  private String content;

  private String sendTime;



  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getSendTime() {
    return sendTime;
  }

  public void setSendTime(String sendTime) {
    this.sendTime = sendTime;
  }

  @Override
  public String toString() {
    return "ChatMessage{" +
            "username='" + username + '\'' +
            ", nickname='" + nickname + '\'' +
            ", avatar='" + avatar + '\'' +
            ", content='" + content + '\'' +
            ", sendTime='" + sendTime + '\'' +
            '}';
  }
}
