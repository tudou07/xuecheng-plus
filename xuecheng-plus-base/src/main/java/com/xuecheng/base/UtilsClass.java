package com.xuecheng.base;

import com.j256.simplemagic.ContentInfo;
import com.j256.simplemagic.ContentInfoUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.MediaType;

/**
 * @author Administrator
 * @version 1.0
 * @description 工具类
 * @date 2023/3/22 22:36
 */
public class UtilsClass {
    //根据扩展名获取contentType
    public static String getMimeTypeByExtension(String extension){
        String contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        if (StringUtils.isNotEmpty(extension)){
            ContentInfo extensionMatch = ContentInfoUtil.findExtensionMatch(extension);
            if (extensionMatch != null){
                contentType = extensionMatch.getMimeType();
            }
        }
        return contentType;
    }
}
