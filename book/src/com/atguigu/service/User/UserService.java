package com.atguigu.service.User;

import com.atguigu.dao.User.User;
import com.atguigu.dao.error.Error;

/**
 * @author sunchaowei
 * @create 2026/3/24-14:03
 */
public interface UserService {
    /**
     * 用户注册提交事件
     *
     * @param user 用户对象
     * @return 返回true表示注册成功否则表示注册失败
     */
    public void register(User user);
    /**
     * 登录
     *
     * @param user
     * @return如果返回null 说明登录失败，返回有值是登录成功
     */
    public User login(User user);
    /**
     * 检查用户是否存在
     *
     * @param username
     * @return 返回true表示用户名已存在,返回false表示用户名可用
     */
    public boolean existsUsername(String username);
}
