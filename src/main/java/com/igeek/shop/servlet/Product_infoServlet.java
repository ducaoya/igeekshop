package com.igeek.shop.servlet;

import com.igeek.shop.bean.Product;
import com.igeek.shop.service.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Product_infoServlet", value = "/Product_infoServlet")
public class Product_infoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String pid =request.getParameter("pid");

        ProductService productService=new ProductService();
        try {
            Product productId=productService.findByProductId(pid);
            request.setAttribute("pro",productId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("product_info.jsp").forward(request,response);

    }
}
