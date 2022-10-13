package com.joelmartinez.giftcardsupplierservice.service.impl;

import com.joelmartinez.giftcardsupplierservice.service.GiftCardService;
import com.joelmartinez.giftcardsupplierservice.service.response.GiftCardResponse;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class GiftCardServiceImpl implements GiftCardService {

    private final WebClient.Builder webClient;

    public GiftCardServiceImpl(WebClient.Builder webClient) {
        this.webClient = webClient;
    }

    @Override
    public GiftCardResponse generate(double value) {
        GiftCardResponse response = new GiftCardResponse();
        response.setUuid(UUID.randomUUID().toString());
        response.setValue(value);

        // Prepare notification message
        SendMessageRequest request = new SendMessageRequest();
        request.setPhone("+524424829532");
        request.setMessage("Your product has been delivered successfully, please check your inbox.");

        // Call notification service to send SMS message to customer
        SendMessageResponse sendMessageResponse = webClient.build().post()
                .uri("http://notification-service/api/notification")
                .body(Mono.just(request), SendMessageRequest.class)
                .retrieve()
                .bodyToMono(SendMessageResponse.class)
                .block();

        return response;
    }
}

@Data
class SendMessageRequest {
    private String phone;
    private String message;
}

@Data
class SendMessageResponse {
    private String errorCode;
    private String message;
    private String phone;
}