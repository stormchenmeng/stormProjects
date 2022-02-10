package com.wind.springboot.controller;

import com.wind.springboot.entity.RunDepartmentEntity;
import com.wind.springboot.entity.RunHttpResponse;
import com.wind.springboot.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public RunHttpResponse saveDepartment(@RequestBody RunDepartmentEntity departmentEntity) {
        departmentEntity.setAddTime(new Date());
        departmentEntity.setUpdateTime(new Date());
        RunDepartmentEntity entity = departmentService.saveDepartment(departmentEntity);
        if (entity != null) {
            LOGGER.info("==saveDepartment success==result={}", entity);
            return RunHttpResponse.success("新增成功", entity);
        } else {
            return RunHttpResponse.failure("新增失败，请重试", null);
        }
    }


    @RequestMapping(value = "/deleteDepartment", method = RequestMethod.GET)
    public RunHttpResponse deleteDepartment(@RequestParam(value = "id") Integer id) {
        Integer result = departmentService.deleteDepartment(id);
        if (result != null) {
            LOGGER.info("==deleteDepartment success==result={}", result);
            return RunHttpResponse.success("success", result);
        } else {
            return RunHttpResponse.failure("error", null);
        }
    }


    @RequestMapping(value = "/updateDepartment", method = RequestMethod.POST)
    public RunHttpResponse updateDepartment(@RequestBody RunDepartmentEntity departmentEntity) {
        if (departmentEntity == null) {
            return RunHttpResponse.failure("参数错误，请重试", null);
        }
        RunDepartmentEntity entityOld = departmentService.findDepartmentWithId(departmentEntity.getId());
        if (entityOld == null) {
            return RunHttpResponse.failure("数据不存在，请重试", null);
        }
        entityOld.setName(departmentEntity.getName());
        entityOld.setUpdateTime(new Date());
        entityOld.setStatus(departmentEntity.getStatus());
        RunDepartmentEntity result = departmentService.updateDepartment(entityOld);
        if (result != null) {
            LOGGER.info("==updateDepartment success==result={}", result);
            return RunHttpResponse.success("修改成功", result);
        } else {
            return RunHttpResponse.failure("修改失败，请重试", null);
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

    @RequestMapping(value = "/getDepartmentWithName", method = RequestMethod.POST)
    public RunHttpResponse getDepartmentWithName(@RequestParam(value = "name") String name,
                                                 HttpServletRequest httpServletRequest,
                                                 HttpServletResponse httpServletResponse) {
        List<RunDepartmentEntity> entities = departmentService.queryDepartmentWithName(name);
        LOGGER.info("==queryDepartmentWithName success==size={}", entities.size());
        LOGGER.info("==httpServletRequest=={},cookie={}", httpServletRequest.getHeader("Host"), httpServletRequest.getCookies());
        LOGGER.info("==httpServletRequest=={}", httpServletRequest.getRequestURI());
        LOGGER.info("==httpServletResponse=={}", httpServletResponse.getStatus());
        return RunHttpResponse.success("success", entities);
    }


}
