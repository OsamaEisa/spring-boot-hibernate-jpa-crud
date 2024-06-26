package com.ossama.cruddemo.dao;

import com.ossama.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

  @Override
  // no need to add @Transactional as we read only
  public Student findById(Integer id) {
    return entityManager.find(Student.class, id);
  }

  @Override
  // no need to add @Transactional as we read only
  public List<Student> findAll() {
    TypedQuery<Student> query = entityManager.createQuery( "FROM Student", Student.class);
    // TypedQuery<Student> query = entityManager.createQuery( "FROM Student order by lastName desc", Student.class);
    return query.getResultList();
  }

  @Override
  // no need to add @Transactional as we read only
  public List<Student> findByLastName(String lastName) {
    TypedQuery<Student> query = entityManager.createQuery( "FROM Student WHERE lastName=:variable", Student.class);
    query.setParameter("variable", lastName);
    return query.getResultList();
  }

  @Override
  // as we make a change to the database "performing an update"
  @Transactional
  public void update(Student student) {
    entityManager.merge(student);
  }

  @Override
  // as we make a change to the database "performing an update"
  @Transactional
  public void delete(Integer id) {
    Student student = entityManager.find(Student.class, id);
    entityManager.remove(student);
  }

  @Override
  @Transactional
  public int deletAll() {
    return entityManager.createQuery("DELETE FROM Student").executeUpdate();
  }
}
