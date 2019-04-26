'use strict';
jQuery(document).ready(function() {
	
	$('#amount').hide();
	$('#specificationEdit').hide();
	
	initCommodityClassification();
    
});

function getRootPath(){
	var curWwwPath=window.document.location.href;
	var pathName=window.document.location.pathname;
	var pos=curWwwPath.indexOf(pathName);
	var localhostPaht=curWwwPath.substring(0,pos);
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	return(localhostPaht+projectName);
}

function uploadImg(event) {
	var e=event||window.event;
	var targetElement=e.target||e.srcElement;
	var inputElement=$(targetElement).siblings("input")[0];

	inputChange(inputElement,targetElement);
}

function inputChange(inputElement,imageElement){
	$(inputElement).click();
	$(function () {
		$(inputElement).change(function(){
			var files=$(inputElement)[0].files[0];
			var formData = new FormData();
			formData.append("upload", files);
			$.ajax({
				url:'dataProductInformation_uploadPicture.action',
				type:'post',
				data:formData,
			    processData: false,
			    contentType: false,
				timeout:1000,  
				cache:false,    
				error:erryFunction,  //错误执行方法    
			    success:succFunction //成功执行方法 
			});
			function erryFunction() { 
			    console.log("err"); 
		    }  
			function succFunction(data) {	
			   if(data.mark=='1'){
				   var newsrc=getObjectURL(files);
				   $(imageElement).attr("src", newsrc);
				   $(imageElement).attr("name", data.fileName);
				   $(inputElement).attr("name", data.fileName);
				   if($('img[name="imgInput"]').length==0&&$('input[name="imgInput"]').length==0){
					   $('.imglist').append(
						   '<li><a href="#" onclick="uploadImg(event)"><img name="imgInput" src="../Public/img/upload.JPG"/><input name="imgInput" type="file"></a></li>'
					   );
				   }
			   }
			}
		});
	});
}
	
	


function getObjectURL(file) {
    var url = null ;
    if (window.createObjectURL!=undefined) { // basic
        url = window.createObjectURL(file) ;
    } else if (window.URL!=undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file) ;
    } else if (window.webkitURL!=undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file) ;
    }
    return url ;
}
	
$('#status label').on('click',function(){
	if($(this.children).attr("class")=='fa fa-circle-o'&&$(this).attr("for")!="employeeCommissionStatus"){
		$(this.children).removeClass("fa fa-circle-o").addClass("fa fa-dot-circle-o");
	}else if($(this.children).attr("class")=='fa fa-dot-circle-o'&&$(this).attr("for")!="employeeCommissionStatus"){
		$(this.children).removeClass("fa fa-dot-circle-o").addClass("fa fa-circle-o");
	}else if($(this.children).attr("class")=='fa fa-circle-o'&&$(this).attr("for")=="employeeCommissionStatus"){
		$(this.children).removeClass("fa fa-circle-o").addClass("fa fa-dot-circle-o");
		$('#amount').show();
	}else if($(this.children).attr("class")=='fa fa-dot-circle-o'&&$(this).attr("for")=="employeeCommissionStatus"){
		$(this.children).removeClass("fa fa-dot-circle-o").addClass("fa fa-circle-o");
		$('#amount').hide();
	}
});

$('#commodityLabel label').on('click',function(){
	if($(this.children).attr("class")=='fa fa-circle-o'){
		$(this.children).removeClass("fa fa-circle-o").addClass("fa fa-dot-circle-o");
	}else if($(this.children).attr("class")=='fa fa-dot-circle-o'){
		$(this.children).removeClass("fa fa-dot-circle-o").addClass("fa fa-circle-o");
	}
});

