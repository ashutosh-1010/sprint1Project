package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.IPayment;
import com.entity.ITransaction;
import com.repository.IPaymentRepository;

class IPaymentServiceImplTest {

	
	@Autowired
	IPaymentService paymentservice;
	
	@MockBean
	IPaymentRepository repo;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddPayment() {
		
		ITransaction t1 = new ITransaction();
		t1.setAmount(25000.4);
		t1.settId(876);

		
		IPayment p1 = new IPayment();
		p1.setpId(2);
		p1.setbId(56);
		p1.settId(123);
		p1.setT(t1);
		t1.setP(p1);
		
		
		 Mockito.when(repo.save(p1)).thenReturn(p1);
		 assertThat(paymentservice.addPayment(p1)).isEqualTo(p1);
		
	}

}
