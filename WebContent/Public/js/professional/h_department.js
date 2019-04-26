"use strict";
jQuery(document).ready(function() {
	
	initDepartment();
		
});
var dataJson;
function initDepartment(){
	$(function(){
		$.ajax({
			url: 'dataDepartmentInformation_getDepartment.action',
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
	        	dataJson=data;
	    	    for(var i=0;i<data.length;i++){	
					$(".widget-body tbody").append('<tr>'+
					'<td style="display:none">'+data[i].id+'</td>'+
					'<td><input type="checkbox"/></td>'+
					'<td>'+data[i].departmentName+'</td>'+
					'<td>'+
					'<a href="javascript:void(0);" onclick="updateDepartment(event)" class="btn btn-info btn-mini">编辑</a>'+
					'<a href="javascript:void(0);" onclick="deleteDepartment(event)" class="btn btn-success btn-mini">删除</a>'+
					'</td>'+
					'</tr>');	    
			    } 
	        }
	    } 
    });
}



function updateDepartment(event){
	var dataDepartment=getEvent(event);
	$('#updateDepartmentId').val(dataDepartment.id);
	$('#updateDepartmentModal').modal('show');
}

function updateSubmit(){
	$(function(){
		$.ajax({
			url: 'dataDepartmentInformation_updateDepartment.action',
			type: 'post',
			dataType:'json',
			data:{'id':$('#updateDepartmentId').val(),'departmentName':$('#newDepartmentName').val()},
			timeout: 3000,  
	        ache: false,    
	    	error: erryFunction,    //错误执行方法    
	   		success: succFunction   //成功执行方法 
		}); 
	    function erryFunction() {  
	    	$('#updateDepartmentModal').modal('hide'); 
	        $('#div_info').html('修改失败');
			$('#modal_info').modal('show'); 
	    }  
		function succFunction(data) {
			$('#updateDepartmentModal').modal('hide'); 
	        $('#div_info').html(data.result);
			$('#modal_info').modal('show');
	    } 
   });
}

$('#btnClose').click(function(){
	$('#modal_info').modal('hide');
});

$(function() {
	$('#modal_info').on('hide.bs.modal',function() {
		window.location.href='h_department.html';	
	})
});

function deleteDepartment(event){
	var dataDepartment=getEvent(event);
	$(function(){
		$.ajax({
			url: 'dataDepartmentInformation_deleteDepartment.action',
			type: 'post',
			dataType:'json',
			data:{'id':dataDepartment.id},
			timeout: 3000,  
	        ache: false,    
	    	error: erryFunction,    //错误执行方法    
	   		success: succFunction   //成功执行方法 
		}); 
	    function erryFunction() {
	        $('#div_info').html('修改失败');
			$('#modal_info').modal('show'); 
	    }  
		function succFunction(data) {
	        $('#div_info').html(data.result);
			$('#modal_info').modal('show');
	    } 
   });
}

function getEvent(event){
	var e=event||window.event;
	var targetElement=e.target||e.srcElement;
	var tbList=targetElement.parentElement.parentElement.children;
	var id=$(tbList[0]).text();
	var dataReturn;
	for(var i=0;i<dataJson.length;i++){
		if(id==dataJson[i].id){
			dataReturn=dataJson[i];
		}
	}
	return dataReturn;
}

	
    	
$('#addDepartment').on('click',function(){
	var departmentName=$('#departmentName').val();
	if(departmentName==''){
		console.log("部门名称为空")
	}else{
		$.ajax({
		  url: 'dataDepartmentInformation_addDepartment.action',
		  type: 'post',
		  data:{departmentName:$('#departmentName').val()},
		  dataType:'json',
		  timeout: 3000,
		  ache: false,
		  error: erryFunction,    //错误执行方法
		  success: succFunction   //成功执行方法
		});
	    function erryFunction() {  
		    console.log("error");  
		  }  
		function succFunction(data) {
			console.log(data);
			$(".widget-body tbody").append(
				'<tr>'+
					'<td><input type="checkbox" class="no-margin" value='+'/></td>'+
					'<td><span class="name">'+departmentName+'</span></td>'+
					'<td class="hidden-phone">'+
					'<a href="#" id="show" class="btn btn-warning2 btn-mini">详情</a>'+
					'<a href="#" id="update" class="btn btn-info btn-mini">编辑</a>'+
					'<a href="#" id="delete" class="btn btn-success btn-mini">删除</a>'+
					'</td>'+
				'</tr>');
		}
	}
});
		
    
