package com.cpan252.distributioncentre;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cpan252.distributioncentre.model.DistributionCentre;
import com.cpan252.distributioncentre.model.Item;
import com.cpan252.distributioncentre.model.User;
import com.cpan252.distributioncentre.model.Item.Brand;
import com.cpan252.distributioncentre.repository.DistributionCentreRepository;
import com.cpan252.distributioncentre.repository.ItemRepository;
import com.cpan252.distributioncentre.repository.UserRepository;

@SpringBootApplication
public class DistributioncentreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributioncentreApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(DistributionCentreRepository DCrepository, ItemRepository itemRepository, UserRepository repository3, PasswordEncoder passwordEncoder){
		return args ->{
			var distributionCentre = DCrepository.save(DistributionCentre.builder()
			.name("Yorkdale")
			.longitude(235)
			.latitude(110).build());
			var distributionCentre2 = DCrepository.save(DistributionCentre.builder()
			.name("SquareOne")
			.longitude(231)
			.latitude(100).build());
			itemRepository.save(Item.builder()
			.name("T-Shirt")
			.brand(Brand.STONEISLAND)
			.yearofcreation(2022)
			.price(new BigDecimal("3000"))
			.quantity(40)
			.distributionCentre(distributionCentre).build());
			itemRepository.save(Item.builder()
			.name("Gown")
			.brand(Brand.BALENCIAGA)
			.yearofcreation(2022)
			.price(new BigDecimal("2000"))
			.quantity(20)
			.distributionCentre(distributionCentre).build());
			itemRepository.save(Item.builder()
			.name("T-Shirt")
			.brand(Brand.BALENCIAGA)
			.yearofcreation(2022)
			.price(new BigDecimal("3000"))
			.quantity(40)
			.distributionCentre(distributionCentre2).build());
			itemRepository.save(Item.builder()
			.name("Gown")
			.brand(Brand.STONEISLAND)
			.yearofcreation(2022)
			.price(new BigDecimal("2000"))
			.quantity(20)
			.distributionCentre(distributionCentre2).build());
			

			repository3.save(User.builder()
			.username("admin")
			.password(passwordEncoder.encode("admin")).build());
		};
	}

}
