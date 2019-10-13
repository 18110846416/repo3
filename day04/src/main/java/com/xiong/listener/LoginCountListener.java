package com.xiong.listener;

import com.xiong.service.LoginCountService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LoginCountListener implements ServletContextListener {

    private LoginCountService lcService = new LoginCountService();

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        int count = lcService.find();
        sc.setAttribute("count", count);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        Object count = sc.getAttribute("count");
        lcService.save((Integer) count);
    }
}
