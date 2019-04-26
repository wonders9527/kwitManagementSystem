'use strict';
jQuery(document).ready(function() {
	
	init();

});

var dataJson;
function init(){	
	$(function(){
		$.ajax({
			url: 'dataProductInformation_getProductInfor.action',
			type: 'post',
			dataType:'json',
			data:{'socialCreditCode':sessionStorage.getItem("socialCreditCode")},
			timeout: 3000,  
      		ache: false,    
    		error: erryFunction,    //错误执行方法    
   			success: succFunction   //成功执行方法 
		}); 
	  	function erryFunction() {  
	    	console.log("error");  
	  	}  
		function succFunction(data) {
			dataJson=data;
			var initCommodityShelfStatus;
			var initParticipationDiscountStatus;
			var initMallDisplayStatus;
			if(data.length>0){
				for(var i=0;i<data.length;i++){
					if(data[i].commodityShelfStatus=='1'){
						initCommodityShelfStatus='fa fa-toggle-on';
					}else if(data[i].commodityShelfStatus=='0'){
						initCommodityShelfStatus='fa fa-toggle-off';
					}
					
					if(data[i].participationDiscountStatus=='1'){
						initParticipationDiscountStatus='fa fa-toggle-on';
					}else if(data[i].participationDiscountStatus=='0'){
						initParticipationDiscountStatus='fa fa-toggle-off';
					}
					
					if(data[i].mallDisplayStatus=='1'){
						initMallDisplayStatus='fa fa-toggle-on';
					}else if(data[i].mallDisplayStatus=='0'){
						initMallDisplayStatus='fa fa-toggle-off';
					}
					$(".widget-body table tbody").append(
						'<tr>'+
						'<td><input type="checkbox" class="no-margin" value=\"'+data[i].id+'\"/></td>'+
						'<td><span>'+data[i].commodityClassification+'</span></td>'+
						'<td><span>'+data[i].commodityName+'</span></td>'+
						'<td><span>'+data[i].commodityCode+'</span></td>'+	
						'<td>'+
						'<a for="priceManagement" href="#" style="margin-left: 0px;" class="btn btn-info btn-mini">'+
						'<i class="fa fa-pencil-square-o" style="font-size:16px"></i>管理价格'+
						'</a>'+
						'</td>'+
						'<td><i for="participationDiscountStatus" class=\"'+initParticipationDiscountStatus+'\" style="font-size:35px;color: green;"></i></td>'+
						'<td><i for="mallDisplayStatus" class=\"'+initMallDisplayStatus+'\" style="font-size:35px;color: green;"></i></td>'+
						'<td><i for="commodityShelfStatus" class=\"'+initCommodityShelfStatus+'\" style="font-size:35px;color: green;"></i></td>'+
						'<td>'+
						'<a for="editProduct" href="#" class="btn btn-info btn-mini"><i class="fa fa-pencil-square-o" style="font-size:16px"></i>编辑</a>'+
						'<a for="deleteProduct" href="#" class="btn btn-success btn-mini"><i class="fa fa-trash-o" style="font-size:16px"></i>删除</a>'+
						'</td>'+
						'</tr>'
					);
				}
				operate();
			}	
	  	} 
	});
}

