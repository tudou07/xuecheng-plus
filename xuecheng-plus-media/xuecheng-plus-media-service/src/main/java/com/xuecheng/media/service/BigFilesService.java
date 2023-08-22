package com.xuecheng.media.service;

import com.xuecheng.base.model.RestResponse;
import com.xuecheng.media.model.dto.UploadFileParamsDto;

import java.io.File;
import java.io.InputStream;

public interface BigFilesService {
    /**
     * @description 检查文件是否存在
     * @param fileMd5 文件的md5
     * @return com.xuecheng.base.model.RestResponse<java.lang.Boolean> false不存在，true存在
     */
    public RestResponse<Boolean> checkFile(String fileMd5);

    /**
     * @description 检查分块是否存在
     * @param fileMd5  文件的md5
     * @param chunkIndex  分块序号
     * @return com.xuecheng.base.model.RestResponse<java.lang.Boolean> false不存在，true存在
     */
    public RestResponse<Boolean> checkChunk(String fileMd5, int chunkIndex);

    /**
     * @description 上传分块
     * @param fileMd5  文件md5
     * @param chunk  分块序号
     * @param inputStream  输入流
     * @return com.xuecheng.base.model.RestResponse
     */
    public RestResponse uploadChunk(String fileMd5, int chunk, InputStream inputStream);

    /**
     * @description 合并分块
     * @param companyId  机构id
     * @param fileMd5  文件md5
     * @param chunkTotal 分块总和
     * @param uploadFileParamsDto 文件信息
     * @return com.xuecheng.base.model.RestResponse
     */
    public RestResponse mergechunks(Long companyId, String fileMd5, int chunkTotal, UploadFileParamsDto uploadFileParamsDto);

    //根据桶和文件路径从minio下载文件
    public File downloadFileFromMinIO(File file, String bucket, String objectName);

    //将文件上传到minIO，传入文件绝对路径
    public void addMediaFilesToMinIO(String filePath, String bucket, String objectName);
}
