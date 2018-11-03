package com.idea.bms.service.user;

import com.idea.bms.dto.user.SysytemUserLoginDto;
import com.idea.common.vo.BaseResult;

import javax.servlet.http.HttpServletRequest;

public interface SystemUserService {
    /**
     * 系统用户登录
     * @param loginDto
     * @return
     */
    BaseResult login(SysytemUserLoginDto loginDto,HttpServletRequest request);
}
