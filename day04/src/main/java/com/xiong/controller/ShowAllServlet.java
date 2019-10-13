package com.xiong.controller;

import com.xiong.pojo.User;
import com.xiong.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showAll")
public class ShowAllServlet extends HttpServlet {

    /**
     * 显示用户信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("user") == null) {
            req.setAttribute("msg", "请登录");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
        UserService userService = new UserService();
        List<User> list = userService.findAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("showAll.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
