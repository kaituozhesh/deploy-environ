package com.ktz.deploy.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * ClassName: ConsumerController
 * Description:
 * date: 2020/3/8 17:43
 *
 * @author kaituozhe_sh
 */
@Component
public class ConsumerController {
    /**
     * Description:
     *  @KafkaListener：在注解内指定topic名称，当对应的topic内有新消息时，listen方法会被调用，参数就是topic内新的消息，这个过程是异步进行的
     *  工作流程
     *      1、解析：解析@KafkaListener注解
     *      2、注册：解析后的数据注册到spring-kafka
     *      3、监听：开始监听topic变更
     *      4、调用：调用注解标识的方法，将监听的数据作为参数传入
     *  详解：
     *      1、解析：@KafkaListener注解由KafkaListenerAnnotationBeanPostProcessor类解析，后者实现了BeanPostProcessor接口，这个接口内部有两个方法，分别在初始化前后被调用
     *              KafkaListenerAnnotationBeanPostProcessor内会在postProcessAfterInitialization方法内解析@KafkaListener注解
     *      2、注册：解析步骤里，我们可以获取到所有含有@KafkaListener注解的类，之后这些类的相关信息会被注册到KafkaListenerEndpointRegistry内，包括注解所在的方法，当前bean等
     *              KafkaListenerEndpointRegistry这个类内部会维护多个Listener Container每个@KafkaListener都会对应一个Listener Container。并且每个Container对应一个线程
     *      3、监听：注册完成之后，每个Listener Container会开始工作，会新启一个新的线程，初始化KafkaConsumer，监听topic变更等
     *      4、调用：监听到数据之后，container会组织消息的格式，随后调用解析得到的@KafkaListener注解标识的方法，将组织后的消息作为参数传入方法，执行用户逻辑
     *
     * @KafkaListener参数属性
     *  id：消费者的id，当GroupId没有被配置的时候，默认id为GroupId
     *  containerFactory：上面提到了@KafkaListener区分单数据还是多数据消费只需要配置一下注解的containerFactory属性就可以了，这里面配置的是监听容器工厂，也就是ConcurrentKafkaListenerContainerFactory，配置BeanName
     *  topics：需要监听的Topic，可监听多个
     *  topicPartitions：可配置更多详细的监听信息，必须监听某个Topic中的指定分区，或者从offset为200的偏移量开始监听
     *  errorHandler：监听异常处理器，配置BeanName
     *  groupId：消费组ID
     *  idIsGroup：id是否为GroupId
     *  clientIdPrefix：消费者Id前缀
     *  beanRef：真是监听容器的BeanName，需要在BeanName前加“_”
     *
     *
     *  ConsumerRecord：包含分区信息、消息头、消息体等内容
     * @author kaituozhesh_sh
     */
/*    @KafkaListener(topics = "demo")
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.printf("topic is %s, offset is %d, value is %s \n", record.topic(), record.offset(), record.value());
    }*/

    /**
     * 基于注解的方式获取消息及消息头
     *  监听Topic中指定的分区
     * @param data
     */
    @KafkaListener(id = "id0", containerFactory = "filterContainerFactory",
            topicPartitions = {@TopicPartition(topic = "demo", partitions = {"0"})})
    public void annoListener(@Payload String data,
                             @Header(KafkaHeaders.RECEIVED_PARTITION_ID) String partition,
                             @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                             @Header(KafkaHeaders.RECEIVED_TIMESTAMP) String timestamp) {
        System.out.println(data);
        System.out.println(partition);
        System.out.println(topic);
        System.out.println(timestamp);
    }
}
