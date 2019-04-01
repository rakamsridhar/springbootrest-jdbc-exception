package com.fsd.web.springbootwebdemo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fsd.web.springbootwebdemo.model.Subject;

public class SubjectRowMapper implements RowMapper<Subject> {

	@Override
	public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
		Subject subject = new Subject();
		subject.setSubject_id(rs.getInt("subject_id"));
		subject.setSubtitle(rs.getString("subtitle"));
		subject.setDuration_in_hours(rs.getInt("duration_in_hours"));
		subject.setBook_id(rs.getInt("book_id"));		
		return subject;
	}

}
