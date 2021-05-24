package com.igeek.shop.service;

import com.igeek.shop.bean.Categroy;
import com.igeek.shop.bean.Product;
import com.igeek.shop.dao.ProductDao;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    ProductDao productDao = new ProductDao();
    public List<Categroy> findByAllProduct() {
        List<Categroy> list = null;
        try {
            list = productDao.findByAllProduct();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            }
        return list;
    }

    public List<Product> findByHotProduct() throws SQLException {
        List<Product> list=productDao.findByHotProductList();

        return list;
    }

    public List<Product> findByNewProduct() throws SQLException {
        List<Product> list=productDao.findByNewProduct();
        return list;
    }

    public Product findByProductId(String pid) throws SQLException {
        Product productId=productDao.findByProductId(pid);
        return productId;
    }
}
