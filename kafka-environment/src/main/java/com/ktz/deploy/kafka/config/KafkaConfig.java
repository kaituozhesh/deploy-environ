package com.ktz.deploy.kafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

/**
 * ClassName: KafkaConfig
 * Description:
 * date: 2020/3/8 17:47
 *
 * @author kaituozhe_sh
 */
@Configuration
public class KafkaConfig {

    /**
     * ConcurrentKafkaListenerContainerFactory为创建Kafka监听器的工厂类
     *
     * @param consumerFactory
     * @return
     */
    @Bean
    public KafkaListenerContainerFactory<?> batchFactory(ConsumerFactory consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setConcurrency(10);
        factory.getContainerProperties().setPollTimeout(1500);
        factory.setBatchListener(true);
        return factory;
    }


    /**
     * 消息过滤
     *
     * @return
     */
    @Bean
    public KafkaListenerContainerFactory<?> filterContainerFactory(
            ConsumerFactory consumerFactory) {
        ConcurrentKafkaListenerContainerFactory factory =
                new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory);
        //配合RecordFilterStrategy使用，被过滤的信息将被丢弃
        factory.setAckDiscarded(true);
        factory.setRecordFilterStrategy(consumerRecord -> {
            String msg = (String) consumerRecord.value();
            if (msg.contains("abc")) {
                return false;
            }
            System.out.println("filterContainerFactory filter : " + msg);
            //返回true将会被丢弃
            return true;
        });
        return factory;
    }
}
