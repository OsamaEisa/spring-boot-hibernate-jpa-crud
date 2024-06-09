package com.ossama.cruddemo;

import com.ossama.cruddemo.dao.StudentDAO;
import com.ossama.cruddemo.entity.Student;
import jakarta.persistence.TypedQuery;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// CommandLineRunner is from Spring boot
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// Executed after the Spring Beans have been loaded
			// createStudent(studentDAO);
			// readStudent(studentDAO);
			getAllStudents(studentDAO);
		};
	}

	private void getAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// creating a new student
		System.out.println("Creating new student...");
		Student student = new Student("Student 2", "last_name 2", "email2@fi.com");
		// saving the new student
		studentDAO.save(student);
		// display the new student
		System.out.println(studentDAO.findById(student.getId()));
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student...");
		Student student = new Student("Osama", "Eisa", "osamaeisa@fi.com");
		// save the student object
		studentDAO.save(student);
		// display the id of the student
		System.out.println(student.getId());
	}

}
