package com.fly.unicorn.service;

import com.fly.unicorn.domain.User;
import com.fly.unicorn.dto.UserDto;

public interface UserService {
	Long createUser(UserDto user);
	User findUser(UserDto user);
}
