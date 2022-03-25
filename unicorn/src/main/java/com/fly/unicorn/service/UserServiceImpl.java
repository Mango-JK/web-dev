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

	public User findUser(UserDto user) {
		User member = userRepository.findByEmail(user.getEmail())
			.orElseThrow(() -> new IllegalArgumentException("아이디 혹은 비밀번호가 잘못되었습니다."));
		return member;
	}

	public boolean checkPassword(User member, UserDto user) {
		return passwordEncoder.matches(user.getPassword(), member.getPassword());
	}
}
