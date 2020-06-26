package com.ktz.deploy.websocket.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName : WebsocketServer
 * @Description :
 * @Author : kaituozhesh
 * @Date: 2020-06-26 12:22
 * @Version: 1.0.0
 */
@Slf4j
@Component
@ServerEndpoint("/websocket/{userId}")
public class WebsocketServer {

    /**
     * 当前在线连接数
     */
    private static AtomicInteger onlineCount = new AtomicInteger(0);

    /**
     * 用于存放每个客户端对应的websocket对象
     */
    private static ConcurrentHashMap<String, WebsocketServer> websocketMap = new ConcurrentHashMap<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 接收者用户Id
     */
    private String userId;

    /**
     * 连接建立成功调用
     *
     * @param session
     * @param userId
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        this.session = session;
        this.userId = userId;
        websocketMap.put(userId, this);
        if (!websocketMap.containsKey(userId)) {
            // 在线人数增加
            onlineCount.incrementAndGet();
        }
        log.info("用户:" + userId + " 连接, 当前在线人数：" + onlineCount.get());

        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            log.error("用户：" + userId + "网络异常");
        }
    }

    /**
     * 连接关闭调用
     */
    @OnClose
    public void onClose() {
        if (websocketMap.containsKey(userId)) {
            websocketMap.remove(userId);
            // 在线人数减少
            onlineCount.decrementAndGet();
        }
        log.info("用户：" + userId + " 退出，当前在线人数为：" + onlineCount.get());
    }

    /**
     * 接收客户端发送消息
     *
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("用户：" + userId + " 消息，报文：" + message);
        if (!StringUtils.isEmpty(message)) {
            try {
                JSONObject jsonObject = JSON.parseObject(message);
                String toUserId = jsonObject.getString("toUserId");
                if (websocketMap.containsKey(toUserId)) {
                    websocketMap.get(toUserId).sendMessage(message);
                } else {
                    log.error("请求的userId" + toUserId + "不在改服务器上");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 错误的情况
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("用户错误:" + this.userId + ",原因:" + error.getMessage());
        error.printStackTrace();
    }

    /**
     * 自定义消息发送
     *
     * @param message
     * @param userId
     */
    public static void sendInfo(String message, @PathParam("userId") String userId) throws IOException {
        log.info("发送消息到:" + userId + "，报文:" + message);
        if (!StringUtils.isEmpty(userId) && websocketMap.containsKey(userId)) {
            websocketMap.get(userId).sendMessage(message);
        } else {
            log.error("用户" + userId + ",不在线！");
        }
    }

    /**
     * 服务器主动推送
     *
     * @param message
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }
}

