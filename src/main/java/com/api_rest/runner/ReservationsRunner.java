package com.api_rest.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.api_rest.service.BuildingServices;
import com.api_rest.service.ReservationServices;
import com.api_rest.service.UserServices;
import com.api_rest.service.WorkstationServices;

@Component
public class ReservationsRunner implements ApplicationRunner {

	@Autowired UserServices userService;
	@Autowired BuildingServices buildService;
	@Autowired WorkstationServices wsService;
	@Autowired ReservationServices resService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("run...");
		
		userService.createfakeUser();
		userService.createfakeUser();
		userService.createfakeUser();
		userService.createfakeUser();
		userService.createfakeUser();
		userService.createfakeUser();
		userService.createfakeUser();
		userService.createfakeUser();
		
		
		buildService.createfakeBuilding();
		buildService.createfakeBuilding();
		buildService.createfakeBuilding();
		buildService.createfakeBuilding();
		buildService.createfakeBuilding();
		buildService.createfakeBuilding();
		
		
		wsService.createFakeWorkstation();
		wsService.createFakeWorkstation();
		wsService.createFakeWorkstation();
		wsService.createFakeWorkstation();
		wsService.createFakeWorkstation();
		wsService.createFakeWorkstation();
		wsService.createFakeWorkstation();
		wsService.createFakeWorkstation();
		wsService.createFakeWorkstation();
		wsService.createFakeWorkstation();
		wsService.createFakeWorkstation();
		wsService.createFakeWorkstation();
		wsService.createFakeWorkstation();
		wsService.createFakeWorkstation();
		wsService.createFakeWorkstation();
		
		
		resService.createFakeReservation();
		resService.createFakeReservation();
		resService.createFakeReservation();
		resService.createFakeReservation();
		resService.createFakeReservation();
		resService.createFakeReservation();
		resService.createFakeReservation();
		resService.createFakeReservation();
		resService.createFakeReservation();
		resService.createFakeReservation();
		resService.createFakeReservation();
		resService.createFakeReservation();
		resService.createFakeReservation();
		resService.createFakeReservation();
	}
}
