package com.lgk.myspringboot.Task;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author liangguangkai
 * @version 1.0
 * @date 2022/9/16
 */
@Component
public class XxJobTask {
    private static Logger logger = LoggerFactory.getLogger(XxJobTask.class);
    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("lgkDemo")
    public void demoJobHandler() throws Exception {
        XxlJobHelper.log(" LGK COME !");
        System.out.println("lgk 来了 ！");

        for (int i = 0; i < 5; i++) {
            XxlJobHelper.log("beat at:" + i);
            TimeUnit.SECONDS.sleep(2);
        }
        // default success
    }

}
