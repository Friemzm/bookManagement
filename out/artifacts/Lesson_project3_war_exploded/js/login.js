
window.onload = function (){
        //防止页面后退
        history.pushState(null, null, document.URL);
        window.addEventListener('popstate', function () {
            history.pushState(null, null, document.URL);
        });

//    获取到姓名文本框
    var name = document.getElementById("name");
    name.onblur = function (){
        this.nextElementSibling.innerHTML="<i></i>"
        if (name.value == ""){
            this.nextElementSibling.innerHTML="<i>此项为空</i>"
        }
    }

//    获取到密码框
    var password = document.getElementById("password");
    password.onblur = function (){
        this.nextElementSibling.innerHTML="<i></i>"
        if (password.value == ""){
            this.nextElementSibling.innerHTML="<i>此项为空</i>"
        }else{
                this.nextElementSibling.innerHTML="<i style='color: white'>格式有误</i>"
        }
    }

//    获取到提交按钮
    var submit = document.getElementById("submit");
    submit.onclick = function (){
        submit.setAttribute("type","submit");
        if (name.value == "" || password.value == ""){
           alert("用户名或密码为空");
           submit.setAttribute("type","button");
        }
    }
}


