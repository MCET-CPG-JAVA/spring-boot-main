package com.example.librarymanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.librarymanagement.modal.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);

	@Modifying
	@Query(nativeQuery = true, value = "update users set  role_id= ?2 where id = ?1 ")
	void updateRole(Integer id, Integer roleId);
}
