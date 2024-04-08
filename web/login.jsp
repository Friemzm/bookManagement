<%@ page contentType="text/html;charset=utf-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title></title>
  <link rel="stylesheet" type="text/css" href="css/login.css" />

</head>
<body>

<div class="login-box">
  <h2>Login</h2>
  <form action="${pageContext.request.contextPath}/userLoginServlet" method="post">
    <div class="login-field">
      <input type="text" name="username" required="" />
      <label>用户名/管理员名</label>
    </div>
    <div class="login-field">
      <input type="password" name="password"  required="" />
      <label >密码</label>
    </div>
    <button type="submit" id="submit" style="margin-left: 142px">登录</button>
    <div style="color: #eb9316;margin-top: 10px;margin-left: 150px">
      <strong>${loginErr}</strong>
    </div>
  </form>
</div>
</body>
</html>