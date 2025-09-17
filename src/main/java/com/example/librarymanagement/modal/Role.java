package com.example.librarymanagement.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "role")
public class Role extends BaseEntity {
	@Column(name = "role_name")
	private String role_name;

//	@ManyToOne
//	@JoinColumn(name = "department_id")
//	private Department department;
}
