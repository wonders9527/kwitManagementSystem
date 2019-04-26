'use strict';
jQuery(document).ready(function() {
	
	init();
    
});

function init(){
    $(function(){
		$.ajax({
			url: 'dataClassifiedInformation_getProductClassified.action',
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
	      	if(data.length>0){
		    	for(var i=0;i<data.length;i++){	
					$(".widget-body table tbody").append(
						'<tr>'+
							'<td style="display: none;"><input type="checkbox" class="no-margin" value=\"'+data[i].id+'\"/></td>'+
							'<td><span class="name">'+data[i].commodityClassification+'</span></td>'+
							'<td class="hidden-phone">'+
								'<a href="#" onclick="editClassifiled()" class="btn btn-info btn-mini"><i class="fa fa-pencil-square-o" style="font-size:16px"></i>编辑</a>'+
								'<a href="#" onclick="deleteClassifiled()" class="btn btn-success btn-mini"><i class="fa fa-trash-o" style="font-size:16px"></i>删除</a>'+
							'</td>'+
						'</tr>');
				} 
	      	}
		} 
	});
}
	
    	
$('#addClassification').on('click',function(){
	var JsonList={
		'socialCreditCode':sessionStorage.getItem("socialCreditCode"),
		'storeName':sessionStorage.getItem("storeName"),
		'commodityClassification':$('#classificationName').val()
	};
	if(JsonList.classificationName==''){
		$('#div_info').html('"部门名称为空"！');
		$('#modal_info').modal('show');
	}else{
		$.ajax({
		    url: 'dataClassifiedInformation_addProductClassified.action',
		    type: 'post',
		    data:JsonList,
		    dataType:'json',
		    timeout: 3000,
	      	ache: false,
 	  	error: erryFunction,    //错误执行方法
		  	success: succFunction   //成功执行方法
		});
	    function erryFunction() {
		    $('#div_info').html('新增分类失败！');
			$('#modal_info').modal('show');
		}
		function succFunction(data) {
			if(data.mark=='1'){
				$('#div_info').html('新增分类成功！');
				$('#modal_info').modal('show');
			}else{
				$('#div_info').html(data.result);
				$('#modal_info').modal('show');
			}
		}
	}
});

function editClassifiled(event){
	var thisClassifiled=getThisClassifiled(event);
	$('#updateClassificationName').val(thisClassifiled.name);
	$('#updateAreaId').val(thisClassifiled.id);
	$('#modal_edit').modal('show');
}

function deleteClassifiled(event){
	var thisClassifiled=getThisClassifiled(event);
	$.ajax({
	    url: 'dataClassifiedInformation_deleteProductClassified.action',
	    type: 'post',
	    data:{'id':thisClassifiled.id},
	    dataType:'json',
	    timeout: 3000,  
      	ache: false,    
	  	error: erryFunction,    //错误执行方法    
	  	success: succFunction   //成功执行方法 
	});
    function erryFunction() {  
	    $('#div_info').html('分类删除失败！');
		$('#modal_info').modal('show');	 
	}  
	function succFunction(data) {
		if(data.mark=='1'){
			$('#div_info').html('分类删除成功！');
			$('#modal_info').modal('show');	
		}else{
			$('#div_info').html('分类删除失败！');
			$('#modal_info').modal('show');	
		}
	}
}

function getThisClassifiled(event){
	var e=event||window.event;
	var targetElement=e.target||e.srcElement;
	var thisClassifiled={
		'id':$($(targetElement).parent().parent()[0]).find('input').val(),
		'name':$($(targetElement).parent().parent()[0]).find('span').text()
	};
	return thisClassifiled;
}

$('#updateClassifiled').click(function(){

	$(function(){
		$.ajax({
			url:'dataClassifiedInformation_updateProductClassified.action',
			type:'post',
			data:{'id':$('#updateAreaId').val(),'commodityClassification':$('#updateClassificationName').val()},
		    dataType:'json',
		    timeout: 3000,  
	      	ache: false,     
			error:erryFunction,  //错误执行方法    
		    success:succFunction //成功执行方法 
		});
		function erryFunction() { 
		   	$('#div_info').html('分类名编辑失败！');
			$('#modal_info').modal('show');
	    }  
		function succFunction(data) {	
			if(data.mark=='1'){
				$('#modal_edit').modal('hide');
				$('#div_info').html('分类名编辑成功！');
				$('#modal_info').modal('show');
			}else{
				$('#div_info').html('分类名编辑失败！');
				$('#modal_info').modal('show');
			}
		}
	});
});


$('#btnClose').click(function(){
	$('#modal_info').modal('hide');
});

$('#updateClose').click(function(){
	$('#modal_info').modal('hide');
});

$(function() {
	$('#modal_info').on('hide.bs.modal',function(){
		window.location.href='p_classifiedProduct.html';	
	})
});