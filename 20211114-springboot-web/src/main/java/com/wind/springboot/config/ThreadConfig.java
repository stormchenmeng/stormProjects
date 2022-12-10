package com.wind.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.Serializable;
import java.util.concurrent.Executor;

@Configuration
@ComponentScan("com.wind.springboot.serviceAsync")  //指定即将开启异步线程的业务方法是哪个
@EnableAsync                                        //指定允许使用异步线程
public class ThreadConfig implements Serializable {

    private static final long serialVersionUID = 3124156346802058439L;

    /**
     * 执行异步任务需要依赖线程池，这里就创建一个线程池。
     * 线程池执行步骤：
     * corePoolSize：核心线程数
     * maxPoolSize：最大线程数
     * queueCapacity：缓冲队列大小
     * <p>
     * （1）提交任务时，如果线程池中的工作线程数量小于corePoolSize时，就会新建一个工作线程，并执行新提交的任务。
     * （2）提交任务时，如果线程池中的工作线程数量大于等于corePoolSize，而且线程池内的缓冲队列未满，则将新提交的任务添加到缓冲队列中。
     * （3）提交任务时，如果线程池中的工作线程数量大于等于corePoolSize，而且线程池内的缓冲队列已满，而且工作线程数量又小于maxPoolSize，则新建一个工作线程并执行新提交的任务。
     * （4）提交任务时，如果线程池中的工作线程数量大于等于maxPoolSize，而且线程池内的缓冲队列已满，则会根据拒绝策略来处理该任务，默认的情况是直接抛出异常。
     */

    @Bean
    public Executor getExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //设置核心线程数
        executor.setCorePoolSize(10);
        //设置最大线程数
        executor.setMaxPoolSize(100);
        //设置线程池中所使用的缓冲队列
        executor.setQueueCapacity(300);
        //设置线程名称
        executor.setThreadNamePrefix("JcTest-Async");
        //设置多余线程等待的时间，单位秒
        //executor.setKeepAliveSeconds(1000);
        //初始化线程
        executor.initialize();
        return executor;
    }

}
