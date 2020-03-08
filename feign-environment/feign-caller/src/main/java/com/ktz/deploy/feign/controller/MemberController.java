package com.ktz.deploy.feign.controller;

import com.ktz.deploy.feign.service.feign.MessageFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: MemberController
 * Description:
 * date: 2020/3/8 21:57
 *
 * @author kaituozhe_sh
 */
@RestController
public class MemberController {

    @Autowired
    private MessageFeignService messageFeignService;

    @GetMapping("/show/info")
    public String showMember(@RequestParam String memberId) {
        return messageFeignService.showMemberInfo(memberId);
    }
}
