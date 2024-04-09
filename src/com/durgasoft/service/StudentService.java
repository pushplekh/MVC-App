package com.durgasoft.service;

import com.durgasoft.dto.Student;

public interface StudentService {

	public String addStudent(Student student);

	public Student search(String sid);

	public String getStudent(Student sid);

	public String updateStudent(Student student);

	public String deleteStudent(Student sid);

}
