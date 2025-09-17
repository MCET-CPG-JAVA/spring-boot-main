package com.example.librarymanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarymanagement.modal.Department;
import com.example.librarymanagement.modal.Role;
import com.example.librarymanagement.repository.DepartmentRepository;
import com.example.librarymanagement.repository.RoleRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	RoleRepository roleRepository;

	public Department addDepertment(Department departmentIn) {
		return departmentRepository.save(departmentIn);
	}

	public Department updateDepartment(Department departmentIn) {
		Optional<Department> existingDepartment = departmentRepository.findById(departmentIn.getId());

		if (existingDepartment.isPresent()) {
			Department updatedDepartment = existingDepartment.get();
			updatedDepartment.setDepartmentName(departmentIn.getDepartmentName());
			return departmentRepository.save(updatedDepartment);
		}

		return null;
	}

	public void deleteDepartment(Department departmentToDelete) {
		departmentRepository.deleteById(departmentToDelete.getId());
	}

	public List<Department> getAll() {
		return departmentRepository.findAll();
	}

	public void assignDepartmentToRole(Integer roleId, Integer departmentId) {
		Role role = roleRepository.findById(roleId).orElseThrow();
		Department department = departmentRepository.findById(departmentId).orElseThrow();

		// department.getRoles().add(role);
		departmentRepository.save(department);
	}

	// Clean up was done by standardizing variable names, removing debugging
	// statements, and improving readability by reducing the number of lines.

}
