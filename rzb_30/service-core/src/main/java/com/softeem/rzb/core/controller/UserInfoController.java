package com.softeem.rzb.core.controller;


import com.softeem.rzb.core.pojo.entity.UserInfo;
import com.softeem.rzb.core.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户基本信息 前端控制器
 * </p>
 *
 * @author sjj
 * @since 2024-06-30
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/showList")
    public List<UserInfo> showList() {
        return userInfoService.list();
    }
}

