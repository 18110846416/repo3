package com.xiong.controller;

import com.xiong.pojo.User;
import com.xiong.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    /**
     * 用户登录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 登录人数累加
        ServletContext sc = this.getServletContext();
        if(sc.getAttribute("count") == null) {
            sc.setAttribute("count", 1);
        } else {
            Object obj = sc.getAttribute("count");
            sc.setAttribute("count", Integer.parseInt(obj.toString()) + 1);
        }

        UserService userService = new UserService();
        User user = userService.findByUsernameAndPassword(username, password);
        if(user.getId() != null) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("showAll");
            return;
        } else {
            req.setAttribute("msg", "用户名密码错误");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
