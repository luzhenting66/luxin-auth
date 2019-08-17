package com.pipilu.luxin.auth.service.job.handler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@JobHandler(value = "demoJobHandler")
public class DemoJobHandler extends IJobHandler {
    @Override
    public ReturnT<String> execute(String s) throws Exception {

        System.err.println("执行任务...."+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return null;
    }
}
