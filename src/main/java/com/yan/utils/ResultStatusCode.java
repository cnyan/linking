package com.yan.utils;

public enum ResultStatusCode {
    NIM_TOKENKEY_GET_SUCCESS("200", "regist success"),
    ERROR_ACCOUNT("4004", "User name or password is incorrect")//用户名或密码不正确
    ;

    private String errcode;
    private String errmsg;

    ResultStatusCode() {
    }

    ResultStatusCode(String errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
