package com.app.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.app.dto.Student;
import com.app.service.StudentService;

@Controller("studentController")
public class StudentControllerImpl implements StudentController {

	BufferedReader br = null;
	
	@Autowired
	private StudentService studentService;

	public StudentControllerImpl() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addStudent() {
		try {
			System.out.println("Studetnt Id : ");
			String sid = br.readLine();

			System.out.println("Student Name : ");
			String sname = br.readLine();

			System.out.println("Student Address : ");
			String saddr = br.readLine();

			Student student = new Student();
			student.setSaddr(saddr);
			student.setSid(sid);
			student.setSname(sname);
			
			String status = studentService.addStudent(student);
			if(status.equals("existed")) {
				System.out.println("Student Existed Already");
			}
			
			if(status.equals("success")) {
				System.out.println("Student Insertion Success");
			}
			
			if(status.equals("failure")) {
				System.out.println("Student Insertion Failed");
			}
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void search() {
		try {
			System.out.println("Enter Student Id");
			String sid = br.readLine();
			
			Student student = studentService.search(sid);
			
			if(student == null) {
				System.out.println("Student not existed");
			}else {
				System.out.println("Student Details");
				System.out.println("-----------------------------");
				System.out.println("Student Id : " + student.getSid());
				System.out.println("Student name : " + student.getSname());
				System.out.println("Student address : " + student.getSaddr());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateStudent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStudent() {
		// TODO Auto-generated method stub

	}

}
