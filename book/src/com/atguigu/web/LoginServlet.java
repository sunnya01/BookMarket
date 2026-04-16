package com.atguigu.web;

import com.atguigu.dao.User.User;
import com.atguigu.service.User.UserService;
import com.atguigu.service.User.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sunchaowei
 * @create 2026/3/26-14:05
 */
public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2. 处理登录业务
        User loginUser = userService.login(new User(username, password, null));

        boolean userNameExists = userService.existsUsername(username);

        if (loginUser == null) {
            //跳回登录页面
            if (!userNameExists) {
                System.out.println(username+"登录失败,用户名不存在!");
            }else{
                System.out.println(username+"登录失败,密码错误!");
            }

            req.getRequestDispatcher("/pages/user/login.html").forward(req, resp);
        }else{
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req, resp);
        }

    }
}
