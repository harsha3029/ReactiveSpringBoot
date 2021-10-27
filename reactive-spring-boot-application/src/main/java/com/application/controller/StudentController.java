package com.application.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.datatransferobject.StudentDTO;
import com.application.domainobject.StudentDO;
import com.application.service.student.StudentService;

@RestController

public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(final StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping("/findStudents")
	public List<StudentDTO> findStudents() {
		List<StudentDTO> listStudent = new ArrayList<StudentDTO>();
		List<StudentDO> studentDO = studentService.getAll();
		studentDO.forEach(e -> {
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setFirstName(e.getFirstName());
			studentDTO.setLastName(e.getLastName());
			studentDTO.setEmailId(e.getEmailId());
			studentDTO.setAddress(e.getAddress());
			studentDTO.setPhoneNumber(e.getPhoneNumber());
			BeanUtils.copyProperties(studentDO, studentDTO);
			listStudent.add(studentDTO);
		});
		return listStudent;
	}

	@GetMapping("/exportCSV")
	public void exportCSV(@Param("result") String result) throws Exception {
		String fileName = "Students.csv";
		File f=new File(".");
		String path=f.getAbsolutePath();
		Path filePath = Path.of(path+"/"+fileName);
		Files.writeString(filePath, "");
		Files.writeString(filePath, result);


	}

}
