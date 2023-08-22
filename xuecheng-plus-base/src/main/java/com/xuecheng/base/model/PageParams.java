package com.xuecheng.base.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author Administrator
 * @version 1.0
 * @description 分页查询通用参数
 * @date 2023/2/19 15:30
 */
@Data
@ToString
public class PageParams {
    //当前页码默认值
    public static final long DEFAULT_PAGE_CURRENT = 1L;
    //每页记录数默认值
    public static final long DEFAULT_PAGE_SIZE = 10L;
    //当前页码
    private Long pageNo = DEFAULT_PAGE_CURRENT;
    //每页记录数
    private Long pageSize = DEFAULT_PAGE_SIZE;

    public PageParams(){
    }
    public PageParams(long pageNo,long pageSize){
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
}
