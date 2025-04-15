package com.ex.mreview.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.ex.mreview.entity.User;
import com.ex.mreview.repositories.UserRepository;
import com.ex.mreview.request.LoginRequest;
import com.ex.mreview.request.RegistrationRequest;
import com.ex.mreview.request.UpdateUserRequest;
import com.ex.mreview.response.AllUsersResponse;
import com.ex.mreview.response.LoginResponse;
import com.ex.mreview.response.RegistrationResponse;
import com.ex.mreview.security.JwtService;
import com.ex.mreview.service.UserService;
import com.ex.mreview.util.UserUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserUtil userUtil;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtService jwtService;
	
	@Override
	public LoginResponse login(@Valid LoginRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        String token = jwtService.generateToken(request.getUsername());
        return new LoginResponse(HttpStatus.OK, "200", "Welcome to Movie Review App", token);
    }

	@Override
	public RegistrationResponse register(@Valid RegistrationRequest request) {

		Optional<User> users = userRepository.findByEmail(request.getEmail());

		if (users.isPresent()) {
			return new RegistrationResponse(HttpStatus.PRECONDITION_FAILED, "412",
					"Given Email is already in use with other account", null);
		}

		User user = userUtil.setUser(request);

		User userRes = userRepository.save(user);

		if (user.getUserId() > 0) {
			return new RegistrationResponse(HttpStatus.CREATED, "201", "Registration successful", userRes);

		} else {
			return new RegistrationResponse(HttpStatus.INTERNAL_SERVER_ERROR, "500", "Registration is failed", null);
		}
	}

	@Override
	public AllUsersResponse getAllUsers() {

		List<User> users = userRepository.findAll();
		return new AllUsersResponse(HttpStatus.OK, "200", "All Users found", users);
	}

	@Override
	public RegistrationResponse updateUser(@Valid UpdateUserRequest request) {

		Optional<User> opUser = userRepository.findById(request.getUserId());
		
		if(opUser.isEmpty()) {
			return new RegistrationResponse(HttpStatus.NOT_FOUND, "404", "User not found", null);
		}
		User user = opUser.get();
		user.setEmail(request.getEmail());
		user.setUsername(request.getUsername());
		
		User updatedUser = userRepository.save(user);
		
		return new RegistrationResponse(HttpStatus.OK, "200", "User updated successfully", updatedUser);
	}
}
