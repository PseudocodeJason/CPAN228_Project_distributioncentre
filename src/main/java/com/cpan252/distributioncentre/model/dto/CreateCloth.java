package com.cpan252.distributioncentre.model.dto;

import java.math.BigDecimal;

import com.cpan252.distributioncentre.model.DistributionCentre;
import com.cpan252.distributioncentre.model.Item;
import com.cpan252.distributioncentre.model.Item.Brand;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCloth {
    @NotBlank
    private String name;

    @Min(2022)
    private int yearofcreation;

    @DecimalMin(value = "1000.1", inclusive = true)
    @NotNull
    private BigDecimal price;

    @NotNull
    private Brand brand;

    public Item toCloth() {
        return Item.builder()
                .name(this.getName())
                .yearofcreation(this.getYearofcreation())
                .price(this.getPrice())
                .brand(this.getBrand())
                .build();
    }
}
