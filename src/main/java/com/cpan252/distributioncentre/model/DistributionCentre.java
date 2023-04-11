package com.cpan252.distributioncentre.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DistributionCentre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String item;
    private int available;
    private int longitude;
    private int latitude;


}
