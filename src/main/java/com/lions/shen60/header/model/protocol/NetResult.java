package com.lions.shen60.header.model.protocol;

/**
 * @author      : shenbo33@qq.com
 * @date        : Created in 2019/4/2  17:41
 * @description : 返回体
 * @modified By :
 * @version     : version 1.0
 */
public class NetResult<DataType> {
    
    private int code;//错误码 0:请求成功
    private String msg;//消息
    private DataType data;//数据体

    public NetResult() {
    }

    public NetResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public NetResult(int code, String msg, DataType data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataType getData() {
        return data;
    }

    public void setData(DataType data) {
        this.data = data;
    }
}
