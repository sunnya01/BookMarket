package com.atguigu.dao.error;

/**
 * @author sunchaowei
 * @create 2026/3/24-14:15
 */
public class Error {

    private char code = 'S';
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(char code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Error{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
