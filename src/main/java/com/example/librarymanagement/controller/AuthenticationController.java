package com.example.librarymanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.librarymanagement.config.LoginUserDto;
import com.example.librarymanagement.config.RegisterUserDto;
import com.example.librarymanagement.modal.LoginResponse;
import com.example.librarymanagement.modal.User;
import com.example.librarymanagement.service.AuthenticationService;
import com.example.librarymanagement.service.JwtService;

import java.util.Date;
import java.util.List;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
	private final JwtService jwtService;

	private final AuthenticationService authenticationService;

	public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
		this.jwtService = jwtService;
		this.authenticationService = authenticationService;
	}

	@PostMapping("/signup")
	public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
		User registeredUser = authenticationService.signup(registerUserDto);

		return ResponseEntity.ok(registeredUser);
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
		System.out.println(loginUserDto);
		User authenticatedUser = authenticationService.authenticate(loginUserDto);

		String jwtToken = jwtService.generateToken(authenticatedUser);

		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setUser(authenticatedUser);
		loginResponse.setToken(jwtToken);
		loginResponse.setExpiresIn(jwtService.getExpirationTime());
		return ResponseEntity.ok(loginResponse);
	}

	@GetMapping("/get-all")
	List<User> getAll() {
		List<User> bookList = authenticationService.getAll();
		return bookList;
	}
	

	@PutMapping("/update")
	@ResponseStatus(value = HttpStatus.OK)
	public void updateRole(@PathVariable Integer id, @PathVariable Integer roleId) {
		authenticationService.updateRole(id, roleId);
	}
}
