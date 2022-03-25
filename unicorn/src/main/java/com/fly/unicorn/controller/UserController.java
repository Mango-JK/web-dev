package com.fly.unicorn.controller;

import com.fly.unicorn.domain.User;
import com.fly.unicorn.dto.UserDto;
import com.fly.unicorn.jwt.JwtTokenProvider;
import com.fly.unicorn.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {
	private final UserServiceImpl userService;
	private final JwtTokenProvider jwtTokenProvider;

	@GetMapping(value = "login")
	public String loginPage() {
		return "user/login";
	}

	@GetMapping(value = "signup")
	public String createUserPage() {
		return "user/signup";
	}

	@PostMapping(value = "signup")
	public ResponseEntity createUser(@RequestBody UserDto user) {
		log.info("User {}", user.toString());
		// TODO email 중복 검사
		Long result = userService.createUser(user);
		return result != null ? ResponseEntity.ok().body("회원 가입이 완료되었습니다!") :
			ResponseEntity.badRequest().build();
	}

	// 로그인
	@PostMapping("login")
	public ResponseEntity login(@RequestBody UserDto user, HttpServletResponse response) {
		User member = userService.findUser(user);
		boolean checkResult = userService.checkPassword(member, user);

		if(!checkResult) {
			throw new IllegalArgumentException("아이디 혹은 비밀번호가 잘못되었습니다.");
		}

		String token = jwtTokenProvider.createToken(member.getEmail(), member.getRoles());
		response.setHeader("Authorization", "Bearer " + token);
		return ResponseEntity.ok().body("로그인 성공!");
	}

	@ExceptionHandler
	public String exceptionHandler(Exception exception) {
		return exception.getMessage();
	}
}
