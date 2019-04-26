'use strict';
jQuery(document).ready(function() {

    init();

});


var dataJson;
function init(){
    $(function(){
        $.ajax({
            url: 'dataMemberGrade_getMemberGrade.action',
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
                    $("#memberGradeList tbody").append(
                        '<tr>'+
                        '<td style="display: none"><input type="checkbox" class="no-margin" value=\"'+data[i].id+'\"/></td>'+
                        '<td><span>'+data[i].gradeName+'</span></td>'+
                        '<td><span>'+data[i].discountProportion+'</span></td>'+
                        '<td>'+
                        '<a onclick="editMemberGrade(event)" href="#" class="btn btn-info btn-mini"><i class="fa fa-pencil-square-o" style="font-size:16px"></i>编辑</a>'+
                        '<a onclick="deleteMemberGrade(event)" href="#" class="btn btn-success btn-mini"><i class="fa fa-trash-o" style="font-size:16px"></i>删除</a>'+
                        '</td>'+
                        '</tr>'
                    );
                }
            }
        }
    });
}


$('#addMemberGrade').click(function () {

    var memberGradeData={
        'socialCreditCode':sessionStorage.getItem("socialCreditCode"),
        'storeName':sessionStorage.getItem("storeName"),
        'gradeName':$('#gradeName').val(),
        'discountProportion':$('#discountProportion').val()
    };
    $(function(){
        $.ajax({
            url: 'dataMemberGrade_addMemberGrade.action',
            type: 'post',
            dataType:'json',
            data:memberGradeData,
            timeout: 3000,
            ache: false,
            error: erryFunction,    //错误执行方法
            success: succFunction   //成功执行方法
        });
        function erryFunction(){
            $('#promptContent').html('新增失败！');
            $('#Info_prompt').modal('show');
        }
        function succFunction(data){
            console.log(data);
            if(data.mark=='1'){
                $('#promptContent').html('新增成功！');
                $('#Info_prompt').modal('show');
            }else if(data.mark=='2'){
                $('#promptContent').html('此等级已存在！');
                $('#Info_prompt').modal('show');
            }else{
                $('#promptContent').html('新增失败！');
                $('#Info_prompt').modal('show');
            }
        }
    });
})


function editMemberGrade(event){
    var trJson=getTrList(event);
    $('#editId').val(trJson.id);
    $('#editGradeName').val(trJson.gradeName);
    $("#editDiscountProportion option[value='"+trJson.discountProportion+"']").attr("selected","selected");
    $('#modal_edit').modal('show');
}

function deleteMemberGrade(event){
    var trJson=getTrList(event);
    $(function(){
        $.ajax({
            url: 'dataMemberGrade_deleteMemberGrade.action',
            type: 'post',
            dataType:'json',
            data:{'id':trJson.id},
            timeout: 3000,
            ache: false,
            error: erryFunction,    //错误执行方法
            success: succFunction   //成功执行方法
        });
        function erryFunction(){
            $('#promptContent').html('删除失败！');
            $('#Info_prompt').modal('show');
        }
        function succFunction(data){
            if(data.mark=='1'){
                $('#promptContent').html('删除成功！');
                $('#Info_prompt').modal('show');
            }else{
                $('#promptContent').html('删除失败！');
                $('#Info_prompt').modal('show');
            }
        }
    });
}


$('#updateMemberGarde').click(function(){
    var updateMemberGradeData={
        'id':$('#editId').val(),
        'socialCreditCode':sessionStorage.getItem("socialCreditCode"),
        'storeName':sessionStorage.getItem("storeName"),
        'gradeName':$('#editGradeName').val(),
        'discountProportion':$('#editDiscountProportion').val()
    };
    $(function(){
        $.ajax({
            url: 'dataMemberGrade_updateMemberGrade.action',
            type: 'post',
            dataType:'json',
            data:updateMemberGradeData,
            timeout: 3000,
            ache: false,
            error: erryFunction,    //错误执行方法
            success: succFunction   //成功执行方法
        });
        function erryFunction(){
            $('#modal_edit').modal('hide');
            $('#promptContent').html('编辑失败！');
            $('#Info_prompt').modal('show');
        }
        function succFunction(data){
            if(data.mark=='1'){
                $('#modal_edit').modal('hide');
                $('#promptContent').html('编辑成功！');
                $('#Info_prompt').modal('show');
            }else if(data.mark=='2'){
                $('#modal_edit').modal('hide');
                $('#promptContent').html('此等级已存在！');
                $('#Info_prompt').modal('show');
            }else{
                $('#modal_edit').modal('hide');
                $('#promptContent').html('编辑失败！');
                $('#Info_prompt').modal('show');
            }
        }
    });
});

$('#btnClose').click(function(){
    $('#Info_prompt').modal('hide');
});

$(function() {
    $('#Info_prompt').on('hide.bs.modal',function() {
        window.location.href='m_memberGrade.html';
    })
});


function getTrList(event){
    var e=event||window.event;
    var targetElement=e.target||e.srcElement;
    var thisId=$($(targetElement).parents("tr")[0].children[0].children[0]).val();
    var thisJson;
    for(var i=0;i<dataJson.length;i++){
        if(thisId==dataJson[i].id){
            thisJson=dataJson[i];
        }
    }
    return thisJson;
}






