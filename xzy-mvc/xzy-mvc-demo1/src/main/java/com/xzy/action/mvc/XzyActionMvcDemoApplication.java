package com.xzy.action.mvc;

import com.xzy.action.common.exception.config.EnableControllerExceptionAdvice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xzy.xiao
 * @since 2024/12/23  13:48
 */
@SpringBootApplication(scanBasePackages = {"com.xzy.action.mvc"})
@EnableControllerExceptionAdvice
public class XzyActionMvcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(XzyActionMvcDemoApplication.class, args);
    }

}
