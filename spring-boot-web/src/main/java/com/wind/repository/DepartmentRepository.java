package com.wind.repository;

import com.wind.entity.RunDepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author cmm
 */
@Repository
public interface DepartmentRepository
        extends JpaRepository<RunDepartmentEntity, Integer>, JpaSpecificationExecutor<RunDepartmentEntity> {
    
}
