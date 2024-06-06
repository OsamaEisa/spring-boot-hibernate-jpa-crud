package com.ossama.cruddemo.dao;

import com.ossama.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// supports component scanning and make the checked exceptions into unchecked exceptions
@Repository
public class StudentDAOImpl implements StudentDAO {

  // define fields for entity manager
  private EntityManager entityManager;

  // inject entity manager using constructor injection
  // Autowired here is optional as we have only one constructor
  @Autowired
  public StudentDAOImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  // implement save method
  @Override
  // as we make some changes to the database "performing an update"
  @Transactional
  public void save(Student student) {
    // just save the student object to the database
    entityManager.persist(student);
  }
}
