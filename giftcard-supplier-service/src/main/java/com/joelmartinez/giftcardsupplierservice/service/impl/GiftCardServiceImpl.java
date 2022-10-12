package com.joelmartinez.giftcardsupplierservice.service.impl;

import com.joelmartinez.giftcardsupplierservice.service.GiftCardService;
import com.joelmartinez.giftcardsupplierservice.service.response.GiftCardResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GiftCardServiceImpl implements GiftCardService {

    @Override
    public GiftCardResponse generate(double value) {
        GiftCardResponse response = new GiftCardResponse();
        response.setUuid(UUID.randomUUID().toString());
        response.setValue(value);

        return response;
    }
}
