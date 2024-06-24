package com.softeem.mybatisplus;

import com.softeem.mybatisplus.entity.User;
import com.softeem.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MapperTests {

    @Resource
    private UserMapper userMapper;
    @Test
    public void selectById(){
        User user = userMapper.selectById(5);
        System.out.println(user);
    }

    @Test
    public void testInsert(){

        User user = new User();
        user.setName("老洪");
        user.setAge(23);
        user.setEmail("123@qq.com");
        //不设置email属性，则生成的动态sql中不包括email字段

        int result = userMapper.insert(user);
        System.out.println("影响的行数：" + result); //影响的行数
        System.out.println("id：" + user.getUid()); //id自动回填
    }
    @Test
    public void testSelect(){

        //按id查询
        User user = userMapper.selectById(1);
        System.out.println(user);

        //按id列表查询
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);

        //按条件查询
        Map<String, Object> map = new HashMap<>();
        map.put("name", "xiaoming"); //注意此处是表中的列名，不是类中的属性名
        map.put("age", 18);
        List<User> users1 = userMapper.selectByMap(map);
        users1.forEach(System.out::println);
    }
    @Test
    public void testUpdate(){

        User user = new User();
        user.setUid(11L);
        user.setAge(30);
        user.setName("老红");

        //注意：update时生成的sql自动是动态sql
        int result = userMapper.updateById(user);
        System.out.println("影响的行数：" + result);
    }
    @Test
    public void testDelete(){

        int result = userMapper.deleteById(5); //5->int->Integer->Number->Serializable
        System.out.println("影响的行数：" + result);
    }
    @Test
    public void testSelectAllByName(){
        List<User> users = userMapper.selectAllByName("xiaoming");
        users.forEach(System.out::println);
    }
}