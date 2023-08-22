package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.BindTeachplanMediaDto;
import com.xuecheng.content.model.dto.SaveTeachplanDto;
import com.xuecheng.content.model.dto.TeachplanDto;
import com.xuecheng.content.model.po.TeachplanMedia;

import java.util.List;

/**
 * @description 课程基本信息管理业务接口
 */
public interface TeachplanService {
    /**
     * @description 查询课程计划树型结构
     * @param courseId 课程id
     * @return List<TeachplanDto>
     */
    public List<TeachplanDto> findTeachplanTree(long courseId);

    /**
     * @description 只在课程计划
     * @param saveTeachplanDto  课程计划信息
     * @return void
     * @author Mr.M
     * @date 2022/9/9 13:39
     */
    public void saveTeachplan(SaveTeachplanDto saveTeachplanDto);

    /**
     * @description 教学计划绑定媒资
     * @param bindTeachplanMediaDto
     * @return com.xuecheng.content.model.po.TeachplanMedia
     * @author Mr.M
     * @date 2022/9/14 22:20
     */
    public TeachplanMedia associationMedia(BindTeachplanMediaDto bindTeachplanMediaDto);

    //删除教学计划绑定媒资
    public void deleteAssociationMedia(Long teachPlanId, String mediaId);
}
