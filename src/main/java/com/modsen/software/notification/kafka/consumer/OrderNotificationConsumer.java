package com.modsen.software.notification.kafka.consumer;

import com.modsen.software.notification.dto.request.OrderStatusDetailsMessage;
import com.modsen.software.notification.dto.request.PaymentStatusDetailsMessage;
import com.modsen.software.notification.kafka.constants.KafkaConstants;
import com.modsen.software.notification.service.WebSocketNotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderNotificationConsumer {
    private final WebSocketNotificationService notificationService;

    @KafkaListener(topics = KafkaConstants.KAFKA_ORDER_NOTIFICATION_TOPIC,
            properties = {"spring.json.value.default.type=com.modsen.software.notification.dto.request.OrderStatusDetailsMessage"})
    public void consume(OrderStatusDetailsMessage orderDetails) {
        notificationService.sendStatusDetailsMessage(orderDetails);
    }

    @KafkaListener(topics = KafkaConstants.KAFKA_PAYMENT_NOTIFICATION_TOPIC,
            properties = {"spring.json.value.default.type=com.modsen.software.notification.dto.request.PaymentStatusDetailsMessage"})
    public void consume(PaymentStatusDetailsMessage paymentDetails) {
        notificationService.sendStatusDetailsMessage(paymentDetails);
    }
}
