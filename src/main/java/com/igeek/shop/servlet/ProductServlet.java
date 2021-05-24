package com.igeek.shop.servlet;

import com.igeek.shop.bean.Categroy;
import com.igeek.shop.service.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductService();

        List<Categroy> list = productService.findByAllProduct();

        HttpSession session = request.getSession();

        session.setAttribute("list", list);

        request.getRequestDispatcher("product_info.jsp").forward(request, response);
    }
}
