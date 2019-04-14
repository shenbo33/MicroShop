package com.lions.shen60.header.model.page;

/**
 * @author      : shenbo33@qq.com
 * @date        : Created in 2019/4/2  17:52
 * @description : body参数解析类
 * @modified By :
 * @version     : version 1.0
 */
public class PageRequest {
    
    private int page;
    private int pageSize;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
