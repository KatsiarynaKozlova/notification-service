package com.modsen.software.notification.kafka.consumer;

import com.modsen.software.notification.dto.request.OrderStatusDetails;
import com.modsen.software.notification.kafka.constants.KafkaConstants;
import com.modsen.software.notification.service.WebSocketNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderNotificationConsumer {
    private final WebSocketNotificationService notificationService;

    @KafkaListener(topics = KafkaConstants.KAFKA_ORDER_NOTIFICATION_TOPIC,
            properties = {"spring.json.value.default.type=com.modsen.software.notification.dto.request.OrderStatusDetails"})
    public void consume(OrderStatusDetails orderDetails) {
        notificationService.sendMessage(orderDetails);
    }
}
