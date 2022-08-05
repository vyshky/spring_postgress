package com.example.demo.services;

import com.example.demo.dtos.OfferDto;
import com.example.demo.entities.Offer;
import com.example.demo.repositories.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public void save(Offer offer) {
        offerRepository.save(offer);
    }

    @Override
    public List<Offer> findAll() {
        return offerRepository.findAll();
    }

    @Override
    public List<OfferDto> findOffersByOrganization(String oraganization) {
        List<Offer> offerList = offerRepository.findOffersByOrganization(oraganization);
        List<OfferDto> offerDtoList = offerList.stream()
               // .peek(offer -> offer.offerId = UUID.randomUUID() )
                .map(offer -> new OfferDto(offer.offerId, offer.organization, offer.phone))
                .toList();

//        for (int i = 0; i < offerList.size(); ++i) {
//            Offer offer = offerList.get(i);
//            offerDtoList.add(new OfferDto(
//                    offer.offerId,
//                    offer.organization,
//                    offer.phone
//            ));
//        }
        return offerDtoList;
    }

    @Override
    public List<Offer> findOffersByPhone(String phone) {
        return offerRepository.findOffersByPhone(phone);
    }
}
