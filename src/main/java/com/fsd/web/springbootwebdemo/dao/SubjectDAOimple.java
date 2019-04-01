package com.fsd.web.springbootwebdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.fsd.web.springbootwebdemo.mapper.SubjectRowMapper;
import com.fsd.web.springbootwebdemo.model.Book;
import com.fsd.web.springbootwebdemo.model.Subject;

@Repository
public class SubjectDAOimple implements SubjectDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Subject> getSubject() {
		String sql = "select * from bookstore.subject";
		List<Subject> subjects = jdbcTemplate.query(sql, new SubjectRowMapper());
		System.out.println("Subjects --------> " + subjects);
		return subjects;
	}

	@Override
	public Subject getSubjectById(int subject_id) {
		String sql = "select * from bookstore.subject where subject_id =" + subject_id;
		Subject subject = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Subject>());
		return subject;
	}

	@Override
	public String addSubject(Subject subject) {
		String sql = "insert into bookstore.subject values (" + subject.getSubject_id() +",'" +subject.getSubtitle() +"'," + subject.getDuration_in_hours() +"," + subject.getBook_id()+")";
		jdbcTemplate.execute(sql);
		return "Subject added successfully";
	}

	@Override
	public String deleteSubjectById(int subject_id) {
		String sql = "delete from bookstore.subject where subject_id =" + subject_id;
		jdbcTemplate.execute(sql);
		return "Subject deleted successfully";
	}

}
