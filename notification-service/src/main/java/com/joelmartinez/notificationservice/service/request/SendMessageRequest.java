package com.joelmartinez.notificationservice.service.request;

import lombok.Data;

@Data
public class SendMessageRequest {

    private String phone;
    private String message;

}
