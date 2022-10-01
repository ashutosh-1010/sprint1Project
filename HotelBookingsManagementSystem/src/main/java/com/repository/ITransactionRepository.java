package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.ITransaction;

public interface ITransactionRepository extends JpaRepository<ITransaction,Integer>{

}
