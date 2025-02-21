package com.example.demo.repos2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Student;

public interface db2repo extends JpaRepository<Student, Integer> {

}
