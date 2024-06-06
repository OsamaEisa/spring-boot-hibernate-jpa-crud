package com.ossama.cruddemo;

import com.ossama.cruddemo.dao.StudentDAO;
import com.ossama.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			createStudent(studentDAO);
		};
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
