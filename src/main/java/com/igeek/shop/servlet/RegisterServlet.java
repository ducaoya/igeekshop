package com.igeek.shop.servlet;


import com.igeek.shop.bean.User;
import com.igeek.shop.service.RegisterService;
import com.igeek.shop.utils.CommonsUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "register",value = "/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("UTF-8");
        //创建bean内部user实例
        User user=new User();
        //借助beanUtils类静态参数直接映射到当前JavaBean
        try {
            BeanUtils.populate(user,req.getParameterMap());
            ConvertUtils.register(new Converter() {
                @Override
                public Object convert(Class aClass, Object value) {
                    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                    Date desc=null;
                    try {
                        desc=simpleDateFormat.parse((String)value);
                    }catch (ParseException e){
                        e.printStackTrace();
                    }

                    return desc;
                }
            },Date.class);
            //BeanUtils.populate(user,req.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
        }

        //获取随机Id
        String uid = CommonsUtils.getUUid();
        user.setUid(uid);
        user.setState(1);
        user.setCode(uid);
       // System.out.println(user);
        //创建registerService
        RegisterService registerService=new RegisterService();
        boolean isSuccess=registerService.findByAddUser(user);
        if(isSuccess){
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("registerFail.jsp").forward(req,resp);
        }


    }
}
