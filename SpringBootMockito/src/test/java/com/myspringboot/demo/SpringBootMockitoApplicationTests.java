package com.myspringboot.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.myspringboot.demo.dao.UserRepository;
import com.myspringboot.demo.model.User;
import com.myspringboot.demo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootMockitoApplicationTests {

	@Autowired
	private UserService service;

	/** mocking the UserRepository here */
	
	@MockBean
	private UserRepository repository;

	/**testing a method which returns all the users details*/
	
	@Test	
	public void getUsersTest() {

		when(repository.findAll())
				.thenReturn(Stream.of(new User(101, "Riyaz", 31, "Hyderabad"), new User(102, "Syed", 35, "Mumbai"))
						.collect(Collectors.toList()));
		assertEquals(2, service.getUsers().size());
	}
	

	/**testing a method which returns the user details by Address 
	 * Here,irrespective of any address value, I will get that user object which i mention in thenReturn , 
	 * that's what Mockito do for us
	 * */
	
	@Test
	public void getUserbyAddressTest() {
		String address = "Hyderabad";
		when(repository.findByAddress(address))
				.thenReturn(Stream.of(new User(101, "Riyaz", 31,"Tokyo")).collect(Collectors.toList()));
		assertEquals(1, service.getUserbyAddress(address).size());
	}

	/**testing a method which saves the user details and returns it. */
	@Test
	public void saveUserTest() {
		User user = new User(102, "Syed", 35, "Mumbai");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.addUser(user));
	}

	
	/**
	 * Writing the test case for void method here
	 * testing a Delete method which does not returns anything,
	 * so verifying and counting whether this method is called or not
	 */

	@Test
	public void deleteUserTest() {
		User user = new User(101, "Riyaz", 31,"Hyderabad");
		service.deleteUser(user);
		verify(repository, times(1)).delete(user);
	}

}
