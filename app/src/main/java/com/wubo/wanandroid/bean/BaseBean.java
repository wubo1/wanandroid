package com.wubo.wanandroid.bean;

import java.io.Serializable;

/**
 * Author: wubo
 * Create on: 2019/3/26 14:22
 * Description:
 */
public class BaseBean implements Serializable {

    private int errorCode;
    private String errorMsg;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
