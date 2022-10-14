package com.joelmartinez.notificationservice.service.impl;

import com.joelmartinez.notificationservice.event.OrderCompletedEvent;
import com.joelmartinez.notificationservice.service.NotificationService;
import com.joelmartinez.notificationservice.service.request.SendMessageRequest;
import com.joelmartinez.notificationservice.service.response.SendMessageResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

@Log4j2
@Service
public class NotificationServiceImpl implements NotificationService {

    private final SnsClient snsClient;

    public NotificationServiceImpl(SnsClient snsClient) {
        this.snsClient = snsClient;
    }

    @KafkaListener(topics = "notificationTopic")
    public void handle(OrderCompletedEvent event) {
        log.info("Handle event {}", OrderCompletedEvent.class);

        SendMessageRequest request = new SendMessageRequest();
        request.setPhone(event.getCustomer());
        request.setMessage("GC Store: Your gift card for ABC Brand " + event.getValue() + " is " + event.getGiftCard());

        sendSms(request);
    }

    @Override
    public SendMessageResponse sendSms(SendMessageRequest request) {
        log.info("Sending SMS to customer with: {}", request.getPhone());
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

            log.info(publishResponse.sdkHttpResponse().statusCode());
            log.info(publishResponse.sdkHttpResponse().statusText().get());
            log.info("Notification has been sent successfully");
            return response;
        }

        throw new IllegalStateException("Notification service failed");
    }
}
