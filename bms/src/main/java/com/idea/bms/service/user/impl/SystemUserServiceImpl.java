package com.idea.bms.service.user.impl;

import com.idea.bms.dao.user.SystemUserDao;
import com.idea.bms.dto.user.SysytemUserLoginDto;
import com.idea.bms.model.user.SystemUserModel;
import com.idea.bms.service.user.SystemUserService;
import com.idea.common.util.CommonUtil;
import com.idea.common.util.RedisUtil;
import com.idea.common.util.SecurityUtil;
import com.idea.common.vo.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    private SystemUserDao systemUserDao;

    @Value("${token.validTime}")
    private Long tokenValidTime;

    /**
     * 系统用户登录
     *
     * @param loginDto
     * @return
     */
    @Override
    public BaseResult login(SysytemUserLoginDto loginDto,HttpServletRequest request) {
        BaseResult br = new BaseResult();
        Map<String, Object> resultMap = new HashMap<>();
        try {
            //登录参数校验
            if (CommonUtil.isObjectEmpty(loginDto)) {
                br.setErrorMsg("登录参数错误");
                br.setSuccess(false);
                return br;
            }
            if (StringUtils.isBlank(loginDto.getUserName())) {
                br.setErrorMsg("登录用户名不能为空");
                br.setSuccess(false);
                return br;
            }
            if (StringUtils.isBlank(loginDto.getPassword())) {
                br.setErrorMsg("登录密码不能为空");
                br.setSuccess(false);
                return br;
            }
            //查询用户
            SystemUserModel queryModel = new SystemUserModel();
            queryModel.setUserName(loginDto.getUserName());
            queryModel.setPassword(SecurityUtil.MD5AndSHA256(loginDto.getPassword()));
            SystemUserModel userModel = systemUserDao.selectByModel(queryModel);
            if (userModel == null) {
                br.setErrorMsg("用户名或密码错误");
                br.setSuccess(false);
                return br;
            }
            Integer status = userModel.getStatus();
            if(status >0){
                br.setErrorMsg("账号异常,请联系管理员处理");
                br.setSuccess(false);
                return br;
            }
            //登录成功
            userModel.setLastLoginIp(CommonUtil.getIpAddr(request));
            userModel.setLastLoginTime(new Date());
            systemUserDao.updateByModel(userModel);
            String token = UUID.randomUUID().toString().replace("-","");
            RedisUtil.set(String.format("token/%d",userModel.getId()),token,tokenValidTime);
            resultMap.put("token",token);
            br.setMap(resultMap);
            br.setSuccess(true);
            br.setMsg("登录成功");
        } catch (Exception e) {
            log.error(String.format("用户:%s登录异常",loginDto.getUserName()),e);
            br.setErrorMsg("系统错误");
            br.setSuccess(false);
        }
        return br;
    }
}
