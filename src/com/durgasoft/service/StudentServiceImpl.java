package com.durgasoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durgasoft.dao.StudentDao;
import com.durgasoft.dao.StudentDaoImpl;
import com.durgasoft.dto.Student;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public String addStudent(Student student) {
		String status = studentDao.add(student);
		return status;
	}

	@Override
	public Student search(String sid) {

		Student student = studentDao.search(sid);

		return student;
	}

	@Override
	public String getStudent(Student sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteStudent(Student sid) {
		// TODO Auto-generated method stub
		return null;
	}

}
