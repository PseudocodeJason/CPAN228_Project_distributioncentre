package com.cpan252.distributioncentre;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cpan252.distributioncentre.model.DistributionCentre;
import com.cpan252.distributioncentre.model.Item;
import com.cpan252.distributioncentre.model.Item.Brand;
import com.cpan252.distributioncentre.model.User;
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
			.name("Square One")
			.longitude(231)
			.latitude(100).build());
			var distributionCentre3 = DCrepository.save(DistributionCentre.builder()
			.name("Sherway Gardens")
			.longitude(43)
			.latitude(-79).build());
			var distributionCentre4 = DCrepository.save(DistributionCentre.builder()
			.name("Eaton Centre")
			.longitude(44)
			.latitude(-78).build());
			itemRepository.save(Item.builder()
			.name("T-Shirt")
			.brand(Brand.STONEISLAND)
			.yearofcreation(2022)
			.price(new BigDecimal("3000"))
			.quantity(9)
			.distributionCentre(distributionCentre).build());
			itemRepository.save(Item.builder()
			.name("Gown")
			.brand(Brand.BALENCIAGA)
			.yearofcreation(2022)
			.price(new BigDecimal("2000"))
			.quantity(23)
			.distributionCentre(distributionCentre).build());
			itemRepository.save(Item.builder()
			.name("Coat")
			.brand(Brand.STONEISLAND)
			.yearofcreation(2022)
			.price(new BigDecimal("2524"))
			.quantity(21)
			.distributionCentre(distributionCentre).build());
			itemRepository.save(Item.builder()
			.name("Shorts")
			.brand(Brand.DIOR)
			.yearofcreation(2022)
			.price(new BigDecimal("1854"))
			.quantity(73)
			.distributionCentre(distributionCentre).build());
			itemRepository.save(Item.builder()
			.name("Pajamas")
			.brand(Brand.CHANEL)
			.yearofcreation(2022)
			.price(new BigDecimal("2421"))
			.quantity(4)
			.distributionCentre(distributionCentre).build());
			
			itemRepository.save(Item.builder()
			.name("T-Shirt")
			.brand(Brand.BALENCIAGA)
			.yearofcreation(2022)
			.price(new BigDecimal("1514"))
			.quantity(44)
			.distributionCentre(distributionCentre2).build());
			itemRepository.save(Item.builder()
			.name("Gown")
			.brand(Brand.STONEISLAND)
			.yearofcreation(2022)
			.price(new BigDecimal("3512"))
			.quantity(20)
			.distributionCentre(distributionCentre2).build());
			itemRepository.save(Item.builder()
			.name("Coat")
			.brand(Brand.STONEISLAND)
			.yearofcreation(2022)
			.price(new BigDecimal("2524"))
			.quantity(43)
			.distributionCentre(distributionCentre2).build());
			itemRepository.save(Item.builder()
			.name("Shorts")
			.brand(Brand.DIOR)
			.yearofcreation(2022)
			.price(new BigDecimal("1854"))
			.quantity(21)
			.distributionCentre(distributionCentre2).build());
			itemRepository.save(Item.builder()
			.name("Pajamas")
			.brand(Brand.CHANEL)
			.yearofcreation(2022)
			.price(new BigDecimal("2421"))
			.quantity(54)
			.distributionCentre(distributionCentre2).build());
			
			itemRepository.save(Item.builder()
			.name("Jacket")
			.brand(Brand.BALENCIAGA)
			.yearofcreation(2022)
			.price(new BigDecimal("5161"))
			.quantity(156)
			.distributionCentre(distributionCentre3).build());
			itemRepository.save(Item.builder()
			.name("Coat")
			.brand(Brand.STONEISLAND)
			.yearofcreation(2022)
			.price(new BigDecimal("3452"))
			.quantity(615)
			.distributionCentre(distributionCentre3).build());
			itemRepository.save(Item.builder()
			.name("Shorts")
			.brand(Brand.BALENCIAGA)
			.yearofcreation(2022)
			.price(new BigDecimal("2421"))
			.quantity(23)
			.distributionCentre(distributionCentre3).build());
			itemRepository.save(Item.builder()
			.name("Pajamas")
			.brand(Brand.DIOR)
			.yearofcreation(2022)
			.price(new BigDecimal("1354"))
			.quantity(21)
			.distributionCentre(distributionCentre3).build());
			itemRepository.save(Item.builder()
			.name("Dress")
			.brand(Brand.DIOR)
			.yearofcreation(2022)
			.price(new BigDecimal("1365"))
			.quantity(58)
			.distributionCentre(distributionCentre3).build());
			itemRepository.save(Item.builder()
			.name("Heels")
			.brand(Brand.CHANEL)
			.yearofcreation(2022)
			.price(new BigDecimal("2345"))
			.quantity(54)
			.distributionCentre(distributionCentre3).build());

			itemRepository.save(Item.builder()
			.name("Jacket")
			.brand(Brand.BALENCIAGA)
			.yearofcreation(2022)
			.price(new BigDecimal("5161"))
			.quantity(16)
			.distributionCentre(distributionCentre4).build());
			itemRepository.save(Item.builder()
			.name("Coat")
			.brand(Brand.STONEISLAND)
			.yearofcreation(2022)
			.price(new BigDecimal("3452"))
			.quantity(15)
			.distributionCentre(distributionCentre4).build());
			itemRepository.save(Item.builder()
			.name("Shorts")
			.brand(Brand.BALENCIAGA)
			.yearofcreation(2022)
			.price(new BigDecimal("2421"))
			.quantity(23)
			.distributionCentre(distributionCentre4).build());
			itemRepository.save(Item.builder()
			.name("Pajamas")
			.brand(Brand.DIOR)
			.yearofcreation(2022)
			.price(new BigDecimal("1354"))
			.quantity(31)
			.distributionCentre(distributionCentre4).build());
			itemRepository.save(Item.builder()
			.name("Dress")
			.brand(Brand.DIOR)
			.yearofcreation(2022)
			.price(new BigDecimal("1365"))
			.quantity(21)
			.distributionCentre(distributionCentre4).build());
			itemRepository.save(Item.builder()
			.name("Heels")
			.brand(Brand.CHANEL)
			.yearofcreation(2022)
			.price(new BigDecimal("2345"))
			.quantity(4)
			.distributionCentre(distributionCentre4).build());

			repository3.save(User.builder()
			.username("admin")
			.password(passwordEncoder.encode("admin")).build());
		};
	}

}
