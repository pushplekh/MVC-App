package com.app.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.controller.StudentController;

public class Test {

	public static void main(String[] args) throws NumberFormatException, IOException {
		ApplicationContext context = new AnnotationConfigApplicationContext(com.app.config.AppConfig.class);

		StudentController studentController = (StudentController) context.getBean("studentController");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("1 Add");
			System.out.println("2. Search");
			System.out.println("3. Update");
			System.out.println("4. Delete");
			System.out.println("5. Exit");
			System.out.println("Your Optioin[1,2,3,4,5] : ");

			int Option = Integer.parseInt(br.readLine());

			switch (Option) {
			case 1:
				studentController.addStudent();
				break;

			case 2:
				studentController.search();
				break;
			case 3:
				studentController.updateStudent();
				break;
			case 4:
				studentController.deleteStudent();
				break;
			case 5:
				System.out.println("Thanks for using the application");
				System.exit(0);
				break;
				
			default:
				System.out.println("Thanks for using the application");
				System.exit(0);
				break;
			}

		}

	}
}
