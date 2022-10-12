package com.joelmartinez.ordermanagementservice.controller.service;

import com.joelmartinez.ordermanagementservice.controller.service.request.CreateOrderRequest;
import com.joelmartinez.ordermanagementservice.controller.service.response.CreateOrderResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OrderManagementServiceImpl implements OrderManagementService {

    @Override
    public CreateOrderResponse create(CreateOrderRequest request) {
        CreateOrderResponse response = new CreateOrderResponse();
        response.setOrderId(UUID.randomUUID().toString());
        response.setGiftCardCode(UUID.randomUUID().toString());
        response.setCreatedAt(LocalDateTime.now());
        response.setValue(request.getGiftCardValue());

        return response;
    }
}
