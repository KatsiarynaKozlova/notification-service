package com.modsen.software.notification.service;

import com.modsen.software.notification.dto.request.StatusDetailsMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebSocketNotificationService {
    private final SimpMessagingTemplate messagingTemplate;

    public void sendStatusDetailsMessage(StatusDetailsMessage message) {
        messagingTemplate.convertAndSendToUser(message.id().toString(),
                "/queue/messages",
                message);
    }
}
