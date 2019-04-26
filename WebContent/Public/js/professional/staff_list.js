'use strict';
jQuery(document).ready(function() {


});



function deleteEmployee(event){
    var e=event||window.event;
    var targetElement=e.target||e.srcElement;
    var id=$($(targetElement).parents("tr").children()[0].children[0]).val();
    $(function () {
        $.ajax({
            url: 'dataEmployeeInformation_deleteEmployeeInformation.action',
            type: 'post',
            dataType:'json',
            data:{'id':id},
            timeout: 3000,
            ache: false,
            error: erryFunction,    //错误执行方法
            success: succFunction   //成功执行方法
        });
        function erryFunction() {
            $('#promptContent').html('删除失败！');
            $('#Info_prompt').modal('show');
        }
        function succFunction(data) {
            console.log(data);
            if(data.mark=='1'){
                $('#promptContent').html('删除成功！');
                $('#Info_prompt').modal('show');
            }else{
                $('#promptContent').html('删除失败！');
                $('#Info_prompt').modal('show');
            }
        }
    });
};


$('#btnClose').click(function(){
    $('#Info_prompt').modal('hide');
});

$(function() {
    $('#Info_prompt').on('hide.bs.modal',function() {
        window.location.href='staff_list.html';
    })
});
