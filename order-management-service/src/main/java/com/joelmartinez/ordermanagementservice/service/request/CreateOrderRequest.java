package com.joelmartinez.ordermanagementservice.service.request;

import lombok.Data;

@Data
public class CreateOrderRequest {
    private String customer;
    private double giftCardValue;
}
