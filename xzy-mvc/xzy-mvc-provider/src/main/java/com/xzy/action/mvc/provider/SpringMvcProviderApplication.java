package com.xzy.action.mvc.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xzy.xiao
 * @since 2024/12/17  18:26
 */

@RestController
@SpringBootApplication(scanBasePackages = {
        "com.xzy.action.mvc.provider",
        "com.xzy.action.common"
})
public class SpringMvcProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcProviderApplication.class, args);
    }

    @RequestMapping("/")
    public String up() {
        return "xzy-mvc-provider";
    }
}
