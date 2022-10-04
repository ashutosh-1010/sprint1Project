package com.service;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.IPayment;
import com.entity.ITransaction;
import com.repository.IPaymentRepository;
@SpringBootTest 
class IPaymentServiceImplTest {

	@Autowired
	IPaymentService PService;
	@MockBean
	IPaymentRepository PRepository;
	@Test
	void testAddPayment() {
	
ITransaction transaction = new ITransaction();
		
		transaction.setTransactionId(12);
		transaction.setAmount(15000);
		
		IPayment p= new IPayment();
		p.setpId(1);
		p.setbId(1);
		p.setT(transaction);
		
		
		Mockito.when(PRepository.save(p)).thenReturn(p);
		assertThat(PService.addPayment(p)).isEqualTo(p);
	}

}
