package com.example.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emp.domain.Student;
import com.example.emp.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> listAll() {
		return studentRepository.findAll();
	}
	
	public void save(Student student) {
		studentRepository.save(student);
	}
	
	public Student get(long id) {
		return studentRepository.findById(id).get();
	}
	 
	public void delete(long id) {
		studentRepository.deleteById(id);
	}

}
