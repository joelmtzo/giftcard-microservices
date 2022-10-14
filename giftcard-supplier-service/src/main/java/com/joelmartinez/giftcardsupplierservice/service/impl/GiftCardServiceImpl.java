package com.joelmartinez.giftcardsupplierservice.service.impl;

import com.joelmartinez.giftcardsupplierservice.service.GiftCardService;
import com.joelmartinez.giftcardsupplierservice.service.response.GiftCardResponse;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
public class GiftCardServiceImpl implements GiftCardService {

    @Override
    public GiftCardResponse generate(double value) {
        log.info("Gift Card service - generate GC with value {}", value);

        GiftCardResponse response = new GiftCardResponse();
        response.setUuid(UUID.randomUUID().toString());
        response.setValue(value);

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