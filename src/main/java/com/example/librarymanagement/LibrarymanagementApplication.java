package com.example.librarymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication()
public class LibrarymanagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(LibrarymanagementApplication.class, args);
	}
}