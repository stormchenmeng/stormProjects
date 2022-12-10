package com.wind.springboot.serviceAsync;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AsyncTestServiceImpl implements AsyncTestService {


    /**
     * （1）@Async：这里标识为异步任务，在执行此方法是，会单独开启线程来执行。
     * （2）"getExecutor" ：指定这个信息是为了读取自己写的配置信息例如线程名称那些信息。
     * （3）请注意1：利用@Async注解的方法不能跟调用它的方法放在同一个类里面，否则会出现循环依赖错误。
     * （4）请注意2：利用@Async注解的方法不能定义为static类型，否则异步任务不会生效。
     */

    @Async("getExecutor")
    @Override
    public void function1() throws InterruptedException {
        System.out.println("function1 : " + Thread.currentThread().getName() + "-" + UUID.randomUUID().toString());
        //故意等待10秒钟，这样可以明显看到方法2不用等待方法1执行结束再执行
        Thread.sleep(10000);
        System.out.println("function1");
    }


    @Async("getExecutor")
    @Override
    public void function2() {
        System.out.println("function2 : " + Thread.currentThread().getName() + "-" + UUID.randomUUID().toString());
        try {
            Thread.sleep(100);
            System.out.println("function2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
