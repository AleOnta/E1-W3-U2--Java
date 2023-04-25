package com.api_rest.config;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.github.javafaker.Faker;
import com.api_rest.model.Building;

@Configuration
public class BuildingConfig {

	@Bean("customBuilding")
	@Scope("prototype")
	public Building customBuilding() {
		return new Building();
	}
	
	@Bean("fakeBuilding")
	@Scope("prototype")
	public Building fakeBuilding() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		Building b = Building.builder()
					.id(null)
					.name(fake.university().name())
					.address(fake.address().streetName() + ", " + fake.address().streetAddressNumber())
					.city(fake.address().city())
					.securityCode(fake.internet().password(8, 15, true, true, true).substring(0, 7))
					.build();
		return b;
	}
	
	@Bean("paramsBuilding")
	@Scope("prototype")
	public Building paramsBuilding(String name, String address, String city, String securityCode) {
		Building b = Building.builder().name(name).address(address).city(city).securityCode(securityCode).build();
		return b;
	}
	
}
