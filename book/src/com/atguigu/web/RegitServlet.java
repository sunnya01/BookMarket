package com.atguigu.web;

import com.atguigu.dao.User.User;
import com.atguigu.service.User.UserService;
import com.atguigu.service.User.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sunchaowei
 * @create 2026/3/26-13:21
 */
public class RegitServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2. 检查验证码是否正确 === 目前先写死获取验证码为 "abcde"
        if ("abcde".equalsIgnoreCase(code)) {
            //3. 检查用户名是否可用
            if (userService.existsUsername(username)) {
                //不可用
                System.out.println("用户名[" + username + "]已存在");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
            } else {
                //可用
                userService.register(new User(username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
            }
        } else {
            //验证码错误
            System.out.println("验证码[" + code + "]错误");
            //跳转到回注册页面
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
        }
    }
}
