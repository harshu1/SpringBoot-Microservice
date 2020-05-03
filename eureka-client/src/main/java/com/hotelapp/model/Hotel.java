package com.hotelapp.model;

public class Hotel {

	private String name;
	private String city;
	private String cuisine;
	private Integer hotelId;
	
	
	
	public Hotel(String name, String city, String cuisine, Integer hotelId) {
		super();
		this.name = name;
		this.city = city;
		this.cuisine = cuisine;
		this.hotelId = hotelId;
	}
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	@Override
	public String toString() {
		return "Hotel [name=" + name + ", city=" + city + ", cuisine=" + cuisine + ", hotelId=" + hotelId + "]";
	}

}
