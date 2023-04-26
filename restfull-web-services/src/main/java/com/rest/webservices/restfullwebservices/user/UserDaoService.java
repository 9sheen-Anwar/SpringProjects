package com.rest.webservices.restfullwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;
//to implement method to save or retrieve user data
// we will use JPA/Hibernate to talk to database
@Component
public class UserDaoService {
	private static List<Users> users =new ArrayList<>();
	private static int usersCount=0;
	//UserDaoService will talk to Static Array List to extract user list
	static{
		users.add(new Users(++usersCount, "Chinki",LocalDate.now().minusYears(25)));
		users.add(new Users(++usersCount, "Eve",LocalDate.now().minusYears(20)));
		users.add(new Users(++usersCount, "Jim",LocalDate.now().minusYears(15)));
	}
	
	public List<Users> findAll(){
		return users;
	}
	
	//we can do this by for loop or functional programming
	//taking a list of user converting it into a stream and filtering based on a predicate
	//predicate basically checks if the ID of user matches whatever Id is passed in
	public Users findbyId(int id){
		Predicate<? super Users> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().get();
		
	}
	
	public Users save(Users user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
		
		
	}

	public void deletebyId(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Users> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
		
	}

}
