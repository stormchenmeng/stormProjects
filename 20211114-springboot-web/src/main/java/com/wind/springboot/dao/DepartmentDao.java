package com.wind.springboot.dao;

import com.wind.springboot.entity.RunDepartmentEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cmm
 */
@Repository
public interface DepartmentDao {

    List<RunDepartmentEntity> queryDepartmentWithName(@Param("name") String name);

}
