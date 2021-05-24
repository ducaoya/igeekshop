package com.igeek.shop.service;

import com.igeek.shop.bean.User;
import com.igeek.shop.dao.RegisterDao;
import com.igeek.shop.dao.UserDao;

import java.sql.SQLException;

public class RegisterService {
    RegisterDao registerDao=new RegisterDao();
    public  boolean findByAddUser(User user){
        int x=0;
        try{
            x=registerDao.findByAddUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x>0;
    }
}
