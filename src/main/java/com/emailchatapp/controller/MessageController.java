package com.emailchatapp.controller;

import com.emailchatapp.dto.MessageDTO;
import com.emailchatapp.entity.Message;
import com.emailchatapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/unread")
    public List<Message> getUnreadMessages(@RequestParam String username) {
        return messageService.getUnreadMessages(username);
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDTO messageDTO) {
        messageService.sendMessage(messageDTO.getSenderUsername(), messageDTO.getReceiverUsername(), messageDTO.getContent());
        return ResponseEntity.ok("Message sent!");
    }

    @PostMapping("/mark-read/{id}")
    public ResponseEntity<String> markMessageAsRead(@PathVariable Long id) {
        messageService.markAsRead(id);
        return ResponseEntity.ok("Message marked as read!");
    }
}
