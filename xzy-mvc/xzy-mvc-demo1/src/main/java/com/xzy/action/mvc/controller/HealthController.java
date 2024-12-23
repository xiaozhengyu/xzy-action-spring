package com.xzy.action.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xzy.xiao
 * @since 2024/12/23  13:50
 */
@RestController
public class HealthController {

    @RequestMapping("/check")
    public String check() {
        return "xzy-mvc-demo1";
    }
}
