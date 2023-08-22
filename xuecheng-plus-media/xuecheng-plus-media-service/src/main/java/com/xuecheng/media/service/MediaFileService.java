package com.xuecheng.media.service;

import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.media.model.dto.QueryMediaParamsDto;
import com.xuecheng.media.model.dto.UploadFileParamsDto;
import com.xuecheng.media.model.dto.UploadFileResultDto;
import com.xuecheng.media.model.po.MediaFiles;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Mr.M
 * @version 1.0
 * @description 媒资文件管理业务类
 * @date 2022/9/10 8:55
 */
public interface MediaFileService {

    /**
     * @param pageParams          分页参数
     * @param queryMediaParamsDto 查询条件
     * @return com.xuecheng.base.model.PageResult<com.xuecheng.media.model.po.MediaFiles>
     * @description 媒资文件查询方法
     * @author Mr.M
     * @date 2022/9/10 8:57
     */
    public PageResult<MediaFiles> queryMediaFiels(Long companyId, PageParams pageParams, QueryMediaParamsDto queryMediaParamsDto);

    public UploadFileResultDto uploadFile(long companyId,
                                          UploadFileParamsDto uploadFileParamsDto,
                                          byte[] bytes,
                                          String folder,
                                          String objectName);

    @Transactional
    public MediaFiles addMediaFilesToDb(long companyId, UploadFileParamsDto uploadFileParamsDto, String objectName, String fileId, String bucket);

    /**
     * @description 根据id查询文件信息
     * @param id  文件id
     * @return com.xuecheng.media.model.po.MediaFiles 文件信息
     * @author Mr.M
     * @date 2022/9/13 17:47
     */
    public MediaFiles getFileById(String id);

}
