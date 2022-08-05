package com.example.demo.dtos;

import java.util.UUID;

public class OfferDto {
    public UUID offerId;
    public String organization;
    public String phone;

    public OfferDto(UUID offerId, String organization, String phone) {
        this.offerId = offerId;
        this.organization = organization;
        this.phone = phone;
    }
}
