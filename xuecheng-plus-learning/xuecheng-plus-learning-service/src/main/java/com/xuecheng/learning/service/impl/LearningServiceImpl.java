package com.xuecheng.learning.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.xuecheng.base.execption.XueChengPlusException;
import com.xuecheng.base.model.RestResponse;
import com.xuecheng.content.model.po.CoursePublish;
import com.xuecheng.learning.feignclient.ContentServiceClient;
import com.xuecheng.learning.feignclient.MediaServiceClient;
import com.xuecheng.learning.model.dto.XcCourseTablesDto;
import com.xuecheng.learning.service.LearningService;
import com.xuecheng.learning.service.MyCourseTablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @version 1.0
 * @description TODO
 * @date 2023/7/17 0:29
 */
@Service
public class LearningServiceImpl implements LearningService {
    @Autowired
    ContentServiceClient contentServiceClient;

    @Autowired
    MediaServiceClient mediaServiceClient;

    @Autowired
    MyCourseTablesService myCourseTablesService;

    @Override
    public RestResponse<String> getVideo(String userId, Long courseId, Long teachplanId, String mediaId) {
        //查询课程信息
        CoursePublish coursepublish = contentServiceClient.getCoursepublish(courseId);
        if(coursepublish==null){
            XueChengPlusException.cast("课程信息不存在");
        }
        //校验学习资格

        //如果登录
        if(StringUtils.isNotEmpty(userId)){

            //判断是否选课，根据选课情况判断学习资格
            XcCourseTablesDto xcCourseTablesDto = myCourseTablesService.getLearningStatus(userId, courseId);
            //学习资格状态 [{"code":"702001","desc":"正常学习"},{"code":"702002","desc":"没有选课或选课后没有支付"},{"code":"702003","desc":"已过期需要申请续期或重新支付"}]
            String learnStatus = xcCourseTablesDto.getLearnStatus();
            if(learnStatus.equals("702001")){
                return mediaServiceClient.getPlayUrlByMediaId(mediaId);
            }else if(learnStatus.equals("702003")){
                RestResponse.validfail("您的选课已过期需要申请续期或重新支付");
            }
        }

        //未登录或未选课判断是否收费
        String charge = coursepublish.getCharge();
        if(charge.equals("201000")){//免费可以正常学习
            return mediaServiceClient.getPlayUrlByMediaId(mediaId);
        }

        return RestResponse.validfail("请购买课程后继续学习");
    }
}
