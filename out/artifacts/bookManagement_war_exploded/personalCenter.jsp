<%@ page contentType="text/html;charset=utf-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人中心</title>
    <link rel="stylesheet" type="text/css" href="css/personal.css" />
</head>
<script>
    window.onload = function (){
        var nameT = document.getElementById("nameT");
        var passT = document.getElementById("passT");
        var emailT = document.getElementById("emailT");
        var phoneT = document.getElementById("phoneT");


//    获取到密码
        var password = document.getElementById("password");
        //定义密码正则
        var pw1String = "^(?![\\d]+$)(?![a-zA-Z]+$)(?![^\\da-zA-Z]+$).{6,20}$";
        password.onblur = function (){
            if (password.value != null && password.value != "" && password.value.match(pw1String)){
                passT.innerHTML = "✔";
            }else{
                passT.innerHTML = "✘ 密码应为数字和字母组合！";
            }
        }


        //    获取到邮箱
        var email = document.getElementById("email");
        //定义邮箱正则
        var emailString = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
        email.onblur = function (){
            if (email.value != null && email.value != "" && email.value.match(emailString)){
                emailT.innerHTML = "✔";
            }else{
                emailT.innerHTML = "✘ 邮箱格式不正确请检查后填写";
            }
        }

//    获取到手机号
        var telephone = document.getElementById("telephone");
        //定义手机号正则
        var phoneString = "^(?:(?:\\+|00)86)?1(?:(?:3[\\d])|(?:4[5-7|9])|(?:5[0-3|5-9])|(?:6[5-7])|(?:7[0-8])|(?:8[\\d])|(?:9[1|8|9]))\\d{8}$";
        telephone.onblur = function (){
            if (telephone.value != null && telephone.value != "" && telephone.value.match(phoneString)){
                phoneT.innerHTML = "✔";
            }else{
                phoneT.innerHTML = "✘ 手机号码格式不正确！";
            }
        }
        //    回显性别单选框
        var man = document.getElementById("man");
        var weman = document.getElementById("weman");
        if ('${personalCenterUser.gender}' == "女"){
            man.removeAttribute("checked");
            weman.setAttribute("checked","checked");
        }
        //注销用户
        var deleteUser = document.getElementById("deleteUser");
        deleteUser.onclick = function (){
            if (confirm("你确定要注销此账户吗？")){
                deleteUser.setAttribute("href","${pageContext.request.contextPath}/deleteUserServlet?username=${personalCenterUser.username}");
            }
        }
    }



    function sub(){
        //    获取到提交按钮
        document.getElementById("agree_submit").onclick = function (){
            if (
                document.getElementById("passT").innerHTML == "✘ 密码应为数字和字母组合！" ||
                document.getElementById("emailT").innerHTML == "✘ 邮箱格式不正确请检查后填写" ||
                document.getElementById("phoneT").innerHTML == "✘ 手机号码格式不正确！"||
                document.getElementById("passT").value == ""||
                document.getElementById("emailT").value == ""||
                document.getElementById("phoneT").value == ""){
                alert("信息有误");
            }else {
                alert("更改成功！")
                document.formSub.submit();
            }
        }
    }
</script>
<body>
<div class="login-box">
    <a style="text-decoration: none;color: #eb9316" href="${pageContext.request.contextPath}/index.jsp">首页</a>
    <h2>我的信息</h2>
    <form name="formSub" action="${pageContext.request.contextPath}/personalCenterServlet" method="post">
        <div class="login-field">
            <input type="text" name="username" readonly value="${personalCenterUser.username}" id="username" required="" /><i style="color: #eb9316;" id="nameT"></i>
        </div>
        <div class="login-field">
            <input type="password" name="password" value="${personalCenterUser.password}" id="password" required="" /><i style="color: #eb9316;" id="passT"></i>
            <label >密码</label>
        </div>
        <div class="" style="color: white;margin-top: 5px;margin-bottom: 25px">
            <label >性别</label>
            <input type="radio" name="gender" id="man" required="" checked value="男" />男
            <input type="radio" name="gender" id="weman" required="" value="女" />女
        </div>
        <div class="login-field">
            <input type="text" name="email" value="${personalCenterUser.email}" id="email" required="" /><i style="color: #eb9316;" id="emailT"></i>
            <label >邮箱</label>
        </div>
        <div class="login-field">
            <input type="text" name="telephone" value="${personalCenterUser.telephone}" id="telephone" required="" /><i style="color: #eb9316;" id="phoneT"></i>
            <label >电话</label>
        </div>
        <button type="button" id="agree_submit" onclick="sub()" style="margin-left: 200px;margin-bottom: 20px">更改信息</button>
        <a id="deleteUser" href="javascript:;" style="margin-left: 215px;margin-top: 30px;color: #eb9316;text-decoration: none">注销用户</a>
        <div style="color: #eb9316;margin-top: 10px;text-align: center">
            <strong>${registerErr}</strong>
        </div>
    </form>
</div>
</body>
</html>