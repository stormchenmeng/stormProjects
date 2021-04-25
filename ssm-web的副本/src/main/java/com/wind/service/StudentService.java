package com.wind.service;

import com.wind.entity.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface StudentService {

    int insertStudent(StudentEntity studentEntity);

    int deleteStudent(int id);

    int updateStudent(StudentEntity studentEntity);

    StudentEntity findStudentById(int id);

    List<StudentEntity> findAllStudent();

}

