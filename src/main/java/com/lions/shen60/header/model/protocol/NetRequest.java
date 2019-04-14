package com.lions.shen60.header.model.protocol;

/**
 * @author      : shenbo33@qq.com
 * @date        : Created in 2019/4/2  17:41
 * @description : 请求体
 * @modified By :
 * @version     : version 1.0
 */
public class NetRequest<ParaType> {

    private NetProtocol protocol;//固定协议参数
    private ParaType params;//自定义参数

    public NetRequest() {
    }

    public NetProtocol getProtocol() {
        return protocol;
    }

    public void setProtocol(NetProtocol protocol) {
        this.protocol = protocol;
    }

    public ParaType getParams() {
        return params;
    }

    public void setParams(ParaType params) {
        this.params = params;
    }
}
