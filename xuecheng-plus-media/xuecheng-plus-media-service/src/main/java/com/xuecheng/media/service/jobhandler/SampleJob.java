package com.xuecheng.media.service.jobhandler;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @version 1.0
 * @description 测试执行器
 * @date 2023/4/5 23:16
 */
@Component
@Slf4j
public class SampleJob {
    @XxlJob("testJob")
    public void testJob()throws Exception{
        log.info("开始执行......");
    }

    @XxlJob("shardingJobHandler")
    public void shardingJobHandler(){
        int shardIndex = XxlJobHelper.getShardIndex();
        int shardTotal = XxlJobHelper.getShardTotal();
        log.info("分片参数：当前分片序号 = {}，总分片数 = {}", shardIndex, shardTotal);
        log.info("开始执行第"+shardIndex+"批任务");
    }
}
