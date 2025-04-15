package com.ex.mreview.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ex.mreview.entity.User;
import com.ex.mreview.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> opUser = repository.findByUsername(username);

		if (!opUser.isPresent()) {
			throw new UsernameNotFoundException("User Not Found");
		}

		User user = opUser.get();
		UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
				.username(user.getUsername()).password(user.getPassword())
				.authorities(new SimpleGrantedAuthority("USER")).build();
		return userDetails;
	}

}
