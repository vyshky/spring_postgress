package com.example.demo.services;

import com.example.demo.dtos.OfferDto;
import com.example.demo.entities.Offer;

import java.util.List;

public interface OfferService {
    void save(Offer offer);
    List<Offer> findAll();
    List<OfferDto> findOffersByOrganization(String oraganization);
    List<Offer> findOffersByPhone(String phone);
}
