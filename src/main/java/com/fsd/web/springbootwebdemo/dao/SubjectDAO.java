package com.fsd.web.springbootwebdemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fsd.web.springbootwebdemo.model.Book;
import com.fsd.web.springbootwebdemo.model.Subject;

@Repository
public interface SubjectDAO {
	
	public List<Subject> getSubject();

	public Subject getSubjectById(int subject_id);

	public String addSubject(Subject subject);

	public String deleteSubjectById(int subject_id);

}
