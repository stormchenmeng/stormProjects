package com.wind.dao;


import com.wind.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 这是与MyBatis中的mapper.xml文件相互绑定的接口。注意：该接口是用来操作DB的。
 */
public interface EmployeeDao {
    
    EmployeeEntity queryEmployeeById(@Param("id") int id);

}
