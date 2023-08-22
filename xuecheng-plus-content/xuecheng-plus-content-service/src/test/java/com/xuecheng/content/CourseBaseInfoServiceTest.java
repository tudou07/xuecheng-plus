package com.xuecheng.content;

import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;
import com.xuecheng.content.service.impl.CourseBaseInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Administrator
 * @version 1.0
 * @description TODO
 * @date 2023/2/20 23:39
 */
@SpringBootTest
public class CourseBaseInfoServiceTest {
    @Autowired
    CourseBaseInfoServiceImpl courseBaseInfoService;

    @Test
    void testCourseBaseInfoService(){
        PageParams pageParams = new PageParams(1, 2);
        QueryCourseParamsDto queryCourseParamsDto = new QueryCourseParamsDto();
        PageResult<CourseBase> courseBasePageResult = courseBaseInfoService.queryCourseBaseList(1232141425L,pageParams, queryCourseParamsDto);
        System.out.println(courseBasePageResult);
    }
}
