package com.example.demo.controllers;

import com.example.demo.entities.Offer;
import com.example.demo.repositories.OfferRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;

@RestController
public class OfferController {

    private final OfferRepository offerRepository;

    public OfferController(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @GetMapping("/offer")
    public String offer(@RequestParam("organization") String organization) {
        Offer offer = new Offer();
        offer.offerId= UUID.randomUUID();
        offer.organization = organization;
        offerRepository.save(offer);
        return "No! " + organization;
    }

    @GetMapping("/offers")
    public List<Offer> offers() {
        return offerRepository.findAll();
    }

    @GetMapping("/offersByOrganization")
    public List<Offer> offersByOrganization(@RequestParam("organization") String organization) {
        return offerRepository.findOffersByOrganization(organization);
    }
}
