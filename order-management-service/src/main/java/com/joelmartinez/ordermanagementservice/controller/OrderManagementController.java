package com.joelmartinez.ordermanagementservice.controller;

import com.joelmartinez.ordermanagementservice.controller.service.OrderManagementService;
import com.joelmartinez.ordermanagementservice.controller.service.request.CreateOrderRequest;
import com.joelmartinez.ordermanagementservice.controller.service.response.CreateOrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderManagementController {

    private final OrderManagementService service;

    public OrderManagementController(OrderManagementService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<CreateOrderResponse> cd(@RequestBody CreateOrderRequest request) {
        CreateOrderResponse response = service.create(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
