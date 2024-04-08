<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jsp标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>全部商品目录</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/footer.css" rel="stylesheet">
    <!-- 2. jQuery导入 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script>
        function seekBook() {
            //获取到查询文本框
            var bookName = document.getElementById("exampleInputName1");
            var classify = document.getElementById("exampleInputName2");
            //获取到查询按钮
            var seekSub = document.getElementById("seekSub");
            seekSub.onclick = function () {
                if (bookName.value == "" && classify.value == "") {
                    alert("请输入查询信息");
                } else {
                    document.seekForm.submit();
                }
            }
        }
    </script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div>
    <img src="images/topPage.png" style="width: 100%;">
</div>
<div class="container">
    <h3 style="text-align: center;color: #eb9316;margin: 20px 0px;font-weight: bolder;font-size: 30px">
        <a href="javascript:;"; style="text-decoration: none">购物车</a>
    </h3>
    <div>
        <a style="font-size: 16px;text-decoration: none;font-weight: bolder" href="${pageContext.request.contextPath}/settleServlet" >打印购物清单</a>
    </div>
    <div style="margin-bottom: 20px;margin-left: 630px;width: 550px">
        <form class="form-inline" name="seekForm" action="${pageContext.request.contextPath}/seekBookCarServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName1">书籍名称</label>
                <input type="text" name="bookName" class="form-control" id="exampleInputName1" >
            </div>
            <div class="form-group">
                <label for="exampleInputName2">类别</label>
                <input type="text" name="classify" class="form-control" id="exampleInputName2" >
            </div>
            <button type="button" class="btn btn-default" onclick="seekBook()" id="seekSub">查询</button>
        </form>
    </div>

    <form id="formBook" action="${pageContext.request.contextPath}/shopCarListServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th>序号</th>
                <th>书籍编号</th>
                <th>名称</th>
                <th>作者</th>
                <th>分类</th>
                <th>描述</th>
                <th>价格</th>
                <th>数量</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${goods}" var="goods" varStatus="s">
                <tr>
                    <td>${s.count}</td>
                    <td>${goods.id}</td>
                    <td style="font-weight: bolder">${goods.name}</td>
                    <td>${goods.author}</td>
                    <td style="color: orange">${goods.classify}</td>
                    <td>${goods.descr}</td>
                    <td style="color: red">￥${goods.price}</td>
                    <td>${goods.number}</td>
                    <td>
                        <a class="btn btn-default btn-sm" name="" href="${pageContext.request.contextPath}/deleteGoodsServlet?name=${goods.name}&loginUserName=${loginUserName}">
                            删除商品
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
<%--引入公共尾部--%>
<div style="margin-top: 210px">
    <%@include file="publicFooter.jsp"%>
</div>
</body>
</html>

