package com.rohit.SpringJDBCex2.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rohit.SpringJDBCex2.model.Employee;

@Repository
public class EmployeeRepo {
	
	private JdbcTemplate jdbc;
		
	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	@Autowired
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void save(Employee e) {
		String sql = "insert into emp(id, name, age, email) values(?,?,?,?)";
		int rows = jdbc.update(sql, e.getId(), e.getName(), e.getAge(), e.getEmail());
		System.out.println("Affected rows : "+rows);
	}
	
	public List<Employee> findAll() {
		String sql = "select * from emp";
		
		RowMapper <Employee> mapper = new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setAge(rs.getInt("age"));
				e.setEmail(rs.getString("email"));
				
				return e;
			}
		};
		
		return jdbc.query(sql, mapper);
	}
}
