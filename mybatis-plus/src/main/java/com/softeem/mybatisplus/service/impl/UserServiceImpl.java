package com.softeem.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softeem.mybatisplus.entity.User;
import com.softeem.mybatisplus.mapper.UserMapper;
import com.softeem.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper; //UserMapper可以不用声明，因为已经继承了ServiceImpl

    @Override
    public List<User> listAllByName(String name) {
        // baseMapper对象指向当前业务的mapper对象
        return baseMapper.selectAllByName(name);
    }

}
