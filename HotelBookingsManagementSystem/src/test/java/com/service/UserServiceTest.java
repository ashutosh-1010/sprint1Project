package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.User;
import com.repository.UserRepository;

@SpringBootTest
class UserServiceTest {
	
	@Autowired
	IUserService uService;
	
	@MockBean
	UserRepository userRepository;
	
	@Test
	void testAddUser() {
		User u1=new User();
		u1.setUserId(1);
		u1.setUserName("Abi");
		u1.setEmail("jhsdgu@gMAIL.COM");
		u1.setAddress("eytsjgcnbchk hfsgk");
		u1.setPassword("jsyatbncu432");
		u1.setRole("customer");
		u1.setMobile("3764897092");
		
		Mockito.when(userRepository.save(u1)).thenReturn(u1);
		assertThat(uService.addUser(u1)).isEqualTo(u1);
	}
	
	@Test
	void testUpdateUser() {
		User u1=new User();
		u1.setUserId(1);
		u1.setUserName("Abi");
		u1.setEmail("jhsdgu@gMAIL.COM");
		u1.setAddress("eytsjgcnbchk hfsgk");
		u1.setPassword("jsyatbncu432");
		u1.setRole("customer");
		u1.setMobile("3764897092");
		
		Optional<User> u2=Optional.of(u1);
		
		Mockito.when(userRepository.findById(1)).thenReturn(u2);
		Mockito.when(userRepository.save(u1)).thenReturn(u1);
		
		u1.setUserName("Abi");
		u1.setEmail("abishek@gmail.com");
		u1.setAddress("Chennai");
		u1.setPassword("jsyatbncu432");
		u1.setRole("customer");
		u1.setMobile("9764897092");
		
		assertThat(uService.updateUser(u1)).isEqualTo(u1);
	}
	
	@Test
	void testRemoveUser() {
		User u1=new User();
		u1.setUserId(1);
		u1.setUserName("Abi");
		u1.setEmail("jhsdgu@gMAIL.COM");
		u1.setAddress("eytsjgcnbchk hfsgk");
		u1.setPassword("jsyatbncu432");
		u1.setRole("customer");
		u1.setMobile("3764897092");
		
		Optional<User> u2=Optional.of(u1);
		
		Mockito.when(userRepository.findById(1)).thenReturn(u2);
		Mockito.when(userRepository.existsById(u1.getUserId())).thenReturn(false);
		
		assertFalse(userRepository.existsById(u1.getUserId()));
	}
	
	@Test
	void testShowAllUsers() {
		User u1=new User();
		u1.setUserId(1);
		u1.setUserName("Abi");
		u1.setEmail("jhsdgu@gMAIL.COM");
		u1.setAddress("eytsjgcnbchk hfsgk");
		u1.setPassword("jsyatbncu432");
		u1.setRole("customer");
		u1.setMobile("3764897092");
		
		User u2=new User();
		u2.setUserId(2);
		u2.setUserName("Ram");
		u2.setEmail("ram@gmail.com");
		u2.setAddress("dghshkigjlkd");
		u2.setPassword("dsh38yr3hkf");
		u2.setRole("customer");
		u2.setMobile("9748638912");
		
		List<User> list=new ArrayList<>();
		list.add(u1);
		list.add(u2);
		
		Mockito.when(userRepository.findAll()).thenReturn(list);
		assertThat(uService.showAllUsers()).isEqualTo(list);
		
	}
	
	@Test
	void testShowUser(){
		User u2=new User();
		u2.setUserId(2);
		u2.setUserName("Ram");
		u2.setEmail("ram@gmail.com");
		u2.setAddress("dghshkigjlkd");
		u2.setPassword("dsh38yr3hkf");
		u2.setRole("customer");
		u2.setMobile("9748638912");
		
		Optional<User> uOptional=Optional.of(u2);
		
		Mockito.when(userRepository.findById(u2.getUserId())).thenReturn(uOptional);
		assertThat(uService.showUser(u2.getUserId())).isEqualTo(u2);
	}

}
