package com.xuecheng.learning.service.impl;

import com.xuecheng.learning.model.po.XcCourseTables;
import com.xuecheng.learning.mapper.XcCourseTablesMapper;
import com.xuecheng.learning.service.XcCourseTablesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author itcast
 */
@Slf4j
@Service
public class XcCourseTablesServiceImpl extends ServiceImpl<XcCourseTablesMapper, XcCourseTables> implements XcCourseTablesService {

}
