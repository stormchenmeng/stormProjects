package com.wind.dao;

import com.wind.entity.StudentEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {

    Integer insertStudent(@Param("studentEntity") StudentEntity studentEntity);

    Integer updateStudent(@Param("studentEntity") StudentEntity studentEntity);

    Integer deleteStudent(@Param("id") int id);

    List<StudentEntity> findAllValidStudent();

    StudentEntity findStudentById(@Param("id") int id);
}
