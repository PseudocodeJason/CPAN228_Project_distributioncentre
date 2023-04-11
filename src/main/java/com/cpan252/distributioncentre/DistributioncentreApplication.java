package com.cpan252.distributioncentre;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cpan252.distributioncentre.model.DistributionCentre;
import com.cpan252.distributioncentre.model.Item;
import com.cpan252.distributioncentre.model.Item.Brand;
import com.cpan252.distributioncentre.repository.DistributionCentreRepository;
import com.cpan252.distributioncentre.repository.ItemRepository;

@SpringBootApplication
public class DistributioncentreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributioncentreApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(DistributionCentreRepository repository, ItemRepository repository2){
		return args ->{
			repository.save(DistributionCentre.builder()
			.name("Yorkdale")
			.item("Gown")
			.available(50)
			.longitude(235)
			.latitude(110).build());
			repository.save(DistributionCentre.builder()
			.name("Yorkdale")
			.item("Shirt")
			.available(5)
			.longitude(235)
			.latitude(110).build());
			repository2.save(Item.builder()
			.name("Gown")
			.brand(Brand.BALENCIAGA)
			.yearofcreation(2022)
			.price(new BigDecimal("2000"))
			.quantity(50).build());
		};
	}

}
