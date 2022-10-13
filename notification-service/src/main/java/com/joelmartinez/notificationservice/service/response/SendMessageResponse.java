package com.joelmartinez.notificationservice.service.response;

import lombok.Data;

@Data
public class SendMessageResponse {

    private String errorCode;
    private String message;
    private String phone;

}
