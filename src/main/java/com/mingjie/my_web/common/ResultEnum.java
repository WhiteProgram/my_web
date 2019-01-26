package com.mingjie.my_web.common;

public enum ResultEnum {
    SUCCESS("请求成功"),
    ERROR("请求错误");
    private String msg;

    ResultEnum(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
