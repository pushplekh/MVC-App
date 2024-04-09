package com.app.service;

import com.app.dto.Student;

public interface StudentService {

	public String addStudent(Student student);

	public Student search(String sid);

	public Student getStudent(String sid);

	public String updateStudent(Student student);

	public String deleteStudent(String sid);

}
