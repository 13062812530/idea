package com.idea.bms.model.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SystemUserModel implements Serializable {
    private static final long serialVersionUID = 2546886812628808939L;

    private Integer id;//id主键
    private String userName;//登录用户名
    private String password;//登录密码
    private Date lastLoginTime;//最后登录时间
    private Date registerTime;//注册时间
    private String lastLoginIp;//最后登录ip
    private Integer failLoginNum;//登录错误次数
    private Integer status;//状态 0=正常 1=禁用
    private String name;//姓名
    private String mobile;//手机号码
    private String phone;//座机号
    private String email;//邮箱
    private String address;//地址
    private String qq;//QQ
    private String weCat;//微信
}
