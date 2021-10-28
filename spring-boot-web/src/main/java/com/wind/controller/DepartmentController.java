package com.wind.controller;

import com.wind.entity.RunDepartmentEntity;
import com.wind.entity.RunHttpResponse;
import com.wind.service.DepartmentService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author cmm
 */
@Controller
@ResponseBody
@RequestMapping(value = "/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;


    @RequestMapping(value = "/saveDepartment", method = RequestMethod.POST)
    public RunHttpResponse saveDepartment(@RequestParam(value = "name") String name) {
        RunDepartmentEntity departmentEntity = new RunDepartmentEntity();
        departmentEntity.setName(StringUtils.isNotBlank(name) ? name : "defaultName" + new Date().toString());
        departmentEntity.setStatus(1);
        departmentEntity.setAddTime(new Date());
        departmentEntity.setUpdateTime(new Date());
        RunDepartmentEntity entity = departmentService.saveDepartment(departmentEntity);
        if (entity != null) {
            LOGGER.info("==saveDepartment success==result={}", entity);
            return RunHttpResponse.success("success", entity);
        } else {
            return RunHttpResponse.failure("error", null);
        }
    }


    @RequestMapping(value = "/deleteDepartment", method = RequestMethod.DELETE)
    public RunHttpResponse deleteDepartment(@RequestParam(value = "id") Integer id) {
        Integer result = departmentService.deleteDepartment(id);
        if (result != null) {
            LOGGER.info("==deleteDepartment success==result={}", result);
            return RunHttpResponse.success("success", result);
        } else {
            return RunHttpResponse.failure("error", null);
        }
    }


    @RequestMapping(value = "/updateDepartment", method = RequestMethod.PUT)
    public RunHttpResponse updateDepartment(@RequestParam(value = "id") Integer id) {
        RunDepartmentEntity entityOld = departmentService.findDepartmentWithId(id);
        if (entityOld == null) {
            return RunHttpResponse.failure("error", null);
        }
        entityOld.setName(entityOld.getName() + "-" + id);
        RunDepartmentEntity result = departmentService.updateDepartment(entityOld);
        if (result != null) {
            LOGGER.info("==updateDepartment success==result={}", result);
            return RunHttpResponse.success("success", result);
        } else {
            return RunHttpResponse.failure("error", null);
        }
    }


    @RequestMapping(value = "/findAllDepartments", method = RequestMethod.GET)
    public RunHttpResponse findAllDepartments() {
        List<RunDepartmentEntity> allDepartments = departmentService.findAllDepartments();
        LOGGER.info("==findAllDepartments success==size={}", allDepartments.size());
        return RunHttpResponse.success("success", allDepartments);
    }


    @RequestMapping(value = "/queryDepartmentWithName", method = RequestMethod.GET)
    public RunHttpResponse queryDepartmentWithName(@RequestParam(value = "name") String name) {
        List<RunDepartmentEntity> entities = departmentService.queryDepartmentWithName(name);
        LOGGER.info("==queryDepartmentWithName success==size={}", entities.size());
        return RunHttpResponse.success("success", entities);
    }


}
