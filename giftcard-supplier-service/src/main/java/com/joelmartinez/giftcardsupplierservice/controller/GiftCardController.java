package com.joelmartinez.giftcardsupplierservice.controller;

import com.joelmartinez.giftcardsupplierservice.service.GiftCardService;
import com.joelmartinez.giftcardsupplierservice.service.request.GiftCardRequest;
import com.joelmartinez.giftcardsupplierservice.service.response.GiftCardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/gift-card")
public class GiftCardController {

    private final GiftCardService service;

    public GiftCardController(GiftCardService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<GiftCardResponse> generate(@RequestBody GiftCardRequest request) {
        GiftCardResponse response = service.generate(request.getValue());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
