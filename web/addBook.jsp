<%@ page contentType="text/html;charset=utf-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加书籍页面</title>
    <link rel="stylesheet" type="text/css" href="css/addBook.css" />

    <script src="js/addBook.js"></script>
</head>
<body>

<div class="login-box">
    <h2>添加书籍</h2>
    <form name="formSub" action="${pageContext.request.contextPath}/contAddBookServlet" method="post">
        <div class="login-field">
            <input type="text" name="id" id="id" required="" /><i id="idT" style="color: #eb9316;"></i>
            <label>书籍编号</label>
        </div>
        <div class="login-field">
            <input type="text" name="name" id="name" required="" /><i id="nameT" style="color: #eb9316;"></i>
            <label >书籍名称</label>
        </div>
        <div class="login-field">
            <input type="text" name="author" id="author" required="" /><i id="authorT" style="color: #eb9316;"></i>
            <label >作者</label>
        </div>
        <div class="login-field">
            <input type="text" name="classify" id="classify" required="" /><i id="classifyT" style="color: #eb9316;"></i>
            <label >类别</label>
        </div>
        <div class="login-field">
            <input type="text" name="descr" id="descr" required="" /><i id="descrT" style="color: #eb9316;" ></i>
            <label >描述</label>
        </div>
        <div class="login-field">
            <input type="text" name="price" id="price" required="" /><i id="priceT" style="color: #eb9316;"></i>
            <label >价格</label>
        </div>
        <button type="button" id="agree_submit" onclick="sub()" style="margin-left: 140px">添加</button>
        <div style="color: #eb9316;margin-top: 10px;margin-left: 125px">
            <strong>${addErr}</strong>
        </div>
    </form>
</div>
</body>
</html>