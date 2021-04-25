package com.wind.serviceImpl;

import com.wind.dao.StudentDao;
import com.wind.entity.StudentEntity;
import com.wind.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public int insertStudent(StudentEntity studentEntity) {
        int result = studentDao.insertStudent(studentEntity);
        return result;
    }

    @Override
    public int deleteStudent(int id) {
        int result = studentDao.deleteStudent(id);
        return result;
    }

    @Override
    public int updateStudent(StudentEntity studentEntity) {
        int result = studentDao.updateStudent(studentEntity);
        return result;
    }

    @Override
    public StudentEntity findStudentById(int id) {
        StudentEntity studentEntity = studentDao.findStudentById(id);
        return studentEntity;
    }

    @Override
    public List<StudentEntity> findAllStudent() {
        List<StudentEntity> studentEntityList = studentDao.findAllValidStudent();
        return studentEntityList;
    }
}
