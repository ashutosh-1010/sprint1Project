package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.IPayment;

public interface IPaymentRepository extends JpaRepository<IPayment,Integer>
{
	

}
