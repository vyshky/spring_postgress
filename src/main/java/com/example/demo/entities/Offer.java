package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "offers")
public class Offer {
    @Id
    public UUID offerId;
    public String organization;
}
