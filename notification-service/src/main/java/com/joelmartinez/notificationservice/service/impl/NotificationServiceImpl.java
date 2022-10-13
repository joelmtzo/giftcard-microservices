package com.joelmartinez.notificationservice.service.impl;

import com.joelmartinez.notificationservice.service.NotificationService;
import com.joelmartinez.notificationservice.service.request.SendMessageRequest;
import com.joelmartinez.notificationservice.service.response.SendMessageResponse;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final SnsClient snsClient;

    public NotificationServiceImpl(SnsClient snsClient) {
        this.snsClient = snsClient;
    }

    @Override
    public SendMessageResponse sendSms(SendMessageRequest request) {
        PublishRequest publishRequest = PublishRequest.builder()
                .message(request.getMessage())
                .phoneNumber(request.getPhone())
                .build();

        PublishResponse publishResponse = snsClient.publish(publishRequest);

        if(publishResponse.sdkHttpResponse().isSuccessful()) {
            SendMessageResponse response = new SendMessageResponse();
            response.setErrorCode("");
            response.setMessage(publishResponse.messageId());
            response.setPhone(request.getPhone());
            return response;
        }

        throw new IllegalStateException("Notification service failed");
    }
}
