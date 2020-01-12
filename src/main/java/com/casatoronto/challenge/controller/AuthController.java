package com.casatoronto.challenge.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.casatoronto.challenge.model.User;
import com.casatoronto.challenge.payload.ApiResponse;
import com.casatoronto.challenge.payload.JwtAuthenticationResponse;
import com.casatoronto.challenge.payload.LoginRequest;
import com.casatoronto.challenge.payload.SignUpRequest;
import com.casatoronto.challenge.security.JwtTokenProvider;
import com.casatoronto.challenge.service.UserService;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticate(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> register(@Valid @RequestBody SignUpRequest signupRequest) {

		Optional<User> user = userService.insert(signupRequest);

		if (user.isPresent()) {
			URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/user/{username}")
					.buildAndExpand(user.get().getUsername()).toUri();
			return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
		} else {
			return null;
		}
	}
}