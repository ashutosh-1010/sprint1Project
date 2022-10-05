package com.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "From date is mandatory")
	private Date bookedFrom;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "To date is mandatory")
	private Date bookedTo;
	
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
	
	public Date getBookedFrom() 
	{
		return bookedFrom;
	}
	
	public void setBookedFrom(Date bookedFrom) 
	{
		this.bookedFrom = bookedFrom;
	}
	
	public Date getBookedTo() 
	{
		return bookedTo;
	}
	
	public void setBookedTo(Date bookedTo) 
	{
		this.bookedTo = bookedTo;
	}
	
	public double getAmount() 
	{
		return amount;
	}
	
	public void setAmount(double amount)
	{
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


