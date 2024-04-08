window.onload = function () {
    //获取到搜索按钮
    var searchBut = document.getElementById("search_button");
    //获取到搜索框
    var searchText = document.getElementById("search_input");
//    为搜索按钮绑定单击事件
    searchBut.onclick = function () {
        //    判断搜索框是否为空
        if (searchText.value == "") {
            alert("你未输入内容！");
        }
    }

    //获取到用户名
    var username = document.getElementById("username");
    //获取到登录按钮
    var login = document.getElementById("login");
    //获取到注册按钮
    var register = document.getElementById("register");
    //获取到购物车按钮
    var shopping = document.getElementById("shopping");
    //获取到个人中心按钮
    var rivate = document.getElementById("private");
    //获取到退出按钮
    var exit = document.getElementById("exit");
    if(username.innerText.length > 0){
        shopping.removeAttribute("style");
        exit.removeAttribute("style");
        rivate.removeAttribute("style");

    }else{
        login.removeAttribute("style");
        register.removeAttribute("style");
    }

}