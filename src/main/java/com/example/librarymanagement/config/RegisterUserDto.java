package com.example.librarymanagement.config;


import com.example.librarymanagement.modal.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {
	private String email;

	private String password;
	private Integer roleId;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	private String fullName;

	private String confirmPassword;



}
