package com.wind.service;

import com.wind.entity.StudentEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    Integer insertStudent(@Param("studentEntity") StudentEntity studentEntity);

    Integer updateStudent(@Param("studentEntity") StudentEntity studentEntity);

    Integer deleteStudent(@Param("id") int id);

    List<StudentEntity> findAllStudent();

    StudentEntity findStudentById(@Param("id") int id);

}
