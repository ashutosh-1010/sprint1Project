package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.IPayment;

@Repository
public interface IPaymentRepository extends JpaRepository<IPayment,Integer>
{
	

}
