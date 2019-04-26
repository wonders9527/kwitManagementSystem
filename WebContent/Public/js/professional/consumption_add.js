'use strict';
jQuery(document).ready(function() {

    getProduct();
    count();
    $('button[for="rmb"]').addClass('btn btn-info');

});



function init(){
    $(function(){
        $('a[data-toggle="tab"]').on('shown.bs.tab',function(e){
            var activeTab = $(e.target).text();
            console.log(activeTab);
            if(activeTab=='商品'){
                getProduct();
            }else if(activeTab=='套餐'){
                getTaocan();
            }
        });
    });
}


var dataJson;
function getProduct(){
    $(function(){
        $.ajax({
            url: 'dataProductInformation_getProductInforLimt.action',
            type: 'post',
            dataType:'json',
            data:{'socialCreditCode':sessionStorage.getItem("socialCreditCode"),'pageSize':20,'pageNumber':1},
            timeout: 3000,
            ache: false,
            error: erryFunction,    //错误执行方法
            success: succFunction   //成功执行方法
        });
        function erryFunction(){
            console.log("error");
        }
        function succFunction(data){
            dataJson=data;
            var baseUrl=getRootPath();
            if(data.length>0) {
                for (var i = 0; i < data.length; i++){
                    var imgArray=data[i].commodityPicture.split(",");
                    $("#pList").append(
                        '<div for="thisP" onclick="operate(event)" class="pList">'+
                        '<input for="thisId" type="hidden" value=\"'+data[i].id+'\">' +
                        '<img src="'+baseUrl+'/images/'+imgArray[0]+'" style="width: 100px;height: 100px;float: left;" alt="占位符">'+
                        '<div style="float: right;width: 100px;" class="caption">'+
                        '<p style="float: left;">'+data[i].commodityName+'</p>'+
                        '<p style="margin-top: 75%;float: right;color: #ac2925">￥'+data[i].commodityPrice+'</p>'+
                        '</div>'+
                        '</div>'
                    );
                }
            }
        }
    });
}


function getRootPath(){
    var curWwwPath=window.document.location.href;
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    var localhostPaht=curWwwPath.substring(0,pos);
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}


function operate(event){
    var jsonList=getTrList(event);
    var consumptionListLength=$('#consumptionList tbody tr').length;
    if(consumptionListLength>0){
        var tdIdArray=new Array();
        var tdQuantityArray=new Array();
        for(var i=0;i<consumptionListLength;i++){
            var tdId=$($('#consumptionList tbody tr')[i].children[0]).text();
            var tdQuantity=$($('#consumptionList tbody tr')[i].children[3].children[0]).val();
            tdIdArray[i]=tdId;
            tdQuantityArray[i]=tdQuantity;
        }
        var tdIdIndex=(tdIdArray).indexOf(''+jsonList.id);
        if(tdIdIndex!=-1){
            $($('#consumptionList tbody tr')[tdIdIndex].children[3].children[0]).val(parseFloat(tdQuantityArray[tdIdIndex])+1);
            $($('#consumptionList tbody tr')[tdIdIndex].children[4]).text((parseFloat(tdQuantityArray[tdIdIndex])+1)*parseFloat(jsonList.commodityPrice));

        }else if(tdIdIndex==-1){
            $("#consumptionList tbody").append(
                '<tr>'+
                '<td  style="display:none;">'+jsonList.id+'</td>'+
                '<td>'+jsonList.commodityName+'</td>'+
                '<td>'+jsonList.commodityPrice+'</td>'+
                '<td><input type="number" min="1" value="1" onchange="quantity(event)"/></td>'+
                '<td>'+(parseFloat(jsonList.commodityPrice*1))+'</td>'+
                '<td>'+
                '<a onclick="deleteConsumption(event)" href="#" class="btn btn-success btn-mini"><i class="fa fa-trash-o" style="font-size:16px"></i></a>'+
                '</td>'+
                '</tr>'
            );
        }
    }else{
        $("#consumptionList tbody").append(
            '<tr>'+
            '<td  style="display:none;">'+jsonList.id+'</td>'+
            '<td>'+jsonList.commodityName+'</td>'+
            '<td>'+jsonList.commodityPrice+'</td>'+
            '<td><input type="number" min="1" value="1" onchange="quantity(event)"/></td>'+
            '<td>'+parseFloat(jsonList.commodityPrice*1)+'</td>'+
            '<td>'+
            '<a onclick="deleteConsumption(event)" href="#" class="btn btn-success btn-mini"><i class="fa fa-trash-o" style="font-size:16px"></i></a>'+
            '</td>'+
            '</tr>'
        );
    }
    count();
};


