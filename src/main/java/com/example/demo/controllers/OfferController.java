package com.example.demo.controllers;

import com.example.demo.dtos.OfferDto;
import com.example.demo.entities.Offer;
import com.example.demo.services.OfferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;

@RestController
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/offer")
    public String offer(@RequestParam("organization") String organization, @RequestParam("phone") String phone) {
        Offer offer = new Offer();
        offer.offerId= UUID.randomUUID();
        offer.phone = phone;
        offer.organization = organization;
        offerService.save(offer);
        return "No! " + organization;
    }

    @GetMapping("/offers")
    public List<Offer> offers() {
        return offerService.findAll();
    }

    @GetMapping("/offersByOrganization")
    public List<OfferDto> offersByOrganization(@RequestParam("organization") String organization) {
        return offerService.findOffersByOrganization(organization);
    }

    @GetMapping("/findOffersByPhone")
    public List<Offer> findOffersByPhone(@RequestParam("phone") String phone) {
        return offerService.findOffersByPhone(phone);
    }
}
