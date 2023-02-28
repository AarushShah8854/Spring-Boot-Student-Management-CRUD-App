package com.example.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.emp.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
