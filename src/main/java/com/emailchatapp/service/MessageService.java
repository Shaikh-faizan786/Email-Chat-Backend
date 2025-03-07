package com.emailchatapp.service;

import com.emailchatapp.entity.Message;

import java.util.List;

public interface MessageService {
    List<Message> getUnreadMessages(String receiverUsername);
    void sendMessage(String senderUsername, String receiverUsername, String content);
    void markAsRead(Long messageId);
}

