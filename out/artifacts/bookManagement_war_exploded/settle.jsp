
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jsp标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>购物清单</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/footer.css" rel="stylesheet">
    <!-- 2. jQuery导入 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<script>
   window.onload = function (){
       var settle = document.getElementById("settle");
       var money = document.getElementById("money");
       settle.onclick = function (){
           confirm("你一共消费"+money.value+"元，确定要结算吗？");
       }
   }
</script>
<body>
<div>
    <img src="images/topPage.png" style="width: 100%;">
</div>
<div class="container">
    <h3 style="text-align: center;color: #eb9316;margin: 20px 0px;font-weight: bolder;font-size: 30px">
        <a href="javascript:;"; style="text-decoration: none">购物清单</a>
    </h3>
    <div style="margin-bottom: 20px">
        <a style="font-size: 16px;text-decoration: none;font-weight: bolder" href="${pageContext.request.contextPath}/index.jsp" >首页</a>
        <a style="font-size: 16px;text-decoration: none;font-weight: bolder" href="${pageContext.request.contextPath}/shopCarListServlet">购物车</a>
    </div>
    ${sum}
    <form id="formBook" action="${pageContext.request.contextPath}/shopCarListServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th style="text-align: center">序号</th>
                <th style="text-align: center">书籍编号</th>
                <th style="text-align: center">名称</th>
                <th style="text-align: center">作者</th>
                <th style="text-align: center">分类</th>
                <th style="text-align: center">描述</th>
                <th style="text-align: center">价格</th>
                <th style="text-align: center">数量</th>
                <th style="text-align: center">总消费</th>
            </tr>
            <c:forEach items="${goods}" var="goods" varStatus="s">
                <tr>
                    <td style="text-align: center">${s.count}</td>
                    <td style="text-align: center">${goods.id}</td>
                    <td style="font-weight: bolder;text-align: center">${goods.name}</td>
                    <td style="text-align: center">${goods.author}</td>
                    <td style="color: orange;text-align: center">${goods.classify}</td>
                    <td style="text-align: center">${goods.descr}</td>
                    <td style="color: red;text-align: center">￥${goods.price}</td>
                    <td style="text-align: center">${goods.number}</td>
                    <c:if test="">

                    </c:if>
                    <td>
                        ￥<fmt:formatNumber type="number" value="${sum = sum + goods.number * goods.price}" pattern="0.00" maxFractionDigits="2"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <input type="text" hidden id="money" value="<fmt:formatNumber type="number" value="${sum}" pattern="0.00" maxFractionDigits="2"/>">
        <button type="button" class="btn btn-warning" id="settle" style="margin-left: 48%">结算</button>
    </form>
</div>

<%--引入公共尾部--%>
<div style="margin-top: 210px">
    <%@include file="publicFooter.jsp"%>
</div>
</body>
</html>
