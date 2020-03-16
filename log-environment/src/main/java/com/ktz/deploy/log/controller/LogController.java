package com.ktz.deploy.log.controller;

import com.ktz.deploy.log.annotation.LogAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameLogController
 * @Description
 * @Author pc801
 * @Date2020/3/16 10:04
 * @Version V1.0
 **/
@Slf4j
@RestController
public class LogController {

    @LogAnnotation(moduleCode = "1001")
    @GetMapping("/test")
    public Object test(String param) {
        return "success";
    }
}