var add = (function () {
    var counter = 0;
    return function () {return counter += 1;}
})();


function quantity(event){
    var e=event||window.event;
    var targetElement=e.target||e.srcElement;
    var tdList=$(targetElement).parent().parent()[0].children;
    var thisPrice=parseFloat($(tdList[2]).text());
    var thisQuantity=parseFloat($(tdList[3].children[0]).val());
    $(tdList[4]).text(thisPrice*thisQuantity);
    count();
}

function getTrList(event){
    var e=event||window.event;
    var targetElement=e.target||e.srcElement;
    var thisId;
    var thisJson;
    thisId=$($(targetElement).siblings("input")[0]).val();
    for(var i=0;i<dataJson.length;i++){
        if(thisId==dataJson[i].id){
            thisJson=dataJson[i];
        }
    }
    return thisJson;
}

function count(){
    var trList=$('#consumptionList tbody').children();
    var trListlength=trList.length;
    var i=0;
    var quantity=0;
    var amount=0;
    if(trListlength>0){
        while (i<trListlength) {
            quantity=parseFloat($(trList[i].children[3].children[0]).val())+quantity;
            amount=parseFloat($(trList[i].children[4]).text())+amount;
            $('#quantity').text(quantity);
            $('#consumptionBeforeAmount').text(amount);
            $('#consumptionAmount').text(amount-parseFloat($('#discountedPrice').text()));
            i++;
        }
    }else{
        $('#quantity').text(0);
        $('#consumptionBeforeAmount').text(0);
        $('#consumptionAmount').text(0);
    }

}

function deleteConsumption(event){
    var e=event||window.event;
    var targetElement=e.target||e.srcElement;
    $(targetElement).parents("tr").remove();
    count();
}


$('#empty').click(function () {
    $('#customerName').val(null);
    $('#customerPhone').val(null);
});


function settlement(){
    $('#modalTotal').val($('#consumptionBeforeAmount').text());
    $('#modalPreferential').val($('#discountedPrice').text());
    $('#modalPay').val($('#consumptionAmount').text());
    $('#settlement').modal('show');
}

function payMent(){
    $('#modalSmallChange').val(parseFloat($('#ModalPayment').val())-parseFloat($('#modalPay').val())-parseFloat($('#modalWipeZero').val()));
}

$('#payMeth button').click(function(){
    var thisFOr=$(this).attr('for');
    deleteClass();
    var contentLength=$('#payContent').children().length;
    switch (thisFOr) {
        case 'rmb':
            $(this).addClass('btn btn-info');
            if(contentLength>1){
                $($('#payContent').children()[0]).remove();
            }
            break;
        case 'wechat':$(this).addClass('btn btn-info');
            if (contentLength<2) {
                $('#payContent').prepend(
                    '<div class="control-group">'+
                    '<label class="control-label" for="paymentAccount">支付码</label>'+
                    '<div class="controls">'+
                    '<input rows="5" id="paymentAccount" class="input-block-level" style="display: inline-block"/>'+
                    '</div>'+
                    '</div>'
                );
            };
            break;
        case 'alipay':$(this).addClass('btn btn-info');
            if (contentLength<2) {
                $('#payContent').prepend(
                    '<div class="control-group">'+
                    '<label class="control-label" for="paymentAccount">支付码</label>'+
                    '<div class="controls">'+
                    '<input rows="5" id="paymentAccount" class="input-block-level" style="display: inline-block"/>'+
                    '</div>'+
                    '</div>'
                );
            };``
            break;
        case 'card':$(this).addClass('btn btn-info');
            if(contentLength>1){
                $($('#payContent').children()[0]).remove();
            }
            break;
    }
})


function deleteClass() {
    $($('#payMeth').children()[0]).removeClass();
    $($('#payMeth').children()[1]).removeClass();
    $($('#payMeth').children()[2]).removeClass();
    $($('#payMeth').children()[3]).removeClass();
}


