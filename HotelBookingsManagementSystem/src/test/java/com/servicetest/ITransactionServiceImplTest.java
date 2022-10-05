package com.servicetest;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.entity.ITransaction;
import com.repository.ITransactionRepository;
import com.service.ITransactionService;

@SpringBootTest
class ITransactionServiceImplTest {

	@Autowired
	ITransactionService TService;
	
	@MockBean
	ITransactionRepository TRepository;
	@Test
	void testAddTransaction() {
	
		ITransaction t = new ITransaction();
		
		t.setTransactionId(12);
		t.setAmount(15000);
	
		Mockito.when(TRepository.save(t)).thenReturn(t);
		assertThat(TService.addTransaction(t)).isEqualTo(t);
	}

}

