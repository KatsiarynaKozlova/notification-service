package com.modsen.software.notification.dto.request;

public record PaymentStatusDetailsMessage(Long id, String status, Long orderId) implements StatusDetailsMessage {
}
