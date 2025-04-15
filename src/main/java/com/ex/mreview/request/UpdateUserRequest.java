package com.ex.mreview.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequest {

	@NotNull(message = "User ID must not be null")
	@Positive(message = "User ID must be a positive number")
	private Integer userId;
	
	@NotBlank(message = "Username is required")
	private String username;
	
	@Email(message = "Invalid email format")
    private String email;
	
	private String password;
}
