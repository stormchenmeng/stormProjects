package com.wind.dao;

import com.wind.entity.RunDepartmentEntity;
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
