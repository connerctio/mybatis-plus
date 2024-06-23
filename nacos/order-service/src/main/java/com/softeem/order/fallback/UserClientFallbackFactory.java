package com.softeem.order.fallback;

import com.softeem.order.client.UserClient;
import com.softeem.order.pojo.User;
import lombok.extern.slf4j.Slf4j;
import feign.hystrix.FallbackFactory;


@Slf4j
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(final Throwable throwable) {
        return new UserClient() {
            @Override
            public User findById(Long id) {
                log.error("查询用户异常", throwable);
                return new User();
            }
        };
    }
}

