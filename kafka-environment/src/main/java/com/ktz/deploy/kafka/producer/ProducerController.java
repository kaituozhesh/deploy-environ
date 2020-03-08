package com.ktz.deploy.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ProducerController
 * Description:
 * date: 2020/3/8 17:44
 *
 * @author kaituozhe_sh
 */
@RestController
@RequestMapping("/send")
public class ProducerController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @RequestMapping("/message")
    public String send(String msg) {
        kafkaTemplate.send("demo", msg);
        return "success";
    }
}
