package com.modsen.software.notification.service;

import com.modsen.software.notification.dto.request.OrderStatusDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebSocketNotificationService {
    private final SimpMessagingTemplate messagingTemplate;

    public void sendMessage(OrderStatusDetails message) {
        messagingTemplate.convertAndSendToUser(message.id().toString(),
                "/queue/messages",
                message);
    }
}
