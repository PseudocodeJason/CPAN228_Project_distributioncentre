package com.cpan252.distributioncentre.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@AllArgsConstructor
public class DistributionCentre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String items_available;
    private int available;
    private int longitude;
    private int latitude;
    
}
