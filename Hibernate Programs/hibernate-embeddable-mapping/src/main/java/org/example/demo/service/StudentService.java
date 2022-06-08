package org.example.demo.service;

import java.util.List;

import org.example.demo.entity.Student;

public interface StudentService {
	public void createStudent(Student student);
	public List<Student> getAllStudents();
	public Student findStudentById(int id);
	
	public void updateStudentById(int id);
	
	public void deleteStudentById(int id);
}
