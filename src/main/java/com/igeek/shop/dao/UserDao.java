package com.igeek.shop.dao;

import com.igeek.shop.bean.User;
import com.igeek.shop.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    public int findByAddUser(User user) throws SQLException {
        QueryRunner runner=new QueryRunner();
        String sql="insert into user values(?,?,?,?,?,?,?,?,?,?)";

        return runner.update(DataSourceUtils.getDataSource().getConnection(),sql,user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(), user.getBirthday(),user.getSex(),user.getState(),user.getCode());
    }

    public List<User> findByUser() throws SQLException {
        QueryRunner runner=new QueryRunner();
        String sql="select * from user";
        List<User> list = runner.query(DataSourceUtils.getDataSource().getConnection(),sql,new BeanListHandler<User>(User.class));
        return list;
    }
}
