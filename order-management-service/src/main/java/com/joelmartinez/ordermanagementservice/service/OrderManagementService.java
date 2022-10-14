package com.joelmartinez.ordermanagementservice.service;

import com.joelmartinez.ordermanagementservice.service.request.CreateOrderRequest;
import com.joelmartinez.ordermanagementservice.service.response.CreateOrderResponse;

public interface OrderManagementService {

    CreateOrderResponse create(CreateOrderRequest request);

}
