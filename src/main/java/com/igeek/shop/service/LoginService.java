package com.igeek.shop.service;

import com.igeek.shop.bean.User;
import com.igeek.shop.dao.RegisterDao;

import java.util.List;

public class LoginService {
        RegisterDao  dao = new RegisterDao();
        public  List<User> findByUserAll() throws Exception {
            List<User> list=dao.findByUserAll();
            return list;
        }
}
