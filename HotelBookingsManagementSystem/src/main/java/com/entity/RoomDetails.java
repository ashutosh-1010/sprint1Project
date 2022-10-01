package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RoomDetails {
	
	@Id
	@GeneratedValue
	private int room_id;
	
	//@NotBlank(message = "hotel_id is mandatory")
	private int hotel_id;
	@NotBlank(message = "room_no is mandatory")
	private String room_no;
	@NotBlank(message = "room_type is mandatory")
	private String room_type;
	//@NotBlank(message = "rate_per_day is mandatory")
	private double rate_per_day;
	//@NotBlank(message = "isavailable is mandatory")
	private boolean isavailable;
	//private Blob photo;
	
	@ManyToOne
	@JoinColumn(name="jid")//, unique = true)
	//@JsonBackReference
	//@JsonIgnore
	Hotel hotel;
	
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getRoom_no() {
		return room_no;
	}
	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public double getRate_per_day() {
		return rate_per_day;
	}
	public void setRate_per_day(double rate_per_day) {
		this.rate_per_day = rate_per_day;
	}
	public boolean getIsavailable() {
		return isavailable;
	}
	public void setIsavailable(boolean isavailable) {
		this.isavailable = isavailable;
	}
	
	@Override
	public String toString() {
		return "RoomDetails [room_id=" + room_id + ", hotel_id=" + hotel_id + ", room_no=" + room_no + ", room_type="
				+ room_type + ", rate_per_day=" + rate_per_day + ", isavailable=" + isavailable + "]";
	}
	
}


