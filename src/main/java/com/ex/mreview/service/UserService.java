package com.ex.mreview.service;

import javax.validation.Valid;

import com.ex.mreview.request.LoginRequest;
import com.ex.mreview.request.RegistrationRequest;
import com.ex.mreview.request.UpdateUserRequest;
import com.ex.mreview.response.AllUsersResponse;
import com.ex.mreview.response.LoginResponse;
import com.ex.mreview.response.RegistrationResponse;

public interface UserService {

	public RegistrationResponse register(@Valid RegistrationRequest request);

	public LoginResponse login(@Valid LoginRequest request);

	public AllUsersResponse getAllUsers();

	public RegistrationResponse updateUser(@Valid UpdateUserRequest request);
}
