package com.joelmartinez.notificationservice.service;

import com.joelmartinez.notificationservice.service.request.SendMessageRequest;
import com.joelmartinez.notificationservice.service.response.SendMessageResponse;

public interface NotificationService {

    SendMessageResponse sendSms(SendMessageRequest request);

}
