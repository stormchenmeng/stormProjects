package com.wind.dao;


import com.wind.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 这是与MyBatis中的mapper.xml文件相互绑定的接口。注意：该接口是用来操作DB的。
 */
public interface EmployeeDao {

    int insertEmployee(@Param("employeeEntity") EmployeeEntity employeeEntity);

    int deleteEmployee(@Param("id") int id);

    int updateEmployee(@Param("employeeEntity") EmployeeEntity employeeEntity);

    EmployeeEntity queryEmployeeById(@Param("id") int id);

}
