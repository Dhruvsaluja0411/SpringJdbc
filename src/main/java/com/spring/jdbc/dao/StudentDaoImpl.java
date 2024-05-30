package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student student) {
		// TODO Auto-generated method stub

        //Insert Query
        String query = "INSERT INTO STUDENT(Id, Name, City) VALUES (?,?,?);";
        int rows = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return rows;
	}

	@Override
	public int change(Student student) {
		// TODO Auto-generated method stub
		
		//Update Query
        String query = "UPDATE STUDENT SET Name = ?, City=? WHERE Id = ?;";
        int rows = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return rows;
	}

	@Override
	public int delete(Student student) {
		// TODO Auto-generated method stub
		
		//Delete query
		String query = "DELETE FROM Student WHERE Id = ?;";
		int rows = this.jdbcTemplate.update(query, student.getId());
		return rows;
	}

	@Override
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM Student WHERE id = ?;";
		RowMapper<Student> rm = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query,rm, studentId);
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM Student;";
		RowMapper<Student> rm = new RowMapperImpl();
		List<Student> students = this.jdbcTemplate.query(query, rm);
		return students;
	}
	
}
