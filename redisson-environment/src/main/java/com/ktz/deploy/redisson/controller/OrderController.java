package com.ktz.deploy.redisson.controller;

import com.ktz.deploy.redisson.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: OrderController
 * Description:
 * date: 2020/3/9 10:55
 *
 * @author kaituozhe_sh
 */
@RestController
public class OrderController {


    @Autowired
    private OrderService orderService;

    @GetMapping("/order_lock")
    public String orderLock() {
        return this.orderService.order();
    }
}
