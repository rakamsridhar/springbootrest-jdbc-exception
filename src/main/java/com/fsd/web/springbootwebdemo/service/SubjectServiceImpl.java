package com.fsd.web.springbootwebdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.web.springbootwebdemo.dao.SubjectDAO;
import com.fsd.web.springbootwebdemo.model.Book;
import com.fsd.web.springbootwebdemo.model.Subject;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDAO subjectDAO;

	@Override
	public List<Subject> getSubject() {
		
		return subjectDAO.getSubject();
	}

	@Override
	public Subject getSubjectById(int subject_id) {
		
		return subjectDAO.getSubjectById(subject_id);
	}

	@Override
	public String addSubject(Subject subject) {
		
		return subjectDAO.addSubject(subject);
	}

	@Override
	public String deleteSubjectById(int subject_id) {
		
		return subjectDAO.deleteSubjectById(subject_id);
	}

}
