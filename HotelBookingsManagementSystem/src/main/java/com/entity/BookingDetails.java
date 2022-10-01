package com.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class BookingDetails
{
	@Id
	@GeneratedValue
	private int booking_id;
	private int hotel_id;
	private int room_id;
	private int user_id;
	private int no_of_adults;
	private int no_of_children;
	@JsonFormat(pattern="MM/dd/yyyy HH:mm:ss",timezone = "Asia/Kolkata")
	@NotNull(message = "From date is mandatory")
	private Date booked_from;
	@JsonFormat(pattern="MM/dd/yyyy HH:mm:ss",timezone = "Asia/Kolkata")
	@NotNull(message = "To date is mandatory")
	private Date booked_to;
	private double amount;
	
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getNo_of_adults() {
		return no_of_adults;
	}
	public void setNo_of_adults(int no_of_adults) {
		this.no_of_adults = no_of_adults;
	}
	public int getNo_of_children() {
		return no_of_children;
	}
	public void setNo_of_children(int no_of_children) {
		this.no_of_children = no_of_children;
	}
	public Date getBooked_from() {
		return booked_from;
	}
	public void setBooked_from(Date booked_from) {
		this.booked_from = booked_from;
	}
	public Date getBooked_to() {
		return booked_to;
	}
	public void setBooked_to(Date booked_to) {
		this.booked_to = booked_to;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "BookingDetails [booking_id=" + booking_id + ", hotel_id=" + hotel_id + ", room_id=" + room_id
				+ ", user_id=" + user_id + ", no_of_adults=" + no_of_adults + ", no_of_children=" + no_of_children
				+ ", booked_from=" + booked_from + ", booked_to=" + booked_to + ", amount=" + amount + "]";
	}
	
	
}
