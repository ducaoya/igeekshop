package com.igeek.shop.dao;

import com.igeek.shop.bean.Product;
import com.igeek.shop.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import com.igeek.shop.bean.Categroy;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDao {
    public List<Categroy> findByAllProduct() throws Exception{
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "select * from category";

        return qr.query(sql, new BeanListHandler<Categroy>(Categroy.class));
    }
//查询热门商品
    public List<Product> findByHotProductList() throws SQLException {
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql ="select * from product where is_hot=> limit ?,?";
        List<Product> list=runner.query(sql,new BeanListHandler<Product>(Product.class),1,0,9);
        return list;
    }
    //查询最新商品
    public  List<Product> findByNewProduct() throws SQLException {
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql ="select * from product order by pdate desc list limit ?,?";
        List<Product> list=runner.query(sql,new BeanListHandler<Product>(Product.class),1,0,9);
        return list;
    }

    public Product findByProductId(String pid) throws SQLException {
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from product where pid=?";
        return runner.query(sql,new BeanHandler<Product>(Product.class));
    }


}
