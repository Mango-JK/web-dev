package com.fly.unicorn.service;

import com.fly.unicorn.domain.User;
import com.fly.unicorn.dto.UserDto;
import com.fly.unicorn.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;

@RequiredArgsConstructor
@Service("userService")
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Transactional
	@Override
	public Long createUser(UserDto user) {
		Long userId = userRepository.save(User.builder()
			.email(user.getEmail())
			.password(passwordEncoder.encode(user.getPassword()))
			.roles(Collections.singletonList("ROLE_USER"))
			.build())
			.getId();
		return userId;
	}
}
