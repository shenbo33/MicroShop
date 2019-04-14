package com.lions.shen60.header.common.untils;


import com.lions.shen60.header.model.protocol.NetResult;

public class ResultUtils {
    /**
     * 构建一个字符串类型的返回结果
     *
     * @param obj
     * @return

    public static String build(Object obj) {
        return JsonUtils.toJson(obj);
    }
     */

    /**
     * 构建一个NetResult<DataType>类型的返回结果
     *
     * @param obj
     * @param <DataType>
     * @return
     */
    public static <DataType> NetResult<DataType> buildResult(DataType obj) {
        NetResult<DataType> result = new NetResult<>(0, "success", obj);
        return result;
    }
}
