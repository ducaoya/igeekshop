package com.igeek.shop.servlet;

import com.igeek.shop.bean.Categroy;
import com.igeek.shop.bean.Product;
import com.igeek.shop.service.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();

        List<Categroy> list = (List<Categroy>) session.getAttribute("list");

        ProductService productService=new ProductService();

        try {
            //获取热门商品
            List<Product> hotList = productService.findByHotProduct();
            //获取最新商品
            List<Product> newList=productService.findByNewProduct();
            request.setAttribute("hotList",hotList);
            request.setAttribute("newList",newList);
            session.setAttribute("list",list);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
