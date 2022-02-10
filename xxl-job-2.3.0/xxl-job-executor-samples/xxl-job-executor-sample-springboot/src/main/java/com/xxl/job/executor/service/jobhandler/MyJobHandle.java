package com.xxl.job.executor.service.jobhandler;

import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author cmm
 * 编写自己的定时任务,需要继承类IJobHandle
 */
@Component
public class MyJobHandle extends IJobHandler {

    /**
     * 重写execute 方法，里面执行相应的功能
     *
     * @throws Exception
     */
    @Override
    @XxlJob(value = "MyJobHandle")
    public void execute() throws Exception {
        System.out.println("编写自己的定时任务,需要继承类IJobHandle,time=" + new Date());
    }

}
