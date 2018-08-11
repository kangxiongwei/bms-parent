package org.kxw.bms.web.model;

import org.kxw.bms.web.constant.ResponseConstants;

/**
 * Create by kangxiongwei on 2018/8/11 下午12:56
 */
public class HttpBaseResult {

    public static final Integer OK = 200;
    public static final Integer SERVER_ERROR = 500;
    public static final Integer CLIENT_ERROR = 400;


    private Integer code;
    private String message;
    private Object data;

    public HttpBaseResult() {
    }

    public HttpBaseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public HttpBaseResult(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public HttpBaseResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static HttpBaseResult buildSuccess(Object data) {
        return new HttpBaseResult(OK, ResponseConstants.OK_MSG, data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    @Override
    public String toString() {
        return "HttpBaseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
