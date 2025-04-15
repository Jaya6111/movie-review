package com.ex.mreview.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.mreview.request.LoginRequest;
import com.ex.mreview.request.RegistrationRequest;
import com.ex.mreview.request.UpdateUserRequest;
import com.ex.mreview.response.AllUsersResponse;
import com.ex.mreview.response.LoginResponse;
import com.ex.mreview.response.RegistrationResponse;
import com.ex.mreview.service.UserService;

@RestController
@RequestMapping("/mr/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {
		return userService.login(request);
	}
	
	@PostMapping("/register")
	public RegistrationResponse register(@RequestBody @Valid RegistrationRequest request) {
		return userService.register(request);
	}
	
	@GetMapping("/getAllUsers")
	public AllUsersResponse getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/updateUser")
	public RegistrationResponse updateUser(@RequestBody @Valid UpdateUserRequest request) {
		return userService.updateUser(request);
	}
}
