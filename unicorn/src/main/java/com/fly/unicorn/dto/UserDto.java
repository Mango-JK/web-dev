package com.fly.unicorn.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter @ToString
@NoArgsConstructor
public class UserDto {
	private String email;
	private String username;
	private String password;
}
