package com.app.dao;

import com.app.dto.Student;

public interface StudentDao {

	public String add(Student student);

	public Student search(String sid);

	public String update(Student student);

	public String delete(String student);

}
