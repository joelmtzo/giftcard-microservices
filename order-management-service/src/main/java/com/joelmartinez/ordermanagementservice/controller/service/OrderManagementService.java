package com.joelmartinez.ordermanagementservice.controller.service;

import com.joelmartinez.ordermanagementservice.controller.service.request.CreateOrderRequest;
import com.joelmartinez.ordermanagementservice.controller.service.response.CreateOrderResponse;

public interface OrderManagementService {

    CreateOrderResponse create(CreateOrderRequest request);

}
