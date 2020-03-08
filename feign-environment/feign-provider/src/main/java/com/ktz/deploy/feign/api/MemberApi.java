package com.ktz.deploy.feign.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: MemberApi
 * Description:
 * date: 2020/3/8 21:49
 *
 * @author kaituozhe_sh
 */
@RestController
@RequestMapping("/service")
public class MemberApi {

    @GetMapping("/member/info")
    public String showMemberInfo(@RequestParam("memberId") String memberId) {
        switch (memberId) {
            case "1":
                System.out.println("获取1号用户信息");
                break;
            case "2":
                System.out.println("获取2号用户信息");
                break;
            default:
                return "error";
        }
        return "success";
    }
}
