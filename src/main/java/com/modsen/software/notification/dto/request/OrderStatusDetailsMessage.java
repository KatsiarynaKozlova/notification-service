package com.modsen.software.notification.dto.request;

public record OrderStatusDetailsMessage(Long id, String status) implements StatusDetailsMessage {
}