$('#addPurchase').click(function () {
    var payment=getPaymentMethod();

    var addJson={
        'socialCreditCode':sessionStorage.getItem("socialCreditCode"),
        'storeName':sessionStorage.getItem("storeName"),
        'consumptionNumber':'编号',
        'department':'部门',
        'operator':sessionStorage.getItem("user"),
        'customerType':'无',
        'customerName':$('#customerName').val(),
        'customerPhone':$('#customerPhone').val(),
        'consumptionAmount':$('#ModalPayment').val(),
        'accountBalance':$('#actualHarvest').text(),
        'paymentMethod':payment[0],
        'paymentAccount':payment[1],
        'refundStatus':$('#otherFee').val(),
        'coupon':'0',
        'consumptionTime':$('#remark').val()
    };
    console.log(addJson);
});


function getPaymentMethod(){
    var a0=$($('#payMeth button')[0]).attr('class');
    var a1=$($('#payMeth button')[1]).attr('class');
    var a2=$($('#payMeth button')[2]).attr('class');
    var a3=$($('#payMeth button')[3]).attr('class');
    var paymentMethod;
    var paymentAccount;
    var payment = new Array();
    if(a0=='btn btn-info active'){
        paymentMethod='0';
        paymentAccount=null;
    }else if(a1=='btn btn-info active'){
        paymentMethod='1';
        paymentAccount=$('#paymentAccount').val();
    }else if(a2=='btn btn-info active'){
        paymentMethod='2';
        paymentAccount=$('#paymentAccount').val();
    }else if(a3=='btn btn-info active'){
        paymentMethod='3';
        paymentAccount=null;
    }
    payment[0]=paymentMethod;
    payment[1]=paymentAccount;
    return payment;
}


$('#memberSearch').click(function () {
    $(function(){
        $.ajax({
            url:'dataMemberInformation_getMemberInformationByPhone.action',
            type:'post',
            dataType:'json',
            data:{'socialCreditCode':sessionStorage.getItem("socialCreditCode"),'memberPhone':$('#memberPhone').val()},
            timeout:3000,
            ache:false,
            error:erryFunction,    //错误执行方法
            success:succFunction   //成功执行方法
        });
        function erryFunction(){
            console.log("error");
        }
        function succFunction(data){
            console.log(data);
            if(data.length>0){
                for(var i=0;i<data.length;i++){
                    $("#memberList").append('<tr>'+
                        '<td><span class="name">'+data[i].memberName+'</span></td>'+
                        '<td><span class="name">'+data[i].memberPhone+'</span></td>'+
                        '<td><span class="name">'+data[i].memberDateBirth+'</span></td>'+
                        '<td><span class="name">'+data[i].memberIntegral+'</span></td>'+
                        '<td><span class="name">'+data[i].accountBalance+'</span></td>'+
                        '<td><span class="name">'+data[i].memberGrade+'%'+'</span></td>'+
                        '<td class="hidden-phone">'+
                        '<a href="#" onclick="rechargeMember(event)" class="btn btn-warning btn-mini"><i class="fa fa-archive" style="font-size:16px"></i>充值</a>'+
                        '<a href="#" onclick="favorableMember(event)" class="btn btn-info btn-mini"><i class="fa fa-hand-o-right" style="font-size:16px"></i>选择</a>'+
                        '</td>'+
                        '</tr>');
                }
            }
        }
    });
});

function rechargeMember(event){
    var thisJson=getJson(event);
    var baseUrl=getRootPath();
    var memberData;
    for(var i=0;i<dataJson.length;i++){
        if(thisJson.id==dataJson[i].id){
            memberData=dataJson[i];
        }
    }
    $('#RmemberId').val(memberData.id);
    $('#RmemberName').text(thisJson.memberName);
    $('#RmemberPhone').text(thisJson.memberPhone);
    $('#RmemberDateBirth').text(thisJson.memberDateBirth);
    $('#memberPicture').attr("src", baseUrl+'/images/'+thisJson.memberAvatar);
    $('#RdiscountProportion').text(memberData.gradeName);
    $('#RmemberIntegral').text(thisJson.memberIntegral);
    $('#RgradeName').text(thisJson.memberGrade+'%');
    $('#handselBalance').text(thisJson.handselBalance);
    $('#RaccountBalance').text(thisJson.accountBalance);
    $('#remark').text(thisJson.remark);
    $('#memberRecharge').modal('show');
};

function getJson(event){
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