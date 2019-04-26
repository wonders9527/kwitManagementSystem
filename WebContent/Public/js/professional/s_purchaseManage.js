'use strict';
jQuery(document).ready(function() {

    init();

});


function init(){
    $(function(){
        $.ajax({
            url: 'recordPurchase_getPurchase.action',
            type: 'post',
            dataType:'json',
            data:{'socialCreditCode':sessionStorage.getItem("socialCreditCode")},
            timeout: 3000,
            ache: false,
            error: erryFunction,    //错误执行方法
            success: succFunction   //成功执行方法
        });
        function erryFunction(){
            console.log("error");
        }
        function succFunction(data){
            console.log(data);
        }
    });
}