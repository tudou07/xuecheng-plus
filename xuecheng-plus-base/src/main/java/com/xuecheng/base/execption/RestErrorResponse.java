package com.xuecheng.base.execption;

import java.io.Serializable;

/**
 * @author Administrator
 * @version 1.0
 * @description 错误响应参数包装
 * @date 2023/2/24 17:47
 */
public class RestErrorResponse implements Serializable {
    private String errMessage;
    public RestErrorResponse(String errMessage){
        this.errMessage= errMessage;
    }
    public String getErrMessage() {
        return errMessage;
    }
    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
