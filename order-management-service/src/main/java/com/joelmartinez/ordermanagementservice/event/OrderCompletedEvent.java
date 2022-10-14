package com.joelmartinez.ordermanagementservice.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderCompletedEvent {
    private String customer;
    private String orderId;
    private String giftCard;
    private double value;
}
