<%@ page contentType="text/html;charset=utf-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>注册页面</title>
  <link rel="stylesheet" type="text/css" href="css/register.css" />

  <script src="js/register.js"></script>
</head>
<body>

<div class="login-box">
  <h2>Register</h2>
  <form name="formSub" action="${pageContext.request.contextPath}/userRegisterServlet" method="post">
    <div class="login-field">
      <input type="text" name="username" id="username" required="" /><i style="color: #eb9316;" id="nameT"></i>
      <label>用户名</label>
    </div>
    <div class="login-field">
      <input type="password" name="password" id="password" required="" /><i style="color: #eb9316;" id="passT"></i>
      <label >密码</label>
    </div>
    <div class="login-field">
      <input type="password" name="rePassword" id="rePassword" required="" /><i style="color: #eb9316;" id="rePassT"></i>
      <label >重复密码</label>
    </div>
    <div class="" style="color: white;margin-top: 8px;margin-bottom: 15px">
      <label >性别</label>
      <input type="radio" name="gender" required="" value="男" checked />男
      <input type="radio" name="gender" required="" value="女" />女
    </div>
    <div class="login-field">
      <input type="text" name="email" id="email" required="" /><i style="color: #eb9316;" id="emailT"></i>
      <label >邮箱</label>
    </div>
    <div class="login-field">
      <input type="text" name="telephone" id="telephone" required="" /><i style="color: #eb9316;" id="phoneT"></i>
      <label >电话</label>
    </div>
    <button type="button" id="agree_submit" onclick="sub()" style="margin-left: 120px">注册</button>
    <div style="color: #eb9316;margin-top: 10px;text-align: center">
      <strong>${registerErr}</strong>
    </div>
  </form>
</div>
</body>
</html>