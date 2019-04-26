'use strict';
jQuery(document).ready(function() {

	init();
    
});
var dataJson;
var editTrJson;
function init(){
	$.ajax({
		url: 'dataSupplierInformation_getSupplierInfor.action',
		type: 'post',
		dataType:'json',
		data:{'socialCreditCode':sessionStorage.getItem("socialCreditCode")},
		timeout: 3000,
		ache: false,
		error: erryFunction,    //错误执行方法
		success: succFunction   //成功执行方法
	});
	function erryFunction() {
		console.log("err");
	}
	function succFunction(data) {
		dataJson=data;
		if(data.length>0){
			for (var i=0;i<data.length;i++) {
				$('#supplierManageList').append(
					'<tr>'+
					'<td><input type="checkbox" class="no-margin" value=\"'+data[i].id+'\"/></td>'+
					'<td><span>'+data[i].supplierName+'</span></td>'+
					'<td><span>'+data[i].supplierContactName+'</span></td>'+
					'<td><span>'+data[i].supplierContactNamber+'</span></td>'+
					'<td><span>'+data[i].remark+'</span></td>'+
					'<td><span>'+data[i].createDate.replace('T',' ')+'</span></td>'+
					'<td>'+
					'<a onclick="editSupplier(event)" href="#" class="btn btn-info btn-mini"><i class="fa fa-pencil-square-o" style="font-size:16px"></i>编辑</a>'+
					'<a onclick="deleteSupplier(event)" href="#" class="btn btn-success btn-mini"><i class="fa fa-trash-o" style="font-size:16px"></i>删除</a>'+
					'</td>'+
					'</tr>'
				);
			}
		}
	}
}


$('#prompt').click(function(){
	$('#supplierModal').modal('show');
});



$('#addSupplierManage').click(function(){
	var id=$('#supplierId').val();
	var data={
		'socialCreditCode':sessionStorage.getItem("socialCreditCode"),
		'storeName':sessionStorage.getItem("storeName"),
		'supplierName':$('#supplierName').val(),
		'supplierCode':$('#supplierCode').val(),
		'supplierContactName':$('#supplierContactName').val(),
		'supplierContactNamber':$('#supplierContactNamber').val(),
		'remark':$('#remark').val()
	};
	if(id==''){
		$.ajax({
			url: 'dataSupplierInformation_addSupplierInfor.action',
			type: 'post',
			dataType:'json',
			data:data,
			timeout: 3000,
			ache: false,
			error: erryFunction,    //错误执行方法
			success: succFunction   //成功执行方法
		});
		function erryFunction() {
			$('#supplierModal').modal('hide');
			$('#promptContent').html('新增供应商失败！');
			$('#Info_prompt').modal('show');
		}
		function succFunction(data) {
			if(data.mark=='1'){
				$('#supplierModal').modal('hide');
				$('#promptContent').html('新增供应商成功！');
				$('#Info_prompt').modal('show');
			}else{
				$('#supplierModal').modal('hide');
				$('#promptContent').html('新增供应商失败！');
				$('#Info_prompt').modal('show');
			}
		}
	}else{
		data.id=editTrJson.id;
		$.ajax({
			url: 'dataSupplierInformation_updateSupplierInfor.action',
			type: 'post',
			dataType:'json',
			data:data,
			timeout: 3000,
			ache: false,
			error: erryFunction,    //错误执行方法
			success: succFunction   //成功执行方法
		});
		function erryFunction() {
			$('#supplierModal').modal('hide');
			$('#promptContent').html('编辑供应商失败！');
			$('#Info_prompt').modal('show');
		}
		function succFunction(data) {
			if(data.mark=='1'){
				$('#supplierModal').modal('hide');
				$('#promptContent').html('编辑供应商成功！');
				$('#Info_prompt').modal('show');
			}else{
				$('#supplierModal').modal('hide');
				$('#promptContent').html('编辑供应商失败！');
				$('#Info_prompt').modal('show');
			}
		}
	}


});

function editSupplier(event){
	var e=event||window.event;
	editTrJson=getTrList(e);
	$('#supplierId').val(editTrJson.id);
	$('#supplierName').val(editTrJson.supplierName);
	$('#supplierCode').val(editTrJson.supplierCode);
	$('#supplierContactName').val(editTrJson.supplierContactName);
	$('#supplierContactNamber').val(editTrJson.supplierContactNamber);
	$('#remark').val(editTrJson.remark);
	$('#supplierModalTitle').replaceWith("编辑供应商信息");

	$('#supplierModal').modal('show');
}

