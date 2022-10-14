package com.joelmartinez.ordermanagementservice.service.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateOrderResponse {

    private String orderId;
    private String giftCardCode;
    private double value;
    private LocalDateTime createdAt;

}
