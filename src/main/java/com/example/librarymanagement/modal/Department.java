package com.example.librarymanagement.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "department")
public class Department extends BaseEntity {
	@Column(name = "department_name")
	private String departmentName;

	@Column(name = "description")
	private String description;

//	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
//	private Set<Role> roles = new HashSet<>();
}
