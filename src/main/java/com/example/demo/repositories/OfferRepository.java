package com.example.demo.repositories;

import com.example.demo.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface OfferRepository extends JpaRepository<Offer, UUID> {
    List<Offer> findOffersByOrganization(String oraganization);

    List<Offer> findOffersByPhone(String phone);
}