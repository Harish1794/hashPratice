package edu.hash.springmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.hash.springmongodb.model.User;
@Repository
public interface UserRepository extends MongoRepository<User,String>
{
//	public User findById(String id);
	
}
