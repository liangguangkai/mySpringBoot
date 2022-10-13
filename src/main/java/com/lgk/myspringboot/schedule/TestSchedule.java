package com.lgk.myspringboot.schedule;


import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liangguangkai
 * @version 1.0
 * @date 2022/10/13
 */
@Component
public class TestSchedule implements SchedulingConfigurer {

    @Scheduled(cron = "0/5 * * * * *")
    @SchedulerLock(name = "lgk", lockAtMostFor = "3m", lockAtLeastFor = "30s")
    public void outInfo1(){
        System.out.println("111");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "0/5 * * * * *")
    @SchedulerLock(name = "lgk", lockAtMostFor = "3m", lockAtLeastFor = "30s")
    public void outInfo2(){
        System.out.println("222");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

        final ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setBeanName("Schedule-ThreadPool");
        threadPoolTaskExecutor.setThreadNamePrefix("Schedule-ThreadPool-");
        threadPoolTaskExecutor.setCorePoolSize(3);
        threadPoolTaskExecutor.setMaxPoolSize(3);
        threadPoolTaskExecutor.setKeepAliveSeconds(30);
        threadPoolTaskExecutor.setQueueCapacity(0);
        final ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(3, threadPoolTaskExecutor);
        threadPoolExecutor.setMaximumPoolSize(3);
        threadPoolExecutor.setKeepAliveTime(30, TimeUnit.MINUTES);
        scheduledTaskRegistrar.setScheduler(threadPoolExecutor);

    }
}