$('#commoditySpecification label').on('click',function(){	
	var labelYes=$(this).parent().children()[0].children;
	var labelNo=$(this).parent().children()[1].children;
	var labelFor=$(this).attr("for");
	
	if(labelFor=="YES"){
		$('#specificationEdit').show();
		if($(labelYes).attr("class")=='fa fa-circle-o'){
			$(this.children).removeClass("fa fa-circle-o").addClass("fa fa-dot-circle-o");
			$(labelNo).removeClass().addClass("fa fa-circle-o");
		}else if($(labelYes).attr("class")=='fa fa-dot-circle-o'){
			$(this.children).removeClass().addClass("fa fa-dot-circle-o");
			$(labelNo).removeClass().addClass("fa fa-circle-o");
		}
	}else if(labelFor=="NO"){
		$('#specificationEdit').hide();
		if($(labelNo).attr("class")=='fa fa-dot-circle-o'){
			$(this.children).removeClass().addClass("fa fa-dot-circle-o");
			$(labelYes).removeClass().addClass("fa fa-circle-o");
		}else if($(labelNo).attr("class")=='fa fa-circle-o'){
			$(this.children).removeClass().addClass("fa fa-dot-circle-o");
			$(labelYes).removeClass().addClass("fa fa-circle-o");
		}
	}
});
	
	
$(function() {
    $('#addSpecification').click(function () {
		var specificationName = $('#specificationName').val();
		if(specificationName!=''){
			$('#specificationList').append(
		   	   '<a class="btn btn-info bottom-margin" style="margin-left:5px" href="#" id=\"'+specificationName+'\">'+specificationName+'</a>'
		    );
		}	
    });
});
	
	
$(function () {
    $('#addProduct').click(function(event) {
    	var statusList=getStatus();
    	var img=getPicture();
    	console.log(img);
    	var commodityLabel=getCommodityLabel();
    	var dataProduct={
    		'socialCreditCode':sessionStorage.getItem("socialCreditCode"),
    		'storeName':sessionStorage.getItem("storeName"),
    		'commodityClassification':$('#commodityClassification').val(),
    		'commodityName':$('#commodityName').val(),
    		'commodityCode':$('#commodityCode').val(),
    		'commodityPrice':$('#commodityPrice').val(),
    		'commodityBarCode':$('#commodityBarCode').val(),
    		'commoditySpecification':'1',
			'specificationContent':$('#commoditySpecification').val(),
    		'commodityPicture':img.toString(),
    		'commodityIntroduction':$('#commodityIntroduction').val(),
    		'commodityShelfStatus':statusList.commodityShelfStatus,
    		'mallDisplayStatus':statusList.mallDisplayStatus,
    		'participationDiscountStatus':statusList.participationDiscountStatus,
    		'employeeCommissionStatus':statusList.employeeCommissionStatus,
    		'commissionAmount':statusList.commissionAmount,
    		'commodityLabel':JSON.stringify(commodityLabel)
    	};

    	$(function () {
			$.ajax({
				url: 'dataProductInformation_saveProductInfor.action',
				type: 'post',
				dataType:'json',
				data:dataProduct,
				timeout: 3000,
	      		ache: false,
	    		error: erryFunction,    //错误执行方法
	   			success: succFunction   //成功执行方法
			});
			function erryFunction() {
			    $('#promptContent').html('新增失败！');
				$('#Info_prompt').modal('show');
		    }
			function succFunction(data) {
			   if(data.mark=='1'){
			   	$('#promptContent').html('新增成功！');
			   	$('#Info_prompt').modal('show');
			   }else{
				   $('#promptContent').html('新增失败！');
				   $('#Info_prompt').modal('show');
			   }
			}
		});
    });
});

$('#btnClose').click(function(){
	$('#Info_prompt').modal('hide');
});

$(function() {
	$('#Info_prompt').on('hide.bs.modal',function() {
		window.location.href='p_listProduct.html';
	})
});

function getCommodityLabel(){
	if($('#commodityLabel label[for="labelOne"]').children().attr("class")=="fa fa-dot-circle-o"){
		var labelOne='1';	
	}else if($('#commodityLabel label[for="labelOne"]').children().attr("class")=="fa fa-circle-o"){
		var labelOne='0';
	}
	
	if($('#commodityLabel label[for="labelTwo"]').children().attr("class")=="fa fa-dot-circle-o"){
		var labelTwo='1';	
	}else if($('#commodityLabel label[for="labelTwo"]').children().attr("class")=="fa fa-circle-o"){
		var labelTwo='0';
	}
	
	if($('#commodityLabel label[for="labelThree"]').children().attr("class")=="fa fa-dot-circle-o"){
		var labelThree='1';	
	}else if($('#commodityLabel label[for="labelThree"]').children().attr("class")=="fa fa-circle-o"){
		var labelThree='0';
	}
	var commodityJson={
		'labelOne':labelOne,
		'labelTwo':labelTwo,
		'labelThree':labelThree
	};
	return commodityJson;
}

function getPicture(){
	var imglist=$('.imglist').children();
	var imgArray = new Array();
	for(var i=0;i<imglist.length-1;i++){
		imgArray[i]=$(imglist[i]).find('img').attr('name');
	}
	return imgArray;
}

function getSpecification(){
	var specificationEdit=$('#specificationEdit table tbody').children();
	var commoditySpecification;
	var yes=$('#commoditySpecification label[for="YES"]').children().attr('class');
	var no=$('#commoditySpecification label[for="NO"]').children().attr('class');
	if(yes=='fa fa-circle-o'&&no=='fa fa-dot-circle-o'){
		commoditySpecification='0';
	}else if(yes=='fa fa-dot-circle-o'&&no=='fa fa-circle-o'){
		commoditySpecification='1';
	}
	var commodityObject=[];
	var specificationContentArray= new Array();
	var specificationNameArray= new Array();
	var objArray= new Array();
	for(var i=0;i<specificationEdit.length;i++){
		specificationNameArray[i]=$(specificationEdit[i].children[0].children).val();
		var specificationContent=specificationEdit[i].children[1].children;
		for(var j=0;j<specificationContent.length-2;j++){
			specificationContentArray[j]=$(specificationContent[j]).text();
		}
		var commodityJson = '{\"'+specificationNameArray[i]+'\":\"'+specificationContentArray.toString()+'\"}';

		commodityObject.push(eval("("+commodityJson+")"));
	}
	objArray[0]=commoditySpecification;
	objArray[1]=specificationNameArray;
	objArray[2]=commodityObject;
	return objArray;
}

