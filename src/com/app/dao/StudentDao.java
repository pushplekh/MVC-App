package com.app.dao;

import com.app.dto.Student;

public interface StudentDao {

	public String add(Student student);

	public Student search(String sid);

	public Student update(String student);

	public Student delete(String student);

}
