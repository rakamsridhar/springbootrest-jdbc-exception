package com.fsd.web.springbootwebdemo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.fsd.web.springbootwebdemo.model.Book;
import com.fsd.web.springbootwebdemo.model.Subject;

@Service
public interface SubjectService {
	
	public List<Subject> getSubject();

	public Subject getSubjectById(int subject_id);

	public String addSubject(Subject subject);

	public String deleteSubjectById(int subject_id);

}
