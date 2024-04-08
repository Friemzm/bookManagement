
window.onload = function (){

    var nameT = document.getElementById("nameT");
    var passT = document.getElementById("passT");
    var rePassT = document.getElementById("rePassT");
    var emailT = document.getElementById("emailT");
    var phoneT = document.getElementById("phoneT");
    //获取到用户名
    var username = document.getElementById("username");
    username.onblur = function (){
        if (username.value != null && username.value != ""){
            nameT.innerHTML = "✔";
        }else{
            nameT.innerHTML = "✘ 请输入用户名！";
        }
    }

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

    //获取到重复密码
    var rePassword = document.getElementById("rePassword");
    rePassword.onblur = function (){
        if (rePassword.value == password.value){
            rePassT.innerHTML = "✔";
        }else{
            rePassT.innerHTML = "✘ 密码不一致！";
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
}

function sub(){
    //    获取到提交按钮
    var submit = document.getElementById("agree_submit");
    submit.onclick = function (){
        if ( document.getElementById("nameT").innerHTML == "✘ 请输入用户名！" ||
            document.getElementById("passT").innerHTML == "✘ 密码应为数字和字母组合！" ||
            document.getElementById("rePassT").innerHTML == "✘ 密码不一致！" ||
            document.getElementById("emailT").innerHTML == "✘ 邮箱格式不正确请检查后填写" ||
            document.getElementById("phoneT").innerHTML == "✘ 手机号码格式不正确！"||
            document.getElementById("nameT").value == ""||
            document.getElementById("passT").value == ""||
            document.getElementById("rePassT").value == ""||
            document.getElementById("emailT").value == ""||
            document.getElementById("phoneT").value == ""
        ){
            alert("注册信息有误");
        }else{
            document.formSub.submit();
        }
    }
}