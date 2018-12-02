package com.idea.bms.service.user;

import com.idea.bms.dto.index.SystmUserListQueryDto;
import com.idea.bms.dto.user.SystemUserLoginDto;
import com.idea.common.vo.BaseResult;

import javax.servlet.http.HttpServletRequest;

public interface SystemUserService {
    /**
     * 系统用户登录
     * @param loginDto
     * @return
     */
    BaseResult login(SystemUserLoginDto loginDto, HttpServletRequest request);

    /**
     * 系统用户退出登录
     * @param request
     * @return
     */
    BaseResult exit(HttpServletRequest request);

    /**
     * 查询系统用户列表
     * @param queryDto
     * @return
     */
    BaseResult list(SystmUserListQueryDto queryDto);
}
