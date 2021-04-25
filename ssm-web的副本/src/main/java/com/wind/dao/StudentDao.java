package com.wind.dao;

import com.wind.entity.StudentEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentDao {

    int insertStudent(@Param("studentEntity") StudentEntity studentEntity);

    int deleteStudent(@Param("id") int id);

    int updateStudent(@Param("studentEntity") StudentEntity studentEntity);

    StudentEntity findStudentById(@Param("id") int id);

    List<StudentEntity> findAllValidStudent();
}
