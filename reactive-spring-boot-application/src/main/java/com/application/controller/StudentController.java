package com.application.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.datatransferobject.StudentDTO;
import com.application.domainobject.StudentDO;
import com.application.service.student.StudentService;

@RestController
@RequestMapping("/findStudents")
public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(final StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public StudentDTO findStudents() {
		StudentDTO studentDTO = new StudentDTO();
		StudentDO studentDO = studentService.getAll();
		BeanUtils.copyProperties(studentDO, studentDTO);
		return studentDTO;
	}
}
