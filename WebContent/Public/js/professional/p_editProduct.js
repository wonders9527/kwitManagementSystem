'use strict';
jQuery(document).ready(function() {

	$('#amount').hide();
	initCommodityClassification();

});



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
		init();
	}
}

function init() {
	var id=getProductId();
	$(function(){
		$.ajax({
			url: 'dataProductInformation_getProductInforById.action',
			type: 'post',
			data:{'id':id},
			dataType:'json',
			timeout: 3000,
			ache: false,
			error: erryFunction,    //错误执行方法
			success: succFunction   //成功执行方法
		});
		function erryFunction() {
			console.log("error");
		}
		function succFunction(data){
			if(data.length>0){
				var initCommodityShelfStatus;
				var initParticipationDiscountStatus;
				var initMallDisplayStatus;
				var initEmployeeCommissionStatus;
				for(var i=0;i<data.length;i++){
					var imgArray=data[i].commodityPicture.split(",");
					var url=getBaseURL();
					if(data[i].commodityShelfStatus=='1'){
						initCommodityShelfStatus='fa fa-dot-circle-o';
					}else if(data[i].commodityShelfStatus=='0'){
						initCommodityShelfStatus='fa fa-circle-o';
					}

					if(data[i].participationDiscountStatus=='1'){
						initParticipationDiscountStatus='fa fa-dot-circle-o';
					}else if(data[i].participationDiscountStatus=='0'){
						initParticipationDiscountStatus='fa fa-circle-o';
					}

					if(data[i].mallDisplayStatus=='1'){
						initMallDisplayStatus='fa fa-dot-circle-o';
					}else if(data[i].mallDisplayStatus=='0'){
						initMallDisplayStatus='fa fa-circle-o';
					}

					if(data[i].employeeCommissionStatus=='1'){
						initEmployeeCommissionStatus='fa fa-dot-circle-o';
						$('#amount').show();
					}else if(data[i].employeeCommissionStatus=='0'){
						initEmployeeCommissionStatus='fa fa-circle-o';
					}

					$($('.imglist').find('img')[0]).attr("src",url+imgArray[0]);
					for(var j=1;j<imgArray.length;j++){
						$('.imglist').append(
							'<li><a href="#" onclick="uploadImg(event)"><img name=\"'+imgArray[j]+'\" src=\"'+url+imgArray[j]+'\"/><input name=\"'+imgArray[j]+'\" type="file"></a></li>'
						);
					}

					$('.imglist').append(
						'<li><a href="#" onclick="uploadImg(event)"><img name="imgInput" src="../Public/img/upload.JPG"/><input name="imgInput" type="file"></a></li>'
					);

					var commodityLabelJson=$.parseJSON(data[i].commodityLabel);
					if(commodityLabelJson.labelOne=='1'){
						$('#commodityLabel label[for="labelOne"]').children().attr("class","fa fa-dot-circle-o");
					}else if(commodityLabelJson.labelOne=='0'){
						$('#commodityLabel label[for="labelOne"]').children().attr("class","fa fa-circle-o");
					}

					if(commodityLabelJson.labelTwo=='1'){
						$('#commodityLabel label[for="labelTwo"]').children().attr("class","fa fa-dot-circle-o");
					}else if(commodityLabelJson.labelTwo=='0'){
						$('#commodityLabel label[for="labelTwo"]').children().attr("class","fa fa-circle-o");
					}

					if(commodityLabelJson.labelThree=='1'){
						$('#commodityLabel label[for="labelThree"]').children().attr("class","fa fa-dot-circle-o");
					}else if(commodityLabelJson.labelThree=='0'){
						$('#commodityLabel label[for="labelThree"]').children().attr("class","fa fa-circle-o");
					}

					$('#editProductId').val(data[i].id);
					initThisClassification(data[i].commodityClassification);
					$('#commodityName').val(data[i].commodityName);
					$('#commodityCode').val(data[i].commodityCode);
					$('#commodityPrice').val(data[i].commodityPrice);
					$('#commodityBarCode').val(data[i].commodityBarCode);
					$('#commoditySpecification').val(data[i].commoditySpecification);
					$('#commoditySpecification').val(data[i].commoditySpecification);
					$('#commodityName').val(data[i].commodityName);
					$('#commodityIntroduction').val(data[i].commodityIntroduction);
					$('#status label[for="commodityShelfStatus"]').children().removeClass();
					$('#status label[for="mallDisplayStatus"]').children().removeClass();
					$('#status label[for="participationDiscountStatus"]').children().removeClass();
					$('#status label[for="employeeCommissionStatus"]').children().removeClass();
					$('#status label[for="commodityShelfStatus"]').children().addClass(initCommodityShelfStatus);
					$('#status label[for="mallDisplayStatus"]').children().addClass(initMallDisplayStatus);
					$('#status label[for="participationDiscountStatus"]').children().addClass(initParticipationDiscountStatus);
					$('#status label[for="employeeCommissionStatus"]').children().addClass(initEmployeeCommissionStatus);
					$('#commissionAmount').val(data[i].commissionAmount);
					$('#commodityLabel').val(data[i].commodityLabel);
					$('#commodityIntroduction').val(data[i].commodityIntroduction);
				}
			}
		}
	});
}


function initThisClassification(thisClassification) {
	var thisOption=$('#commodityClassification').children();
	var indexOption;
	for(var i=0;i<thisOption.length;i++){
		if(thisOption[i].innerText==thisClassification){
			indexOption=thisOption[i].index;
			document.getElementById("commodityClassification")[indexOption].selected=true;
		}
	}
}

function getBaseURL(){
	var url = document.location.toString();
	var relUrl;
	if(url.indexOf("Views") != -1){
		relUrl = url.split("Views")[0]+"images/";
	}
	return relUrl;
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
	if (window.createObjectURL!=undefined) {  // basic
		url = window.createObjectURL(file) ;
	} else if (window.URL!=undefined) {       // mozilla(firefox)
		url = window.URL.createObjectURL(file) ;
	} else if (window.webkitURL!=undefined) { // webkit or chrome
		url = window.webkitURL.createObjectURL(file) ;
	}
	return url ;
}

function getProductId(){
	var url = document.location.toString();
	var productId;
	if(url.indexOf("product") != -1&&url.indexOf("#") != -1){
		productId = url.split("product=")[1].split("#")[0];
	}else if(url.indexOf("product") != -1&&url.indexOf("#") == -1){
		productId = url.split("product=")[1];
	}else if(url.indexOf("product") == -1){
		productId = null;
	}
	return  productId;
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


$(function () {
	$('#updateProduct').click(function(event) {
		var statusList=getStatus();
		var img=getPicture();
		console.log(img);
		var commodityLabel=getCommodityLabel();
		var dataProduct={
			'id':$('#editProductId').val(),
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
				url: 'dataProductInformation_updateProductInfor.action',
				type: 'post',
				dataType:'json',
				data:dataProduct,
				timeout: 3000,
				ache: false,
				error: erryFunction,    //错误执行方法
				success: succFunction   //成功执行方法
			});
			function erryFunction() {
				$('#promptContent').html('编辑失败！');
				$('#Info_prompt').modal('show');
			}
			function succFunction(data) {
				if(data.mark=='1'){
					$('#promptContent').html('编辑成功！');
					$('#Info_prompt').modal('show');
				}else{
					$('#promptContent').html('编辑失败！');
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





