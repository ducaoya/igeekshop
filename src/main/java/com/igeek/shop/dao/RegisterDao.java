package com.igeek.shop.dao;

import com.igeek.shop.bean.User;
import com.igeek.shop.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class RegisterDao {
    public int findByAddUser(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

        String sql ="insert into user values(?,?,?,?,?,?,?,?,?,?)";

        return qr.update(sql, user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode());
    }

    public List<User> findByUserAll() throws Exception {
        // TODO Auto-generated method stub

        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "select * from user";


        return queryRunner.query(sql, new BeanListHandler<User>(User.class));
    }
}
