package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public List<Student> listAll() {
		return repository.findAll();
	}

	public void save(Student student) {
		repository.save(student);
	}

	public Student get(Long id) {
		return repository.findById(id).get();
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
