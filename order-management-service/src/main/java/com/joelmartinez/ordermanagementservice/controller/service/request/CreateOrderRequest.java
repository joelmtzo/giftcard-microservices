package com.joelmartinez.ordermanagementservice.controller.service.request;

import lombok.Data;

@Data
public class CreateOrderRequest {

    private String customer;
    private double giftCardValue;

}
