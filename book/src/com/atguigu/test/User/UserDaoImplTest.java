package com.atguigu.test.User;

import com.atguigu.dao.User.User;
import com.atguigu.dao.User.UserDaoImpl;
import org.junit.Test;

/**
 * @author sunchaowei
 * @create 2026/3/23-16:59
 */
public class UserDaoImplTest {

    @Test
    public void queryUserByUsername() {
        UserDaoImpl userDao = new UserDaoImpl();
        System.out.println(userDao.queryUserByUsername("admin"));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        UserDaoImpl userDao = new UserDaoImpl();
        System.out.println(userDao.queryUserByUsernameAndPassword("admin", "admin"));
    }

    @Test
    public void saveUser() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setUsername("root2");
        user.setPassword("root123");
        user.setEmail("18892621702@163.com");
        System.out.println(userDao.saveUser(user));
    }

    @Test
    public void updateUser() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.queryUserByUsername("root2");
        user.setPassword("root666");
        System.out.println(userDao.updateUser(user));
    }
}