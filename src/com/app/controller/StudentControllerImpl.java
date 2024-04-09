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
		try {
			System.out.println("Student ID : ");
			String sid = br.readLine();
			Student student = studentService.getStudent(sid);
			if(student==null) {
				System.out.println("Student not existed");
			}else {
				System.out.println("Student ID : " + student.getSid());
				System.out.print("Student Name : Old Value: '" + student.getSname() + "' new Value : ");
				String sname = br.readLine();
				System.out.print("Student Address : Old Value: '" + student.getSaddr() + "' new Value : ");
				String saddr = br.readLine();
				
				student.setSname(sname);
				student.setSaddr(saddr);
				String status = studentService.updateStudent(student);
				if(status.equals("success")) {
					System.out.println("Student Updation Success");
				}else {
					System.out.println("Student Updation Failure");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteStudent() {
		try {
			System.out.println("Enter Student ID for which you want to delte the entery of student");
			String sid = br.readLine();
			
			String status  = studentService.deleteStudent(sid);
			if(status.equals("success")) {
				System.out.println("Deletion of Student Success");
			}
			if(status.equals("failure")) {
				System.out.println("Student Deletion failure");
			}
			if(status.equals("notExisted")) {
				System.out.println("Student Not Existed");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
