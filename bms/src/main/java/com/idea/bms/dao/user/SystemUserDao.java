package com.idea.bms.dao.user;

import com.idea.bms.model.user.SystemUserModel;

public interface SystemUserDao {
    /**
     * 查询用户
     * @param queryModel
     * @return
     */
    SystemUserModel selectByModel(SystemUserModel queryModel);

    /**
     * 更新用户
     * @param userModel
     */
    void updateByModel(SystemUserModel userModel);
}
