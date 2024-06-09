package com.ossama.cruddemo.dao;

import com.ossama.cruddemo.entity.Student;

public interface StudentDAO {

  void save(Student student);

  Student findById(Integer id);
}
