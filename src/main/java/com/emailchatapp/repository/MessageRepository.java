package com.emailchatapp.repository;

import com.emailchatapp.entity.Message;
import com.emailchatapp.entity.MessageStatus;
import com.emailchatapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByReceiverAndStatus(User receiver, MessageStatus status);
}