function deleteSupplier(event){
	var deleteTrJson=getTrList(event);
	$.ajax({
		url: 'dataSupplierInformation_deleteSupplierInfor.action',
		type: 'post',
		dataType:'json',
		data:{'id':deleteTrJson.id},
		timeout: 3000,
		ache: false,
		error: erryFunction,    //错误执行方法
		success: succFunction   //成功执行方法
	});
	function erryFunction() {
		$('#promptContent').html('删除供应商失败！');
		$('#Info_prompt').modal('show');
	}
	function succFunction(data) {
		if(data.mark=='1'){
			$('#promptContent').html('删除供应商成功！');
			$('#Info_prompt').modal('show');
		}else{
			$('#promptContent').html('删除供应商失败！');
			$('#Info_prompt').modal('show');
		}
	}
}

function getTrList(event){
	var e=event||window.event;
	var targetElement=e.target||e.srcElement;
	var trElement;
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

$('#query').blur(function () {
	var condition=$('.controls select').val();
	var content=$('#query').val();
	console.log(content);
	if(content!=''){
		$('#supplierManageList').children().remove();
		query(condition,content);
	}
});
$('.controls select').change(function () {
	var condition=$('.controls select').val();
	var content=$('#query').val();
	console.log(content);
	if(content!=''){
		$('#supplierManageList').children().remove();
		query(condition,content);
	}
});

function query(condition,content){
	var resultJson;
	for(var i=0;i<dataJson.length;i++){
		if('supplierName'==condition&&dataJson[i].supplierName==content){
			console.log(dataJson[i]);

			$('#supplierManageList').append(
				'<tr>'+
				'<td><input type="checkbox" class="no-margin" value=\"'+dataJson[i].id+'\"/></td>'+
				'<td><span>'+dataJson[i].supplierName+'</span></td>'+
				'<td><span>'+dataJson[i].supplierContactName+'</span></td>'+
				'<td><span>'+dataJson[i].supplierContactNamber+'</span></td>'+
				'<td><span>'+dataJson[i].remark+'</span></td>'+
				'<td><span>'+dataJson[i].createDate.replace('T',' ')+'</span></td>'+
				'<td>'+
				'<a onclick="editSupplier(event)" href="#" class="btn btn-info btn-mini"><i class="fa fa-pencil-square-o" style="font-size:16px"></i>编辑</a>'+
				'<a onclick="deleteSupplier(event)" href="#" class="btn btn-success btn-mini"><i class="fa fa-trash-o" style="font-size:16px"></i>删除</a>'+
				'</td>'+
				'</tr>'
			);
		}else if('supplierContactNamber'==condition&&dataJson[i].supplierContactNamber==content){
			console.log(dataJson[i]);
			$('#supplierManageList').append(
				'<tr>'+
				'<td><input type="checkbox" class="no-margin" value=\"'+dataJson[i].id+'\"/></td>'+
				'<td><span>'+dataJson[i].supplierName+'</span></td>'+
				'<td><span>'+dataJson[i].supplierContactName+'</span></td>'+
				'<td><span>'+dataJson[i].supplierContactNamber+'</span></td>'+
				'<td><span>'+dataJson[i].remark+'</span></td>'+
				'<td><span>'+dataJson[i].createDate.replace('T',' ')+'</span></td>'+
				'<td>'+
				'<a onclick="editSupplier(event)" href="#" class="btn btn-info btn-mini"><i class="fa fa-pencil-square-o" style="font-size:16px"></i>编辑</a>'+
				'<a onclick="deleteSupplier(event)" href="#" class="btn btn-success btn-mini"><i class="fa fa-trash-o" style="font-size:16px"></i>删除</a>'+
				'</td>'+
				'</tr>'
			);
		}else if('supplierContactName'==condition&&dataJson[i].supplierContactName==content){
			console.log(dataJson[i]);
			$('#supplierManageList').append(
				'<tr>'+
				'<td><input type="checkbox" class="no-margin" value=\"'+dataJson[i].id+'\"/></td>'+
				'<td><span>'+dataJson[i].supplierName+'</span></td>'+
				'<td><span>'+dataJson[i].supplierContactName+'</span></td>'+
				'<td><span>'+dataJson[i].supplierContactNamber+'</span></td>'+
				'<td><span>'+dataJson[i].remark+'</span></td>'+
				'<td><span>'+dataJson[i].createDate.replace('T',' ')+'</span></td>'+
				'<td>'+
				'<a onclick="editSupplier(event)" href="#" class="btn btn-info btn-mini"><i class="fa fa-pencil-square-o" style="font-size:16px"></i>编辑</a>'+
				'<a onclick="deleteSupplier(event)" href="#" class="btn btn-success btn-mini"><i class="fa fa-trash-o" style="font-size:16px"></i>删除</a>'+
				'</td>'+
				'</tr>'
			);
		}
	}
}

$('#btnClose').click(function(){
	$('#Info_prompt').modal('hide');
});

$(function() {
	$('#Info_prompt').on('hide.bs.modal',function() {
		window.location.href='s_supplierManage.html';
	})
});

