package com.fly.unicorn.controller;

import com.fly.unicorn.dto.UserDto;
import com.fly.unicorn.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {
	private final UserServiceImpl userService;

	@GetMapping(value = "login")
	public String loginPage() {
		log.info("?2");
		return "user/login";
	}

	@GetMapping(value = "users")
	public String createUser() {
		log.info("?");
		return "user/register";
	}

	@PostMapping(value = "/users")
	public ResponseEntity createUser(@RequestBody UserDto user) {
		log.info("User {}", user.toString());
		Long result = userService.createUser(user);
		return result != null ? ResponseEntity.ok().body("회원 가입이 완료되었습니다!") :
			ResponseEntity.badRequest().build();
	}
}
