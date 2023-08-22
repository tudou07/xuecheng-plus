package com.xuecheng.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuecheng.content.model.po.CourseMarket;

public interface CourseMarketService extends IService<CourseMarket> {
    /**
     * @description 抽取课程营销校验及保存功能
     * @param courseMarket
     * @return int
     */
    int saveCourseMarket(CourseMarket courseMarket);
}
