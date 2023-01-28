package com.backend.apirest.models.users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<UserEntity, Long>{
	
	public UserEntity findByUsername(String username);

}
