package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.BookingDetails;

@Repository
public interface IBookingDetailsRepository extends JpaRepository<BookingDetails, Integer>
{

}
