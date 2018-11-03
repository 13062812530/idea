package com.idea.bms.controller.user;

import com.idea.bms.dto.user.SysytemUserLoginDto;
import com.idea.bms.service.user.SystemUserService;
import com.idea.common.vo.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags = {"系统用户管理"})
@RestController
@RequestMapping(value = "/systemUser")
public class SystemUserController {

    @Autowired
    private SystemUserService systemUserService;

    @ApiOperation(value = "系统用户登录",httpMethod = "POST",notes = "用户账号密码登录")
    @ApiResponse(code=200,message = "success",response = BaseResult.class)
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseResult login(@RequestBody SysytemUserLoginDto loginDto, HttpServletRequest request){
       return systemUserService.login(loginDto,request);
    }
}
