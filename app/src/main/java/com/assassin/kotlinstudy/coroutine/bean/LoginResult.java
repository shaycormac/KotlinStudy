package com.assassin.kotlinstudy.coroutine.bean;

/**
 * Created by Alex on 2017/5/15.
 */

public class LoginResult {

    private String UserId;
    private String UserName;
    private String JobCode;
    private String token;//
    private String status;//-1 出错
    private String message;//出错信息

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getJobCode() {
        return JobCode;
    }

    public void setJobCode(String jobCode) {
        JobCode = jobCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }


}
