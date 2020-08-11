package com.ktz.deploy.response;

public enum ResponseCode {

    /** 正确 **/
    SUCCESS(200, "SUCCESS"),
    /** 参数错误 **/
    PARAM_ERROR(400, "PARAMS ERROR"),
    /** 限制调用 **/
    LIMIT_ERROR(401, "RESOURCE LIMITED"),
    /** Token过期 **/
    TOKEN_TIMEOUT(402, "TOKEN INVALID"),
    /** 禁止访问 **/
    NO_AUTH(403, "RESOURCE FORBIDDEN"),
    /** 资源没找到 **/
    NOT_FOUND(404, "RESOURCE NOT FOUND"),
    /** 服务器错误 **/
    SERVER_ERROR(500, "SERVER ERROR"),
    /** 服务降级中 **/
    DOWNGRADE(406, "SERVICE DOWNGRADE"),
    /** 自定义错误 **/
    CUSTOM_ERROR(999, "CUSTOM ERROR"),
    /** 刷新Token **/
    TOKEN_REFRESH(888, "TOKEN REFRESH");

    private int code;

    private String msg;

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    private ResponseCode(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