function operate(){
	
	$('a[for="priceManagement"]').click(function(event){
		var thisTrJson=getTrList(event);
		$('#priceManagementTable tbody').children('tr').remove();
		$('#priceManagementTable tbody').append(
			'<tr>'+
			'<td><span>'+thisTrJson.specificationContent+'</span></td>'+
			'<td><input type="text" value=\"'+thisTrJson.commodityPrice+'\"/></td>'+
			'<td><input type="text" value=\"'+thisTrJson.commissionAmount+'\"/></td>'+
			'</tr>'
		);
		
		document.getElementById("priceUpdate").addEventListener("click", function() {
		    priceUpdateFunction(thisTrJson);
		});
		$('#priceManagementModal').modal('show');	
	});
	
	$('a[for="packageManagement"]').click(function(event){
		var thisTrJson=getTrList(event);
		console.log(thisTrJson);
	});
	
	$('i[for="participationDiscountStatus"]').click(function(event){
		var e=event||window.event;
		var targetElement=e.target||e.srcElement;
		var thisTrJson=getTrList(event);
		if($(targetElement).attr('class')=='fa fa-toggle-on'){
			thisTrJson.participationDiscountStatus='0';
			$.ajax({
			    url: 'dataProductInformation_updateProductInfor.action',
			    type: 'post',
			    data:thisTrJson,
			    dataType:'json',
			    timeout: 3000,  
		      	ache: false,    
			  	error: erryFunction,    //错误执行方法    
			  	success: succFunction   //成功执行方法 
			});
		    function erryFunction() {  
			    console.log('err');
			}  
			function succFunction(data) {
				$(targetElement).removeClass().addClass('fa fa-toggle-off');
			}				
		}else if($(targetElement).attr('class')=='fa fa-toggle-off'){
			thisTrJson.participationDiscountStatus='1';
			$.ajax({
			    url: 'dataProductInformation_updateProductInfor.action',
			    type: 'post',
			    data:thisTrJson,
			    dataType:'json',
			    timeout: 3000,  
		      	ache: false,    
			  	error: erryFunction,    //错误执行方法    
			  	success: succFunction   //成功执行方法 
			});
		    function erryFunction() {  
			    console.log('err');
			}  
			function succFunction(data) {
				$(targetElement).removeClass().addClass('fa fa-toggle-on');
			}
		}
	});
	
	$('i[for="mallDisplayStatus"]').click(function(event){
		var e=event||window.event;
		var targetElement=e.target||e.srcElement;
		var thisTrJson=getTrList(event);
		if($(targetElement).attr('class')=='fa fa-toggle-on'){
			thisTrJson.mallDisplayStatus='0';
			$.ajax({
			    url: 'dataProductInformation_updateProductInfor.action',
			    type: 'post',
			    data:thisTrJson,
			    dataType:'json',
			    timeout: 3000,  
		      	ache: false,    
			  	error: erryFunction,    //错误执行方法    
			  	success: succFunction   //成功执行方法 
			});
		    function erryFunction() {  
			    console.log('err');
			}  
			function succFunction(data) {
				$(targetElement).removeClass().addClass('fa fa-toggle-off');
			}				
		}else if($(targetElement).attr('class')=='fa fa-toggle-off'){
			thisTrJson.mallDisplayStatus='1';
			$.ajax({
			    url: 'dataProductInformation_updateProductInfor.action',
			    type: 'post',
			    data:thisTrJson,
			    dataType:'json',
			    timeout: 3000,  
		      	ache: false,    
			  	error: erryFunction,    //错误执行方法    
			  	success: succFunction   //成功执行方法 
			});
		    function erryFunction() {  
			    console.log('err');
			}  
			function succFunction(data) {
				$(targetElement).removeClass().addClass('fa fa-toggle-on');
			}			
		}
	});
	
	$('i[for="commodityShelfStatus"]').click(function(event){
		var e=event||window.event;
		var targetElement=e.target||e.srcElement;
		var thisTrJson=getTrList(e);
		if($(targetElement).attr('class')=='fa fa-toggle-on'){
			thisTrJson.commodityShelfStatus='0';
			$.ajax({
			    url: 'dataProductInformation_updateProductInfor.action',
			    type: 'post',
			    data:thisTrJson,
			    dataType:'json',
			    timeout: 3000,  
		      	ache: false,    
			  	error: erryFunction,    //错误执行方法    
			  	success: succFunction   //成功执行方法 
			});
		    function erryFunction() {  
			    console.log('err');
			}  
			function succFunction(data) {
				$(targetElement).removeClass().addClass('fa fa-toggle-off');
			}				
		}else if($(targetElement).attr('class')=='fa fa-toggle-off'){
			thisTrJson.commodityShelfStatus='1';
			$.ajax({
			    url: 'dataProductInformation_updateProductInfor.action',
			    type: 'post',
			    data:thisTrJson,
			    dataType:'json',
			    timeout: 3000,  
		      	ache: false,    
			  	error: erryFunction,    //错误执行方法    
			  	success: succFunction   //成功执行方法 
			});
		    function erryFunction() {  
			    console.log('err');
			}  
			function succFunction(data) {
				$(targetElement).removeClass().addClass('fa fa-toggle-on');
			}			
		}
	});
	
	$('a[for="editProduct"]').click(function(event){
		var e=event||window.event;
		var thisTrJson=getTrList(e);
		window.location.href ='p_editProduct.html?product='+thisTrJson.id;
	});
	
	$('a[for="deleteProduct"]').click(function(event){
		var e=event||window.event;
		var thisTrJson=getTrList(e);
		$.ajax({
			url: 'dataProductInformation_deleteProductInfor.action',
			type: 'post',
			data:thisTrJson,
			dataType:'json',
			timeout: 3000,
			ache: false,
			error: erryFunction,    //错误执行方法
			success: succFunction   //成功执行方法
		});
		function erryFunction() {
			$('#div_info').html('删除失败！');
			$('#modal_info').modal('show');
		}
		function succFunction(data) {
			if(data.mark=='1'){
				$('#div_info').html('删除成功！');
				$('#modal_info').modal('show');
			}else{
				$('#div_info').html('删除失败！');
				$('#modal_info').modal('show');
			}
		}
	});
}


function priceUpdateFunction(thisTrJson){
	thisTrJson.commissionAmount=$($('#priceManagementTable tbody tr').children()[2].children).val();
	thisTrJson.commodityPrice=$($('#priceManagementTable tbody tr').children()[1].children).val();

	$.ajax({
	    url: 'dataProductInformation_updateProductInfor.action',
	    type: 'post',
	    data:thisTrJson,
	    dataType:'json',
	    timeout: 3000,  
      	ache: false,    
	  	error: erryFunction,    //错误执行方法    
	  	success: succFunction   //成功执行方法 
	});
    function erryFunction() {
    	$('#priceManagementModal').modal('hide');
	    $('#div_info').html('价格更改失败！');
		$('#modal_info').modal('show');
	}  
	function succFunction(data) {
		if(data.mark=='1'){
			$('#priceManagementModal').modal('hide');
			$('#div_info').html('价格更改成功！');
			$('#modal_info').modal('show');
		}else{
			$('#priceManagementModal').modal('hide');
			$('#div_info').html('价格更改失败！');
			$('#modal_info').modal('show');
		}
	}
}



function getTrList(event){
	var e=event||window.event;
	var targetElement=e.target||e.srcElement;
	var thisJson;
	var trElement=$(targetElement).parents("tr");
	var id=$(trElement.children()[0].children).val();
	for(var i=0;i<dataJson.length;i++){
		if(id==dataJson[i].id){
			thisJson=dataJson[i];
		}
	}
	return thisJson;
}


$('#btnClose').click(function(){
	$('#modal_info').modal('hide');
});

$(function() {
	$('#modal_info').on('hide.bs.modal',function() {
		window.location.href='p_listProduct.html';	
	})
});