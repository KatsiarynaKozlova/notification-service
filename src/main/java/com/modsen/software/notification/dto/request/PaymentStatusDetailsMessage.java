package com.modsen.software.notification.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PaymentStatusDetailsMessage(Long id, String status, @JsonProperty("order_id") Long orderId) implements StatusDetailsMessage {
}
