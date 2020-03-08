package com.ktz.deploy.feign.service.feign;

import com.ktz.deploy.feign.service.feign.fallback.MessageFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName: MessageFeignService
 * Description:
 * date: 2020/3/8 21:52
 *
 * @author kaituozhe_sh
 */
@FeignClient(value = "localhost:8888/feign/provider", fallback = MessageFeignFallback.class)
public interface MessageFeignService {

    @GetMapping("/service/member/info")
    String showMemberInfo(@RequestParam("memberId") String memberId);

}
