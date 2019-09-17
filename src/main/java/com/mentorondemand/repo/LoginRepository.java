package com.mentorondemand.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mentorondemand.model.Login;

public interface LoginRepository extends CrudRepository<Login, String>{

	@Query(value = "SELECT login FROM Login login WHERE login.email=?1 AND login.password=?2")
	List<Login> findByRole(String email, String password);

	List<Login> findByRole(String string);
  
}
