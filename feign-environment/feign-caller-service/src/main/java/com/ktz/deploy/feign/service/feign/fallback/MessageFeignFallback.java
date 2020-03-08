package com.ktz.deploy.feign.service.feign.fallback;

import com.ktz.deploy.feign.service.feign.MessageFeignService;
import org.springframework.stereotype.Component;

/**
 * ClassName: MessageFeignFallback
 * Description:
 * date: 2020/3/8 21:52
 *
 * @author kaituozhe_sh
 */
@Component
public class MessageFeignFallback implements MessageFeignService {
    @Override
    public String showMemberInfo(String memberId) {
        return null;
    }
}
