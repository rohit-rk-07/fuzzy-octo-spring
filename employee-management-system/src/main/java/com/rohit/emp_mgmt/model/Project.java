package com.rohit.emp_mgmt.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="projects_table")
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_id")
	private int id;
	
	@Column(name="project_name")
	private String name;
	
	@Column(name="project_desc")
	private String description;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="project_status")
	private String status;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="employee_projects",
			joinColumns=@JoinColumn(name="project_id"),
			inverseJoinColumns=@JoinColumn(name="employee_id")
			)
	private List<Employee> employees;
}


//id
//name
//description
//startDate
//endDate
//status
