package com.joelmartinez.giftcardsupplierservice.service;

import com.joelmartinez.giftcardsupplierservice.service.response.GiftCardResponse;

public interface GiftCardService {

    GiftCardResponse generate(double value);

}
