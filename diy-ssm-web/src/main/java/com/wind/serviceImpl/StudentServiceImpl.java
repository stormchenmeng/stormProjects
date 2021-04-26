package com.wind.serviceImpl;

import com.wind.dao.StudentDao;
import com.wind.service.StudentService;
import com.wind.entity.StudentEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class StudentServiceImpl implements StudentService {

    private final static Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Resource
    private StudentDao studentDao;

    @Override
    public Integer insertStudent(StudentEntity studentEntity) {
        Integer result = studentDao.insertStudent(studentEntity);
        logger.info("insertStudent result={}", result);
        return result;
    }

    @Override
    public Integer updateStudent(StudentEntity studentEntity) {
        Integer result = studentDao.updateStudent(studentEntity);
        logger.info("updateStudent result={}", result);
        return result;
    }

    @Override
    public Integer deleteStudent(int id) {
        Integer result = studentDao.deleteStudent(id);
        logger.info("deleteStudent result={}", result);
        return result;
    }

    @Override
    public List<StudentEntity> findAllStudent() {
        List<StudentEntity> entities = studentDao.findAllValidStudent();
        logger.info("findAllStudent result={}", (entities != null ? entities.size() : 0));
        Objects.requireNonNull(entities).stream().filter(Objects::isNull)
                .forEach(studentEntity -> {
                    if (studentEntity != null) {
                        System.out.println(studentEntity.toString());
                    }
                });
        return entities;
    }

    @Override
    public StudentEntity findStudentById(int id) {
        StudentEntity studentEntity = studentDao.findStudentById(id);
        logger.info("findStudentById result={}", studentEntity);
        return studentEntity;
    }
}
