package com.lcwork.multimall.wx.service;

import com.lcwork.multimall.db.domain.generate.MultimallUser;
import com.lcwork.multimall.db.service.MultimallUserService;
import com.lcwork.multimall.wx.dto.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserInfoService {
    @Autowired
    private MultimallUserService userService;


    public UserInfo getInfo(Integer userId) {
        MultimallUser user = userService.findById(userId);
        Assert.state(user != null, "用户不存在");
        UserInfo userInfo = new UserInfo();
        userInfo.setNickName(user.getNickname());
        userInfo.setAvatarUrl(user.getAvatar());
        return userInfo;
    }
}
