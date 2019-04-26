'use strict';
jQuery(document).ready(function() {
	
    /*
        Fullscreen background
    */
    $.backstretch("Public/img/backgrounds/1.jpg");
    
    /*
        Form validation
    */
    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    $('.btn').on('click', function(e) {
    	var userName=$('.login-form input[type="text"]').val();
    	var passWord=$('.login-form input[type="password"]').val();
    	if(userName==""&&passWord==""){
    		$('.login-form input[type="text"], .login-form input[type="password"]').addClass('input-error');
    	}else if(userName==""&&passWord!=""){
    		$('.login-form input[type="text"]').addClass('input-error');
    	}else if(userName!=""&&passWord==""){
    		$('.login-form input[type="password"]').addClass('input-error');
    	}else{
    		$.ajax({
				url:'user_login.action',
				type:'post',
				data:{userName:userName,password:passWord},
				dataType:'json',
				timeout:1000,  
				cache:false,    
				error:erryFunction,  //错误执行方法    
			    success:succFunction //成功执行方法 
			}); 
		    function erryFunction() { 
		    	console.log("err"); 
		    	window.location.href="login.html";
		    }  
			function succFunction(data) {
				if(data.mark==0){
					window.location.href="login.html";
				}else{
					sessionStorage.setItem("mark", data.mark);
					sessionStorage.setItem("socialCreditCode", data.socialCreditCode);
					sessionStorage.setItem("storeName", data.storeName);
					sessionStorage.setItem("user", data.userName);
					window.location.href="Views/index.html";
				}
			}
	    }

    	
    });
    
    
});
