'use strict';
jQuery(document).ready(function() {

    init();
    getSupplier();

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
        function erryFunction(){
            console.log("error");
        }
        function succFunction(data){
            dataJson=data;
            if(data.length>0) {
                for (var i = 0; i < data.length; i++){
                    $("#productPur").append(
                        '<tr>'+
                        '<td><a onclick="operate(event)"><input type="checkbox" class="no-margin" value=\"'+data[i].id+'\"/></a></td>' +
                        '<td>'+data[i].commodityClassification+'</td>'+
                        '<td>'+data[i].commodityName+'</td>'+
                        '<td>'+data[i].commoditySpecification+'</td>'+
                        '<td>'+data[i].commodityPrice+'</td>'+
                        '</tr>'
                    );
                }
            }
        }
    });
}

function getSupplier(){
    $(function(){
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
        function erryFunction(){
            console.log("error");
        }
        function succFunction(data){
            if(data.length>0){
                for(var i=0;i<data.length;i++){
                    $('#commodityClassification').append(
                        '<option value=\"'+data[i].supplierCode+'\">'+data[i].supplierContactName+'</option>'
                    );
                }
            }
        }
    });
}

function operate(event){
    var jsonList=getTrList(event);
    $("#purchaesList").append(
        '<tr>'+
        '<td  style="display:none;">'+jsonList.id+'</td>'+
        '<td>'+jsonList.commodityName+'</td>'+
        '<td>'+jsonList.commoditySpecification+'</td>'+
        '<td><input type="text" value="0" onchange="unitPrice(event)"/></td>'+
        '<td><input type="text" value="1" onchange="quantity(event)"/></td>'+
        '<td>0</td>'+
        '<td><input type="text" value="0" onchange="actualHarvest(event)"/></td>'+
        '<td>'+
        '<a onclick="deleteSupplier(event)" href="#" class="btn btn-success btn-mini"><i class="fa fa-trash-o" style="font-size:16px"></i></a>'+
        '</td>'+
        '</tr>'
    );
    var quantity=add();
    $('#quantity').text(quantity);
}

var add = (function (){
    var counter = 0;
    return function () {return counter += 1;}
})();

function unitPrice(event){
    var e=event||window.event;
    var targetElement=e.target||e.srcElement;
    var tdList=$(targetElement).parent().parent()[0].children;
    var thisPrice=parseFloat(tdList[2].children[0].value);
    var thisQuantity=parseFloat(tdList[3].children[0].value);
    var thisTotal=thisPrice*thisQuantity;
    $(tdList[4]).text(thisTotal.toString());
    $(tdList[5].children[0]).val(thisTotal.toString());
    count();
}

function quantity(event){
    var e=event||window.event;
    var targetElement=e.target||e.srcElement;
    var tdList=$(targetElement).parent().parent()[0].children;
    var thisPrice=parseFloat(tdList[2].children[0].value);
    var thisQuantity=parseFloat(tdList[3].children[0].value);
    var thisTotal=thisPrice*thisQuantity;
    $(tdList[4]).text(thisTotal.toString());
    $(tdList[5].children[0]).val(thisTotal.toString());
    count();
}

function actualHarvest(event){
    count();
}

$('#otherFee').change(function () {
    count();
})

function count(){
    var trList=$('#purchaesList').children();
    var trListlength=trList.length;
    var i=0;
    var countTotal=0;
    var countActualHarvest=0;
    while (i<trListlength) {
        countTotal+=parseFloat($(trList[i].children[4]).text().toString());
        console.log(parseFloat($(trList[i].children[5].children[0]).val().toString()));
        countActualHarvest+=parseFloat($(trList[i].children[5].children[0]).val().toString());
        i++;
    }
    $('#total').text(countTotal);
    $('#actualHarvest').text(countActualHarvest+$('#otherFee').val());
}

function getTrList(event){
    var e=event||window.event;
    var targetElement=e.target||e.srcElement;
    var thisJson;
    var id=$(targetElement).val();
    for(var i=0;i<dataJson.length;i++){
        if(id==dataJson[i].id){
            thisJson=dataJson[i];
        }
    }
    return thisJson;
}


$('#addPurchase').click(function () {
    var a=$('#purchaesList')[0].children;
    var i=0;
    var mark='1';
    while (i<a.length&&mark=="1"){
        var addJson={
            'socialCreditCode':sessionStorage.getItem("socialCreditCode"),
            'storeName':sessionStorage.getItem("storeName"),
            'documentNumber':'001',
            'supplierCode':$('#commodityClassification').val(),
            'commodityName':$(a[i].children[1]).text(),
            'unit':'无',
            'unitPrice':$(a[i].children[1]).text(),
            'quantity':$('#quantity').text(),
            'total':$('#total').text(),
            'actualHarvest':$('#actualHarvest').text(),
            'purchaseAmount':$('#total').text(),
            'paymentMethod':$('#paymentMethod').val(),
            'otherFee':$('#otherFee').val(),
            'inboundStatus':'0',
            'remark':$('#remark').val()
        };
        console.log(addJson);
        $.ajax({
            url: 'recordPurchase_addPurchase.action',
            type: 'post',
            dataType:'json',
            data:addJson,
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
        i++;
    }

})