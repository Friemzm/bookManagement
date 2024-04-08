
window.onload = function (){

//    获取到价格
    var price = document.getElementById("price");
    var priceT = document.getElementById("priceT");
    //定义价格正则
    var priceString = "^-?\\d+(,\\d{3})*(\\.\\d{1,2})?$";
    price.onblur = function (){
        if (price.value != null && price.value != "" && price.value.match(priceString)){
            priceT.innerHTML = "✔";
        }else{
            priceT.innerHTML = "✘";
        }
    }
}

function sub(){
    //    获取到提交按钮
    var submit = document.getElementById("agree_submit");
    submit.onclick = function (){
        if ( document.getElementById("priceT").innerHTML == "✘" ||
             document.getElementById("priceT").value == ""
        ){
            alert("书籍信息有误");
        }else{
            document.formSub.submit();
        }
    }
}