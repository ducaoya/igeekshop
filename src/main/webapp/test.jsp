<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2021/03/16
  Time: 09:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
    <form action="#" method="post">
        <input type="text" name="username" placeholder="用户名"><br>
        <input type="password" name="password" placeholder="密码"><br>
        <input type="text" placeholder="验证码"><img id="codeImg" src="code" onclick="refreshCode()"><br>
        <input type="submit" value="提交"><br>
    </form>
</body>
<script>
    function refreshCode(){
        //获取图片
        document.getElementById("codeImg").src="code?date="+new Date().getTime();
        console.log(1);
    }
</script>
</html>
