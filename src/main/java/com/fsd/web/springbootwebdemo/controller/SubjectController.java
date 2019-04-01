package com.fsd.web.springbootwebdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fsd.web.springbootwebdemo.book.BookService;
import com.fsd.web.springbootwebdemo.model.Book;
import com.fsd.web.springbootwebdemo.model.Subject;
import com.fsd.web.springbootwebdemo.service.SubjectService;

@Controller
@RequestMapping("/subjects")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/all")
	@ResponseBody
	public List<Subject> getSubjectDetails() {
		return subjectService.getSubject();
	}
	
	@GetMapping("/{subject_id}")
	@ResponseBody
	public Subject getSubjectById(@PathVariable int subject_id) {
		return subjectService.getSubjectById(subject_id);
	}
	
	@PostMapping("/add")
	@ResponseBody
	public String addSubject(@RequestBody Subject subject) {
		System.out.println("new Subject values -------------------------> " + subject);
		return subjectService.addSubject(subject);
		
	}
	
	@DeleteMapping("/delete/{book_id}")
	@ResponseBody
	public String deleteSubjectById(@PathVariable int subject_id) {
		return subjectService.deleteSubjectById(subject_id);
	}

}
