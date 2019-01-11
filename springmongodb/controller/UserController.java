package edu.hash.springmongodb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ResourceProperties.Content;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.hash.springmongodb.model.User;
import edu.hash.springmongodb.model.UserDto;
import edu.hash.springmongodb.repository.UserRepository;
import edu.hash.springmongodb.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/create",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody UserDto userDto)
	{
		userService.add(userDto);
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public List<User> getAll()
	{
		return userService.getAll();
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody UserDto userDto,@PathVariable String id)
	{
		userService.modi(userDto,id);
	}
	
	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Optional<User> findByID(@PathVariable String id)
	{
		return userService.findById(id);
	}
	
	
	
	@RequestMapping(value="/dById/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable String id)
	{
		userService.deleteById(id);
	}
	@DeleteMapping("/deleteAll")
	public void delete()
	{
		userService.deleteAll();
	}
}
