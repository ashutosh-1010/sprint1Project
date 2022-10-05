package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Hotel {    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int hotelId;
    
    @NotBlank(message = "city is mandatory")
    String city;
    
    
    @NotBlank(message = "hotel name is mandatory")
    String hotelName;
    
    
    @NotBlank(message = "address is mandatory")
    String address;
    
    
    @NotBlank(message = "description is mandatory")
    String description;
    
    double avgRatePerDay;
    
    @Email
    String email;
    
    @NotBlank(message = "phone1 is mandatory")
    String phone1;
    
    @NotBlank(message = "phone2 is mandatory")
    String phone2;
    
    @NotBlank(message = "phone2 is mandatory")
    String website;
    
    public int getHotelId() {
        return hotelId;
    }

	public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getHotelName() {
        return hotelName;
    }
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getAvgRatePerDay() {
        return avgRatePerDay;
    }
    public void setAvgRatePerDay(double avgRatePerDay) {
        this.avgRatePerDay = avgRatePerDay;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone1() {
        return phone1;
    }
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }
    public String getPhone2() {
        return phone2;
    }
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    
    @Override
    public String toString() {
        return "Hotel [hotel_id=" + hotelId + ", city=" + city + ", hotel_name=" + hotelName + ", address=" + address
                + ", description=" + description + ", avg_rate_per_day=" + avgRatePerDay + ", email=" + email
                + ", phone1=" + phone1 + ", phone2=" + phone2 + ", website=" + website + "]";
    }
}