package com.mentorondemand.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mentorondemand.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
    
	@Query(value = "SELECT user FROM User user WHERE user.firstName=?1")
	List<User> findByFirstName(String firstname);

	void deleteByUserId(int userId);
}
