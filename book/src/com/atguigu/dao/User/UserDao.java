package com.atguigu.dao.User;

/**
 * @author sunchaowei
 * @create 2026/3/23-15:46
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息(注册的时候检查用户是否存在)
     * @param username
     * @return
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息(登录的时候检查用户名和密码是否正确)
     * @param username
     * @param password
     * @return 如果返回null表示用户名和密码组合错误
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 新用户创建完成进行保存
     * @param user
     * @return -1表示保存失败
     */
    public int saveUser(User user);

    /**
     * 旧用户更新个人信息
     * @param user
     * @return -1表示更新失败
     */
    public int updateUser(User user);

}
