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
			createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// getAllStudents(studentDAO);
			// getStudentByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAll(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating new students...");
		Student student1 = new Student("Student 1", "last_name 1", "email_1@fi.com");
		studentDAO.save(student1);

		Student student2 = new Student("Student 2", "last_name 2", "email_2@fi.com");
		studentDAO.save(student2);

		Student student3 = new Student("Student 3", "last_name 3", "email_3@fi.com");
		studentDAO.save(student3);
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		System.out.println("Number of rows deleted: " + studentDAO.deletAll());
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.delete(3);
		System.out.println("Student with ID 3 was deleted..");
	}

	private void updateStudent(StudentDAO studentDAO) {
		// to update we first retrieve the student based on its ID
		Student student = studentDAO.findById(2); // the second one for example
		System.out.println("updating the second student...");
		// change the first name
		student.setFirstName("Ahmed");
		student.setLastName("Mostafa");
		// update and save the changes
		studentDAO.update(student);
		// display the modified student
		System.out.println(student);

	}

	private void getStudentByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Eisa");
		for (Student student : students) {
			System.out.println(student);
		}
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
		Student student = new Student("Student 3", "Eisa", "email3@fi.com");
		// save the student object
		studentDAO.save(student);
		// display the id of the student
		System.out.println(student.getId());
	}

}
