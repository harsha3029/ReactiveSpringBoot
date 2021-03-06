package com.application.service.student;

import com.application.dataaccessobject.StudentRepository;
import com.application.domainobject.StudentDO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService
{

    private  StudentRepository studentRepository;

    public StudentServiceImpl()
    {
		
    	
    }

    @Autowired
    public StudentServiceImpl(final StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<StudentDO> getAll()
    {
        return studentRepository.getAll();
    }


}
