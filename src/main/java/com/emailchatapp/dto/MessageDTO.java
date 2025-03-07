package com.emailchatapp.dto;

import com.emailchatapp.entity.Message;
import com.emailchatapp.entity.MessageStatus;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageDTO {
    private Long id;
    private String senderUsername;
    private String receiverUsername;
    private String content;
    private MessageStatus status;

    public MessageDTO(Message message) {
        this.id = message.getId();
        this.senderUsername = message.getSender().getUsername();
        this.receiverUsername = message.getReceiver().getUsername();
        this.content = message.getContent();
        this.status = message.getStatus();
    }
}
