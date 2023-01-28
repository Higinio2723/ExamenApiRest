package com.backend.apirest.models.users;


public interface IUserService {

	public UserEntity findByUsername(String username);
}
