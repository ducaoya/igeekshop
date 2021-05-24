package com.igeek.shop.servlet;

import com.igeek.shop.bean.User;
import com.igeek.shop.service.LoginService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        LoginService loginService=new LoginService();


        List<User> list = null;
        try {
            list = (List)loginService.findByUserAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(list!=null&&list.size()!=0){
            for(User user:list){
                if(user.getUsername().equals(username)&&user.getPassword().equals(password))
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            }
        }

    }

}
