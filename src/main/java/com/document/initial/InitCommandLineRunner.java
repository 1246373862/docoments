package com.document.initial;

import com.document.service.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName InitCommandLineRunner
 * @Description TODO
 * @Author yinghangfeng
 * @Date 2023/2/20 22:27
 * @Version 1.0
 **/
@Component
public class InitCommandLineRunner implements CommandLineRunner {


    @Resource
    IUserService userService;

    /**
     * @Author yinghangfeng
     * @Description 系统启动时，执行初始化操作
     * @Date 22:39 2023/2/20
     * @Param [args]
     * @return void
     **/
    @Override
    public void run(String... args) throws Exception {
        userService.initFirstUser();
    }
}
