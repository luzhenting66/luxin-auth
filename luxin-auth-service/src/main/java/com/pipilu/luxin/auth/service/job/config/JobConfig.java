package com.pipilu.luxin.auth.service.job.config;

import com.pipilu.luxin.auth.service.job.handler.DemoJobHandler;
import com.xxl.job.core.executor.XxlJobExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ComponentScan("com.pipilu.luxin.auth.service.job.handler")
public class JobConfig {
    private Logger logger = LoggerFactory.getLogger(JobConfig.class);

    @Value("${xxl.job.admin.addresses}")
    private String addresses;

    @Value("${xxl.job.executor.appname}")
    private String appname;

    @Value("${xxl.job.executor.ip}")
    private String ip;

    @Value("${xxl.job.executor.port}")
    private int    port;

    @Value("${xxl.job.executor.logpath}")
    private String logpath;

    @Value("${xxl.job.accessToken}")
    private String accessToken;
    @Autowired
    private DemoJobHandler demoJobHandler;


    @Bean(initMethod = "start", destroyMethod = "destroy")
    public XxlJobExecutor xxlJobExecutor() {
        logger.info("------------ XxlJobExecutor -----------");
        XxlJobExecutor xxlJobExecutor = new XxlJobExecutor();
        xxlJobExecutor.setIp(ip);
        xxlJobExecutor.setPort(port);
        xxlJobExecutor.setAppName(appname);
        xxlJobExecutor.setAdminAddresses(addresses);
        xxlJobExecutor.setLogPath(logpath);
        xxlJobExecutor.setAccessToken(accessToken);
        XxlJobExecutor.registJobHandler("demoJobHandler",demoJobHandler);
        return xxlJobExecutor;
    }
}
