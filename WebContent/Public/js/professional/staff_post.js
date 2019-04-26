'use strict';

jQuery(document).ready(function() {
    init();

});

$('#add_staffPost').click(function(){
    add();
});


function add(){
    var postJson={
        'socialCreditCode':sessionStorage.getItem("socialCreditCode"),
        'storeName':sessionStorage.getItem("storeName"),
        'positionTitle':$('#positionTitle').val(),
        'basicWage':$('#basicWage').val()
    };
    $(function(){
        $.ajax({
            url: 'dataEmployeePosition_addEmployeePosition.action',
            type: 'post',
            dataType:'json',
            data:postJson,
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
}

function init() {
    $(function(){
        $.ajax({
            url: 'dataEmployeePosition_getEmployeePosition.action',
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
                    $("#positionList").append('<tr>'+
                        '<td><input type="checkbox" class="no-margin" value=\"'+data[i].id+'\"/></td>'+
                        '<td><span class="name">'+data[i].positionTitle+'</span></td>'+
                        '<td><span class="name">'+data[i].basicWage+'</span></td>'+
                        '<td class="hidden-phone">'+
                        '<a href="#" onclick="editStaffPost(event)" class="btn btn-info btn-mini"><i class="fa fa-pencil-square-o" style="font-size:16px"></i>编辑</a>'+
                        '<a href="#" onclick="deleteStaffPost(event)" class="btn btn-success btn-mini"><i class="fa fa-trash-o" style="font-size:16px"></i>删除</a>'+
                        '</td>'+
                        '</tr>');
                }
            }
        }
    });
}

function editStaffPost(event){
    var e=event||window.event;
    var targetElement=e.target||e.srcElement;
    var trElement=$(targetElement).parents("tr");
    var id=$(trElement[0].children[0].children[0]).val();
    var updatepositionTitle=$(trElement[0].children[1].children[0]).text();
    var updatebasicWage=$(trElement[0].children[2].children[0]).text();
    $('#editPromptId').val(id);
    $('#updatepositionTitle').val(updatepositionTitle);
    $('#updatebasicWage').val(updatebasicWage);
    $('#update_prompt').modal('show');

}

function deleteStaffPost(event){
    var e=event||window.event;
    var targetElement=e.target||e.srcElement;
    var trElement=$(targetElement).parents("tr");
    var id=$(trElement[0].children[0].children[0]).val();
    $(function(){
        $.ajax({
            url: 'dataEmployeePosition_updateEmployeePosition.action',
            type: 'post',
            dataType:'json',
            data:{'id':id},
            timeout: 3000,
            ache: false,
            error: erryFunction,    //错误执行方法
            success: succFunction   //成功执行方法
        });
        function erryFunction() {
            $('#update_prompt').modal('hide');
            $('#promptContent').html('删除失败！');
            $('#Info_prompt').modal('show');
        }
        function succFunction(data) {
            if(data.mark=='1'){
                $('#update_prompt').modal('hide');
                $('#promptContent').html('删除成功！');
                $('#Info_prompt').modal('show');
            }else{
                $('#update_prompt').modal('hide');
                $('#promptContent').html('删除失败！');
                $('#Info_prompt').modal('show');
            }
        }
    });
}

$('#submitPormpt').click(function(){
    var editJson={
        'socialCreditCode':sessionStorage.getItem("socialCreditCode"),
        'storeName':sessionStorage.getItem("storeName"),
        'id':$('#editPromptId').val(),
        'positionTitle':$('#updatepositionTitle').val(),
        'basicWage':$('#updatebasicWage').val()
    };
    $(function(){
        $.ajax({
            url: 'dataEmployeePosition_updateEmployeePosition.action',
            type: 'post',
            dataType:'json',
            data:editJson,
            timeout: 3000,
            ache: false,
            error: erryFunction,    //错误执行方法
            success: succFunction   //成功执行方法
        });
        function erryFunction() {
            $('#update_prompt').modal('hide');
            $('#promptContent').html('编辑失败！');
            $('#Info_prompt').modal('show');
        }
        function succFunction(data) {
            if(data.mark=='1'){
                $('#update_prompt').modal('hide');
                $('#promptContent').html('编辑成功！');
                $('#Info_prompt').modal('show');
            }else{
                $('#update_prompt').modal('hide');
                $('#promptContent').html('编辑失败！');
                $('#Info_prompt').modal('show');
            }
        }
    });
});


$('button[name="btnClose"]').click(function(){
    $('#Info_prompt').modal('hide');
});

$(function() {
    $('#Info_prompt').on('hide.bs.modal',function() {
        window.location.href='staff_post.html';
    })
});