package com.wind.controller;

import com.wind.entity.StudentEntity;
import com.wind.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@ResponseBody
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "addStudent.do", method = RequestMethod.POST)
    public ModelAndView addStudent(StudentEntity studentEntity) {
        //创建一个视图
        ModelAndView modelAndView = new ModelAndView();
        String tips = "注册失败，请稍后重试。";
        int insertResult = studentService.insertStudent(studentEntity);
        if (insertResult > 0) {
            tips = "学生【" + studentEntity.getName() + "】注册成功。";
        }
        //添加数据
        modelAndView.addObject("tips", tips);
        //添加视图
        modelAndView.setViewName("addStudentResult");
        return modelAndView;
    }

    /**
     * 处理查询，这是一个ajax请求
     */
    @RequestMapping(value = "queryStudent.do", method = RequestMethod.GET)
    public List<StudentEntity> queryStudent() {
        List<StudentEntity> studentEntities = studentService.findAllStudent();
        return studentEntities;
    }
}
