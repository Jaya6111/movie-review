package com.ex.mreview.util;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ex.mreview.entity.User;
import com.ex.mreview.request.RegistrationRequest;

@Component
public class UserUtil {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User setUser(@Valid RegistrationRequest request) {
		User user = new User();
		
		String encodedPassword = passwordEncoder.encode(request.getPassword());
		
		user.setUsername(request.getUsername());
		user.setPassword(encodedPassword);
		user.setEmail(request.getEmail());
		user.setCreated(LocalDate.now());
		
		return user;
	}
}
