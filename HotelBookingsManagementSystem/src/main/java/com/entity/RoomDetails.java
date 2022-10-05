package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class RoomDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roomId;
    

    @NotBlank(message = "room no is mandatory")
    private String roomNo;
    @NotBlank(message = "room type is mandatory")
    private String roomType;
   
    private double ratePerDay;
        private boolean isavailable;
   
    @ManyToOne
    @JoinColumn(name="hotelId")
    Hotel hotel;
    
    public Hotel getHotel() {
        return hotel;
    }
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    public int getRoomId() {
        return roomId;
    }
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomNo() {
        return roomNo;
    }
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }
    public String getRoomType() {
        return roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public double getRatePerDay() {
        return ratePerDay;
    }
    public void setRatePerDay(double ratePerDay) {
        this.ratePerDay = ratePerDay;
    }
    public boolean getIsavailable() {
        return isavailable;
    }
    public void setIsavailable(boolean isavailable) {
        this.isavailable = isavailable;
    }
	@Override
	public String toString() {
		return "RoomDetails [roomId=" + roomId + ", roomNo=" + roomNo + ", roomType=" + roomType + ", ratePerDay="
				+ ratePerDay + ", isavailable=" + isavailable + ", hotel=" + hotel + "]";
	}
}