function getStatus(){
	if($('#status label[for="commodityShelfStatus"]').children().attr("class")=="fa fa-dot-circle-o"){
		var commodityShelfStatus='1';	
	}else if($('#status label[for="commodityShelfStatus"]').children().attr("class")=="fa fa-circle-o"){
		var commodityShelfStatus='0';
	}
	
	if($('#status label[for="mallDisplayStatus"]').children().attr("class")=="fa fa-dot-circle-o"){
		var mallDisplayStatus='1';	
	}else if($('#status label[for="mallDisplayStatus"]').children().attr("class")=="fa fa-circle-o"){
		var mallDisplayStatus='0';
	}
	
	if($('#status label[for="participationDiscountStatus"]').children().attr("class")=="fa fa-dot-circle-o"){
		var participationDiscountStatus='1';	
	}else if($('#status label[for="participationDiscountStatus"]').children().attr("class")=="fa fa-circle-o"){
		var participationDiscountStatus='0';
	}
	
	if($('#status label[for="employeeCommissionStatus"]').children().attr("class")=="fa fa-dot-circle-o"){
		var employeeCommissionStatus='1';	
		var commissionAmount=$("#commissionAmount").val();
	}else if($('#status label[for="employeeCommissionStatus"]').children().attr("class")=="fa fa-circle-o"){
		var employeeCommissionStatus='0';
		var commissionAmount=null;
	}
	var statusJson={
		'commodityShelfStatus':commodityShelfStatus,
		'mallDisplayStatus':mallDisplayStatus,
		'participationDiscountStatus':participationDiscountStatus,
		'employeeCommissionStatus':employeeCommissionStatus,
		'commissionAmount':commissionAmount
	};
	return statusJson;
}
	
function initCommodityClassification(){
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
	    console.log("err"); 
    }  
	function succFunction(data) {	
	   if(data.length>0){
	   	for(var i=0;i<data.length;i++){
	   		$('#commodityClassification').append(
	   			'<option value=\"'+data[i].commodityClassification+'\">'+data[i].commodityClassification+'</option>'
	   		);
	   	}
	   }
	}
}

function addSpecification(){
	var specificationName=$("input[name='specificationName']").val();
	var specificationContent=$("input[name='specificationContent']").val();
	$('#specificationEdit table tbody').append(
		'<tr>'+
		'<td><input class="span12"  type="text"/></td>'+
		'<td>'+
		'<input class="span2" type="text"/>'+
		'<a onclick="addSpecificationContent()" href="#" style="margin-left: 0px;" class="btn btn-info btn-mini">'+
		'<i class="fa fa-plus" style="font-size:16px"></i>添加</a>'+
		'</td>'+
		'<td><a href="#" onclick="removeSpecification(event)"><i class="fa fa-minus" style="font-size:18px;margin-top:8px;"></i>删除规则</a></td>'+
		'</tr>'
	);	
}

function addSpecificationContent(event){
	
	var e=event||window.event;
	var targetElement=e.target||e.srcElement;
	var tbElement;
	var trElement;
	
	if(targetElement.localName=='a'){
		tbElement=$(targetElement).parent();
		trElement=$(targetElement).parent().parent();
	}else if(targetElement.localName=='i'){
		tbElement=$(targetElement).parent().parent();
		trElement=$(targetElement).parent().parent().parent();
	}

	var specificationName=$(trElement.children()[0]).find("input").val();
	var specificationContent=$(trElement.children()[1]).find("input").val();
	var result=getSpanList(tbElement,specificationContent);

	if(specificationName==null||specificationName==''||specificationName==undefined){
		$('#promptContent').html("规格名称不能为空！");
		$('#Info_prompt').modal('show');
	}else if(specificationContent==null||specificationContent==''||specificationContent==undefined){
		$('#promptContent').html("规格内容不能为空！");
		$('#Info_prompt').modal('show');
	}else if(result){
		$('#promptContent').html("规格内容已存在！");
		$('#Info_prompt').modal('show');
	}else{
		tbElement.prepend(
			'<span style="margin-right:5px;margin-bottom:5px;" class="label label-info">'+specificationContent+'<a href="#" onclick="removeThis(event)"><i class="fa fa-close"></i></a></span>'
		);
	}
}

function getSpanList(targetElement,specificationContent){
	var spanResult;
	for(var i=0;i<targetElement.children().length-2;i++){
		if(specificationContent==$(targetElement.children()[i]).text()){
			spanResult=specificationContent==$(targetElement.children()[i]).text();
		}
	}
	return spanResult;
}

function removeThis(event){
	var e=event||window.event;
	var targetElement=e.target||e.srcElement;
	$(targetElement).parent().parent()[0].remove();
}

function removeSpecification(event){
	var e=event||window.event;
	var targetElement=e.target||e.srcElement;
	$(targetElement).parent().parent()[0].remove();
}

function cereteSpecificationList(){
	var a=$('#specificationList');
	console.log(a);

}




