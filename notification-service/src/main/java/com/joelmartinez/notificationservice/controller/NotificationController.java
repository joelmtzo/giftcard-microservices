package com.joelmartinez.notificationservice.controller;

import com.joelmartinez.notificationservice.service.NotificationService;
import com.joelmartinez.notificationservice.service.request.SendMessageRequest;
import com.joelmartinez.notificationservice.service.response.SendMessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @RequestMapping(value = "/notification", method = RequestMethod.POST)
    public ResponseEntity<SendMessageResponse> index(@RequestBody SendMessageRequest request) {
        SendMessageResponse response = service.sendSms(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
