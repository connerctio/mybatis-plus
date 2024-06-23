package com.softeem.order.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.softeem.order.client.UserClient;
import com.softeem.order.mapper.OrderMapper;
import com.softeem.order.pojo.Order;
import com.softeem.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2.远程查询user
        User user = userClient.findById(order.getUserId());
        //3.封装user到order
        order.setUser(user);
        // 4.返回
        return order;
    }

    @SentinelResource("goods")
    public void queryGoods() {
        System.err.println("查询商品");
    }



/*    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2.远程查询user
        //2.1.url地址
//        String url = "http://localhost:8080/user/" + order.getUserId();
        String url = "http://userservice/user/" + order.getUserId();
        //2.2.发送请求
        User user = restTemplate.getForObject(url, User.class);
        //3.封装user到order
        order.setUser(user);
        // 4.返回
        return order;
    }*/

}
