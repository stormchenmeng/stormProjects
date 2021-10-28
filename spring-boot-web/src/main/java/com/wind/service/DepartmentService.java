package com.wind.service;

import com.wind.dao.DepartmentDao;
import com.wind.entity.RunDepartmentEntity;
import com.wind.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author cmm
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentDao departmentDao;


    /**
     * 增
     */
    @Transactional
    public RunDepartmentEntity saveDepartment(RunDepartmentEntity departmentEntity) {
        if (departmentEntity == null) {
            return null;
        }
        RunDepartmentEntity entity = departmentRepository.save(departmentEntity);
        System.out.println(entity);
        return entity;
    }


    /**
     * 删
     */
    @Transactional
    public Integer deleteDepartment(Integer id) {
        if (id == null) {
            return null;
        }
        Optional<RunDepartmentEntity> departmentEntity = departmentRepository.findById(id);
        if (!departmentEntity.isPresent()) {
            return null;
        }
        departmentRepository.delete(departmentEntity.get());
        return departmentEntity.get().getId();
    }


    /**
     * 改
     */
    @Transactional
    public RunDepartmentEntity updateDepartment(RunDepartmentEntity departmentEntity) {
        if (departmentEntity == null || departmentEntity.getId() == null) {
            return null;
        }
        return departmentRepository.save(departmentEntity);
    }


    /**
     * 查
     */
    public List<RunDepartmentEntity> findAllDepartments() {
        List<RunDepartmentEntity> departmentEntities = departmentRepository.findAll();
        System.out.println(departmentEntities.size());
        return departmentEntities;
    }

    public RunDepartmentEntity findDepartmentWithId(Integer id) {
        Optional<RunDepartmentEntity> departmentEntityOptional = departmentRepository.findById(id);
        return departmentEntityOptional.orElse(null);
    }

    public List<RunDepartmentEntity> queryDepartmentWithName(String name) {
        List<RunDepartmentEntity> entities = departmentDao.queryDepartmentWithName(name);
        System.out.println(entities.size());
        return entities;
    }


}
