package com.lions.shen60.header.model.page;

import java.util.List;

/**
 * @author      : shenbo33@qq.com
 * @date        : Created in 2019/4/2  17:40
 * @description : 分页模型
 * @modified By :
 * @version     : version 1.0
 */
public class PageModel<DataType> {

    public int page; //当前页码
    public int pageSize; //页面大小
    public long count; //数据总数
    public boolean hasNext; //是否还有下一页
    public List<DataType> dataList; //数据列表


    public PageModel() {
    }

    public PageModel(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public PageModel(int page, int pageSize, long count) {
        this.page = page;
        this.pageSize = pageSize;
        this.count = count;
    }

    public PageModel(int page, int pageSize, List<DataType> dataList) {
        this.page = page;
        this.pageSize = pageSize;
        this.dataList = dataList;
    }

}
