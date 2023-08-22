package com.xuecheng.content.model.dto;

import com.xuecheng.content.model.po.Teachplan;
import com.xuecheng.content.model.po.TeachplanMedia;
import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 * @description 课程计划树型结构dto
 * @date 2023/2/28 0:38
 */
@Data
public class TeachplanDto extends Teachplan {
    //课程计划关联的媒资信息
    TeachplanMedia teachplanMedia;
    //子结点
    List<TeachplanDto> teachPlanTreeNodes;
}
