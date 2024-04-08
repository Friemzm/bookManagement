<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <title>图书管理系统</title>
    <!--    引入CSS外部样式表-->
    <link rel="stylesheet" href="css/index_control.css">
    <link rel="stylesheet" href="css/footer.css">
    <!--    除去浏览器默认样式-->
    <link rel="stylesheet" href="css/reset.css">
    <!--    引入JS外部样式表-->
    <script src="js/index.js"></script>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap_index.css">

	<!-- jQuery -->
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<script>
    function bookList(){
        location.href = "${pageContext.request.contextPath}/allBookServlet";
    }
</script>
<body>
	<!--引入头部-->
    <div class="header" >
        <div class="top_banner" >
            <img src="images/topPage.png" style="width: 100%">
        </div>
        <div class="shortcut">
            <div class="login_out">
                <a href="login.jsp" id="login" style="visibility: hidden">登录</a>
                <a href="register.jsp" id="register" style="visibility: hidden">注册</a>
                <a id="username" style="color: #eb9316;size: 8px">${loginUserNameIndex}</a>
                <a href="${pageContext.request.contextPath}/shopCarListServlet" id="shopping"  style="visibility: hidden">购物车</a>
                <a href="${pageContext.request.contextPath}/personalCenterServlet" id="private" style="visibility: hidden">个人中心</a>
                <a href="javascript:location.href='exitServlet';" id="exit" style="visibility: hidden">退出</a>
            </div>
        </div>
        <div class="header_wrap">
            <div class="topbar" style="margin-bottom: 20px">
                <div class="logo">
                    <a href="index.jsp"><img src="images/logo.jpg" style="width: 180px;height: 50px" alt=""></a>
                </div>
                <div class="search">
                    <input name="" id="search_input" type="text" placeholder="请输入书籍名称" style="color: black" class="search_input" autocomplete="off">
                    <a href="javascript:;" id="search_button" class="search-button">搜索</a>
                </div>
                <div class="hottel">
                    <div class="hot_pic">
                        <img src="images/hot_tel.jpg" alt="">
                    </div>
                    <div class="hot_tel">
                        <p class="hot_time">客服热线(9:00-6:00)</p>
                        <p class="hot_num">400-618-9090</p>
                    </div>
                </div>
            </div>
        </div>

        <!--        定义导航条-->
        <div class="navbar-inverse" style="background-color:black">
            <div class="nav_inner">
                <a class="next_a" href="javascript:;" style="text-decoration: none">文学</a>
                <a class="next_a" href="javascript:;" style="text-decoration: none">生活</a>
                <a class="next_a" href="javascript:;" style="text-decoration: none">计算机</a>
                <a class="next_a" href="javascript:;" style="text-decoration: none">外语</a>
                <a class="next_a" href="javascript:;" style="text-decoration: none">经管</a>
                <a class="next_a" href="javascript:;" style="text-decoration: none">励志</a>
                <a class="next_a" href="javascript:;" style="text-decoration: none">社科</a>
                <a class="next_a" href="javascript:;" style="text-decoration: none">学术</a>
                <a class="next_a" href="javascript:;" style="text-decoration: none">少儿</a>
                <a class="next_a" href="javascript:;" style="text-decoration: none">艺术</a>
                <a class="next_a" href="javascript:;" style="text-decoration: none">原版</a>
                <a class="next_a" href="javascript:;" style="text-decoration: none">科技</a>
                <a class="next_a" href="javascript:;" style="text-decoration: none">考试</a>
                <a class="next_a" href="javascript:;" style="text-decoration: none">生活百科</a>
                <a class="next_a" href="javascript:;" style="text-decoration: none" onclick="bookList()">全部商品目录</a>
            </div>
        </div>
    </div>
    <!-- 轮播图-->
    <section id="banner">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="3000">
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="images/banner_1.jpg" alt="">
                </div>
                <div class="item">
                    <img src="images/banner_2.jpg" alt="">
                </div>
                <div class="item">
                    <img src="images/banner_3.jpg" alt="">
                </div>
            </div>
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
			    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
			    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
        </div>
    </section>
    <!-- 书籍推荐-->
    <section id="content">
        <section class="hemai_jx">
            <div class="jx_top">
                <div class="jx_tit">
                    <img src="images/icon_5.jpg" alt="">
                    <span>人气推荐</span>
                </div>
            </div>
            <div class="jx_content">
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="popularity">
                        <div class="row">
                            <div class="col-md-3">
                                <a href="javascript:;">
                                    <img src="images/book1.jpg" alt="">
                                    <div class="has_border">
                                        <h3 style="border: 2px">西游记</h3>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-3">
                                <a href="javascript:;">
                                    <img src="images/book2.jpg" alt="">
                                    <div class="has_border">
                                        <h3 style="border: 2px">红楼梦</h3>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-3">
                                <a href="javascript:;">
                                    <img src="images/book3.jpg" alt="">
                                    <div class="has_border">
                                        <h3 style="border: 2px">三国演义</h3>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-3">
                                <a href="javascript:;">
                                    <img src="images/book4.jpg" alt="">
                                    <div class="has_border">
                                        <h3 style="border: 2px">水浒传</h3>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </section>

    <%@include file="publicFooter.jsp"%>

</body>
</html>
