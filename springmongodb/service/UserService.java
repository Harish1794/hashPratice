package edu.hash.springmongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hash.springmongodb.model.User;
import edu.hash.springmongodb.model.UserDto;
import edu.hash.springmongodb.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepository;
	
	public User add(UserDto userDto)
	{
		User user=new User();
		user.setName(userDto.getName());
		user.setAge(userDto.getAge());
		return userRepository.save(user);
		
	}

	public Optional<User> findById(String id) 
	{
		return userRepository.findById(id);
	}

	public String deleteById(String id) 
	{
		userRepository.deleteById(id);
		return "document deleted----------!!!!";
	}

	public String modi(UserDto userDto, String pid) 
	{
//		Optional<User> optionalUser = userRepository.findById(id);
//		System.out.println("after");
//		if(optionalUser.isPresent())
//		{
//			System.out.println("optionalUser");
//		User user = new User();
//			
//			user.setName(userDto.getName());
//			userRepository.save(user);
//		}

		List<User> listUser = userRepository.findAll();
		
		
		for (int i = 0; i < listUser.size(); i++) 
		{
			User user = listUser.get(i);
			if(user.getId().equals(pid))
			{
				if(userDto.getName() != null)
				user.setName(userDto.getName());
				if(userDto.getAge()!=0)
				user.setAge(userDto.getAge());
				userRepository.save(user);
			}
		}
		
		return"update succes--------!!!";
	}

	public String deleteAll() 
	{
		userRepository.deleteAll();
		return "ALL DOCUMENTS DELETED";
	}

	public List<User> getAll() 
	{
		return userRepository.findAll();
	}
}
