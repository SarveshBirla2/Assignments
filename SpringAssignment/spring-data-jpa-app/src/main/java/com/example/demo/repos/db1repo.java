package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Student;

public interface db1repo extends JpaRepository<Student, Integer>{

}
