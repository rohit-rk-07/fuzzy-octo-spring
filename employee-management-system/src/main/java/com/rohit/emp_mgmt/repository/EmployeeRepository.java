package com.rohit.emp_mgmt.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rohit.emp_mgmt.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {
	
//	@Query("SELECT e FROM Employee e WHERE "
//		     + "LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
//		     + "LOWER(e.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
//		     + "LOWER(e.department.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
//		     + "LOWER(e.role.role) LIKE LOWER(CONCAT('%', :keyword, '%'))")
//		List<Employee> searchEmployees(@Param("keyword") String keyword);
	
	@Query("SELECT e FROM Employee e WHERE "
		     + "LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
		     + "LOWER(e.email) LIKE LOWER(CONCAT('%', :keyword, '%'))")
		List<Employee> searchEmployees(@Param("keyword") String keyword);
	
	@Query("Select e FROM Employee e ORDER By e.id ASC")
	List<Employee> findEmployeesAsc(Pageable pageable);
	
	@Query("Select e FROM Employee e ORDER BY e.id DESC")
	List<Employee> findEmployeesDesc(Pageable pageable);
	
//	@Query("SELECT e FROM Employee e WHERE e.department = :department")
//	List<Employee> findEmployeesByDepartmentID(@Param("department") Integer department);
	
	@Query("SELECT e FROM Employee e WHERE e.department.id = :department")
	List<Employee> findEmployeesByDepartmentID(@Param("department") int department);

}
