package com.softeem.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softeem.mybatisplus.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> listAllByName(String name);
}