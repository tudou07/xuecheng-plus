package com.xuecheng.content;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xuecheng.content.mapper.CourseBaseMapper;
import com.xuecheng.content.mapper.TeachplanMapper;
import com.xuecheng.content.model.dto.TeachplanDto;
import com.xuecheng.content.model.po.CourseBase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0
 * @description TODO
 * @date 2023/2/23 22:43
 */
@SpringBootTest
public class MapperTest {
    @Autowired
    CourseBaseMapper courseBaseMapper;
    @Autowired
    TeachplanMapper teachplanMapper;
    @Test
    void testSelectMaps(){
        QueryWrapper<CourseBase> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("avg(id) as avg");
        List<Map<String, Object>> mapList = courseBaseMapper.selectMaps(queryWrapper);
        System.out.println(mapList);
    }

    @Test
    void testSelectGroupBy(){
        QueryWrapper<CourseBase> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("count(*) as count, status");
        queryWrapper.groupBy("status");
        List<Map<String, Object>> mapList = courseBaseMapper.selectMaps(queryWrapper);
        System.out.println(mapList);
    }

    @Test
    void testLike(){
        LambdaQueryWrapper<CourseBase> lqw = new LambdaQueryWrapper<>();
        lqw.likeRight(CourseBase::getName, "J");
        List<CourseBase> list = courseBaseMapper.selectList(lqw);
        System.out.println(list);
    }

    @Test
    void testTeachplan(){
        List<TeachplanDto> teachplanDtos = teachplanMapper.selectTreeNodes(117);
        System.out.println(teachplanDtos);
    }
}
