package com.lions.shen60.header.model.protocol;

/**
 * @author      : shenbo33@qq.com
 * @date        : Created in 2019/4/2  17:40
 * @description : 固定参数
 * @modified By :
 * @version     : version 1.0
 */
public class NetProtocol {

    private String version;
    private String os;
    private String channel;
    private String token;
    private double lng;
    private double lat;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
