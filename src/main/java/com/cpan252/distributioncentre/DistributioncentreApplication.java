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
	public CommandLineRunner dataLoader(DistributionCentreRepository repository, ItemRepository repository2, UserRepository repository3, PasswordEncoder passwordEncoder){
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
			repository3.save(User.builder()
			.username("admin")
			.password(passwordEncoder.encode("admin")).build());
		};
	}

}
