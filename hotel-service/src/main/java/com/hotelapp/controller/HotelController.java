package com.hotelapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelapp.model.Hotel;

@RestController
public class HotelController {

	@RequestMapping("/greet/{name}")
	public String welcomeMessage(@PathVariable("name") String name) {
		return "Welcome " + name;
	}

	@RequestMapping(value = "/all-hotels", produces = "application/json")
	public List<Hotel> viewHotels() {

		return getAllHotels();
	}

	@RequestMapping(value = "/hotels-by-city/{city}")
	public List<Hotel> getHotelsByCity(@PathVariable("city") String city) {
		List<Hotel> hotelList = getAllHotels();
		List<Hotel> newHotelList = new ArrayList<>();
		hotelList.forEach((hotel) -> {
			if (hotel.getCity().equals(city)) {
				newHotelList.add(hotel);
			}
		});
		return newHotelList;
	}

	@RequestMapping(value = "/one-hotel/{id}")
	public Hotel getOne(@PathVariable("id") int hotelId) {
		List<Hotel> hotelList = getAllHotels();
		for (Hotel hotel : hotelList) {
			if (hotel.getHotelId() == hotelId) {
				return hotel;
			}
		}
		return null;
	}

	private List<Hotel> getAllHotels() {
		List<Hotel> hotelList = new ArrayList<>();
		hotelList.add(new Hotel("Keys", "Bangalore", "Continental", 123));
		hotelList.add(new Hotel("Sangeeta", "Bangalore", "Indian", 124));
		hotelList.add(new Hotel("Ruffles", "Delhi", "Continental", 125));
		hotelList.add(new Hotel("A2B", "Bangalore", "Indian", 126));
		hotelList.add(new Hotel("Punjabi Tadka", "Pune", "Indian", 127));
		hotelList.add(new Hotel("The Dhaba", "Delhi", "Indian", 128));
		hotelList.add(new Hotel("The DhabaJunction", "Delhi", "Indian", 129));
		return hotelList;
	}

}
