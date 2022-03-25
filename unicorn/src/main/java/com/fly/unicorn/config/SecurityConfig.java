package com.fly.unicorn.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder(){
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/h2-console/**").permitAll()
			.antMatchers("/login/**", "/signup").permitAll()
			.anyRequest().authenticated()
//		.and()
//			.formLogin()
//			.loginPage("/login")
//			.loginProcessingUrl("/login/process")
//			.defaultSuccessUrl("/")
//			.permitAll()
			;
	}

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/h2-console/**");
		web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
	}
}
