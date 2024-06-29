package com.softeem.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.softeem.mybatisplus.entity.User;
import com.softeem.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class WrapperTests {
    
    @Resource
    private UserMapper userMapper;
    @Test
    public void test1() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();// 创建查询条件，这个是条件构造器
        queryWrapper
                .like("name","n")
                .between("age", 10, 20)
                .isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }
    @Test
    public void test4() {

        //修改条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .like("name", "n")
                .and(i -> i.lt("age", 18).or().isNull("email")); //lambda表达式内的逻辑优先运算

        User user = new User();
        user.setAge(18);
        user.setEmail("user@softeem.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println(result);
    }

    @Test
    public void test7() {

        //组装set子句
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .set("age", 18)
                .set("email", "user@softeem.com")
                .like("name", "n")
                .and(i -> i.lt("age", 18).or().isNull("email")); //lambda表达式内的逻辑优先运算

        //这里必须要创建User对象，否则无法应用自动填充。如果没有自动填充，可以设置为null
        User user = new User();
        int result = userMapper.update(user, updateWrapper);
        System.out.println(result);
    }
    @Test
    public void test8() {

        //定义查询条件，有可能为null（用户未输入）
        String name = "n";
        Integer ageBegin = 10;
        Integer ageEnd = 20;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(name)){
            queryWrapper.like("name",name);
        }
        if(ageBegin != null){
            queryWrapper.ge("age", ageBegin);
        }
        if(ageEnd != null){
            queryWrapper.le("age", ageEnd);
        }

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }
    @Test
    public void test9() {

        //定义查询条件，有可能为null（用户未输入）
        String name = null;
        Integer ageBegin = 10;
        Integer ageEnd = 20;

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                //避免使用字符串表示字段，防止运行时错误
                .like(StringUtils.isNotBlank(name), User::getName, "n")
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }


}