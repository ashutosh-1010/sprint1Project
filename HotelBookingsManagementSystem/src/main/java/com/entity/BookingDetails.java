package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

import javax.validation.constraints.NotNull;


@Entity
public class BookingDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	@Min(1)
	private int noOfAdults;
	@Min(0)
	private int noOfChildren;
	private double amount;
	
	@NotNull(message = "From date is mandatory")
	private String bookedFrom;
	
	@NotNull(message = "To date is mandatory")
	private String bookedTo;
	
	@ManyToOne
	@JoinColumn(name="hotelId")
	Hotel hotel;

	
	@OneToOne
	@JoinColumn(name="userId")
	User user;
	
	@ManyToOne
	@JoinColumn(name="roomId")
	RoomDetails roomDetails;
	
	
	public RoomDetails getRoomDetails() {
		return roomDetails;
	}
	

	public void setRoomDetails(RoomDetails roomDetails) {
		this.roomDetails = roomDetails;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getBookingId() 
	{
		return bookingId;
	}
	
	public void setBookingId(int bookingId) 
	{
		this.bookingId = bookingId;
	}
	
	public int getNoOfAdults()
	{
		return noOfAdults;
	}
	
	public void setNoOfAdults(int noOfAdults)
	{
		this.noOfAdults = noOfAdults;
	}
	
	public int getNoOfChildren()
	{
		return noOfChildren;
	}
	
	public void setNoOfChildren(int noOfChildren)
	{
		this.noOfChildren = noOfChildren;
	}
	
	
	public String getBookedFrom() {
		return bookedFrom;
	}

	public void setBookedFrom(String bookedFrom) {
		this.bookedFrom = bookedFrom;
	}

	public String getBookedTo() {
		return bookedTo;
	}

	public void setBookedTo(String bookedTo) {
		this.bookedTo = bookedTo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString()
	{
		return "BookingDetails [bookingId=" + bookingId + ", noOfAdults=" + noOfAdults + ", noOfChildren="
				+ noOfChildren + ", amount=" + amount + ", bookedFrom=" + bookedFrom + ", bookedTo=" + bookedTo
				+ ", hotel=" + hotel + ", user=" + user + ", roomDetails=" + roomDetails + "]";
	}
	
}


