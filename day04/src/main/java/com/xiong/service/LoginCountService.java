package com.xiong.service;

import com.xiong.dao.LoginCountDao;

public class LoginCountService {

    private LoginCountDao lcDao = new LoginCountDao();

    public void save(int count) {
        lcDao.save(count);
    }

    public int find() {
        return lcDao.find();
    }
}
