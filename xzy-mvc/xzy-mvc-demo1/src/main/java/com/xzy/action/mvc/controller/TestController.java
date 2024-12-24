package com.xzy.action.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author xzy.xiao
 * @since 2024/12/24  9:07
 */
@Slf4j
@RestController
public class TestController {

    @PostMapping("/test")
    public void test(HttpServletRequest httpServletRequest) throws IOException {
        // 第一次读取请求体
        readRequest(httpServletRequest);

        // 第二次读取请求体
        readRequest(httpServletRequest);
    }

    private void readRequest(HttpServletRequest httpServletRequest) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = httpServletRequest.getReader()) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }
        log.info("request info：{}", stringBuilder);
    }
}
