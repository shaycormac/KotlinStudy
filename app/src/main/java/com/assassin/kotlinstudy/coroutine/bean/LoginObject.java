package com.assassin.kotlinstudy.coroutine.bean;


import com.assassin.kotlinstudy.coroutine.util.Convert;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2019/5/10 0010 16:17
 * Version: 1.0
 * Description: 登录实体，作为登录新接手使用
 */
public class LoginObject {
    /**
     * LogOnModel : {"Account":"guxiaocheng","Password":"1"}
     * sysLoginLog : {"Device_Id":"23333","Device_Name":"HUAWEIP30","Source_App":"2","Memo":"DA"}
     */

    public LogOnModelBean LogOnModel;
    public SysLoginLogBean sysLoginLog;

    public static class LogOnModelBean {
        /**
         * Account : guxiaocheng
         * Password : 1
         */

        public String Account;
        public String Password;
    }

    public static class SysLoginLogBean {
        /**
         * Device_Id : 23333 设备唯一标志
         * Device_Name : HUAWEIP30 设备名/计算机名
         * Source_App : 2 IOS/安卓/PC   1  2  3
         * Memo : DA
         */

        public String Device_Id="14546486464646878848468";
        public String Device_Name=android.os.Build.BRAND;
        public String Device_Type=android.os.Build.MODEL;
        public int Source_App = 2;
        public String Memo;
    }
    /**
     * 获取登录的json实体
     */
    public static String getLoginJsonString(String account,String password)
    {
        LoginObject loginObject = new LoginObject();
        LogOnModelBean logOnModelBean = new LogOnModelBean();
        SysLoginLogBean sysLoginLogBean = new SysLoginLogBean();
        logOnModelBean.Account = account;
        logOnModelBean.Password = password;
        loginObject.LogOnModel = logOnModelBean;
        loginObject.sysLoginLog = sysLoginLogBean;
         return  Convert.toJson(loginObject);
    }
}
