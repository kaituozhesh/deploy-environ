package com.ktz.deploy.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @ClassName : WebsocketConfig
 * @Description :
 * @Author : kaituozhesh
 * @Date: 2020-06-26 12:17
 * @Version: 1.0.0
 */
@Configuration
public class WebsocketConfig {
    /**
     * 用于扫描带有@ServerEndpoint的注解成为websocket
     *
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
