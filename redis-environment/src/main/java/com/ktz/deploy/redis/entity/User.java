package com.ktz.deploy.redis.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * ClassName: User
 * Description:
 * date: 2020/3/8 11:07
 *
 * @author kaituozhe_sh
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    /**
     * 存储到redis数据中如果包括日期（LocalDateTime），则从redis读取解析数据时可能存在报错，无法实现LocalDateTime日期的反序列化操作，需要添加上两个注解
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime time;
}
