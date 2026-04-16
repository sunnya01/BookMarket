package com.atguigu.service.User;

import com.atguigu.dao.User.User;
import com.atguigu.dao.User.UserDao;
import com.atguigu.dao.User.UserDaoImpl;

/**
 * @author sunchaowei
 * @create 2026/3/24-14:09
 */
public class UserServiceImpl implements UserService {

    private static UserDao userDao;

    static {
        if (userDao == null)
            userDao = new UserDaoImpl();
    }

    @Override
    public void register(User user) {
        if (userDao != null) {
            if (existsUsername(user.getUsername()) == false)
                userDao.saveUser(user);
        }
    }

    @Override
    public User login(User user) {
        if (userDao != null) {
            return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        }
        return null;
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao != null) {
            return userDao.queryUserByUsername(username) != null;
        }
        return false;
    }
}
