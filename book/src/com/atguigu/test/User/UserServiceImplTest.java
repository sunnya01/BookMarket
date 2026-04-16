package com.atguigu.test.User;

import com.atguigu.dao.User.User;
import com.atguigu.service.User.UserServiceImpl;
import org.junit.Test;

/**
 * @author sunchaowei
 * @create 2026/3/24-14:23
 */
public class UserServiceImplTest {

    private UserServiceImpl userService = new UserServiceImpl();

    private User user = new User();

    @Test
    public void register() {
        user.setUsername("test01");
        user.setPassword("123456");
        user.setEmail("123123@123.com");
        userService.register(user);
    }

    @Test
    public void login() {
        user.setUsername("test01");
        user.setPassword("123456");
        System.out.println(userService.login(user));
    }

    @Test
    public void existsUsername() {
        System.out.println(userService.existsUsername("test02"));
    }
}