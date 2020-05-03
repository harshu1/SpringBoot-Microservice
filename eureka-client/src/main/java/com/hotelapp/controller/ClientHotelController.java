package com.hotelapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hotelapp.model.Hotel;

@RestController
public class ClientHotelController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/hotels", produces="application/json")
	public List<Hotel> findAll(){
		String uri="http://HOTEL-SERVICE/all-hotels";
		List<Hotel> hotelList = restTemplate.getForObject(uri,List.class);
		return hotelList;
	}
	
	@RequestMapping(value="/hotels-city/{city}", produces="application/json")
	public List<Hotel> findByCity(@PathVariable("city") String city){
		String uri="http://HOTEL-SERVICE/hotels-by-city/"+city;
		List<Hotel> hotelList = restTemplate.getForObject(uri,List.class);
		return hotelList;
	}
	@RequestMapping(value="/hotels/{hotelid}", produces="application/json")
	public Hotel findById(@PathVariable("hotelid") int id){
		String uri="http://HOTEL-SERVICE/one-hotel/"+id;
		Hotel hotel = restTemplate.getForObject(uri,Hotel.class);
		return hotel;
	}
	@RequestMapping(value="/say-hello/{username}")
	public String greet(@PathVariable("username")String name){
		String uri="http://HOTEL-SERVICE/greet/"+name;
		String msg = restTemplate.getForObject(uri,String.class);
		return msg;
	}
}
