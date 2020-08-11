package com.ktz.deploy.response;

public class ResponseData {

    private int code;

    private String message;

    private Object data;

    public static ResponseData ok() {
        return new ResponseData(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg());
    }

    public static ResponseData ok(String message) {
        return new ResponseData(ResponseCode.SUCCESS.getCode(), message);
    }

    public static ResponseData ok(Object data) {
        return new ResponseData(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), data);
    }

    public static ResponseData fail(ResponseCode responseCode) {
        return new ResponseData(responseCode.getCode(), responseCode.getMsg());
    }

    public static ResponseData fail(ResponseCode responseCode, String message) {
        return new ResponseData(responseCode.getCode(), message);
    }

    public static ResponseData fail(ResponseCode responseCode, Object data) {
        return new ResponseData(responseCode.getCode(), responseCode.getMsg(), data);
    }

    public ResponseData(int code, String message) {
        this.message = message;
        this.code = code;
        this.data = null;
    }

    public ResponseData(int code, String message, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public ResponseData() {
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

}
