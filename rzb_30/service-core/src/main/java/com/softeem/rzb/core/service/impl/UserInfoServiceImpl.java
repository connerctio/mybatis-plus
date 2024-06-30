package com.softeem.rzb.core.service.impl;

import com.softeem.rzb.core.pojo.entity.UserInfo;
import com.softeem.rzb.core.mapper.UserInfoMapper;
import com.softeem.rzb.core.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户基本信息 服务实现类
 * </p>
 *
 * @author sjj
 * @since 2024-06-30
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
