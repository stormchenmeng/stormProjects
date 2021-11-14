package com.wind.springboot.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author cmm
 */
@Component
public class RunHttpResponse implements Serializable {

    private static final long serialVersionUID = -1611246126396393265L;

    private static final int SUC_CODE = 200;
    private static final int ERR_CODE = 500;

    private Integer code;
    private String msg;
    private Object data;

    /**
     * 请求成功时的响应结果
     */
    public static RunHttpResponse success(String msg, Object data) {
        RunHttpResponse httpResponse = new RunHttpResponse();
        httpResponse.setCode(SUC_CODE);
        httpResponse.setMsg(msg);
        httpResponse.setData(data);
        return httpResponse;
    }

    /**
     * 请求失败时的响应结果
     */
    public static RunHttpResponse failure(String msg, Object data) {
        RunHttpResponse httpResponse = new RunHttpResponse();
        httpResponse.setCode(ERR_CODE);
        httpResponse.setMsg(msg);
        httpResponse.setData(data);
        return httpResponse;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RunHttpResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}
