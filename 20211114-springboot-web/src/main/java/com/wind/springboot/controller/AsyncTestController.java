package com.wind.springboot.controller;

import com.wind.springboot.entity.RunDepartmentEntity;
import com.wind.springboot.entity.RunHttpResponse;
import com.wind.springboot.serviceAsync.AsyncTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value = "/async")
public class AsyncTestController {


    @Autowired
    private AsyncTestService asyncTestService;


    @GetMapping("/asyncTest")
    public void asyncTest() throws InterruptedException {

        asyncTestService.function1(); //异步执行任务
        asyncTestService.function2();
        asyncTestService.function2();

    }

    @RequestMapping(value = "/asyncTest2", method = RequestMethod.GET)
    public RunHttpResponse asyncTest2() throws InterruptedException {
        asyncTestService.function1(); //异步执行任务
        asyncTestService.function2();
        asyncTestService.function2();

        List<String> data = new ArrayList<>();
        data.add("aaa");
        data.add("bbb");
        return RunHttpResponse.success("asyncTest2成功", data);
    }
}
