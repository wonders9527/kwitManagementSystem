'use strict';
jQuery(document).ready(function() {
    initMemberGrade();

});

$('#memberSex label').on('click',function(){
    var labelMan=$(this).parent().children()[0].children;
    var labelWoman=$(this).parent().children()[1].children;
    var labelFor=$(this).attr("for");
    if(labelFor=="man"){
        $(this.children).removeClass().addClass("fa fa-dot-circle-o");
        $(labelWoman).removeClass().addClass("fa fa-circle-o");
    }else if(labelFor=="woman"){
        $(this.children).removeClass().addClass("fa fa-dot-circle-o");
        $(labelMan).removeClass().addClass("fa fa-circle-o");
    }
});

function initMemberGrade(){
    $(function(){
        $.ajax({
            url:'dataMemberGrade_getMemberGrade.action',
            type:'post',
            dataType:'json',
            data:{'socialCreditCode':sessionStorage.getItem("socialCreditCode")},
            timeout:3000,
            ache:false,
            error:erryFunction,    //错误执行方法
            success:succFunction   //成功执行方法
        });
        function erryFunction(){
            console.log("error");
        }
        function succFunction(data){
            if(data.length>0) {
                for (var i = 0; i < data.length; i++){
                    $("#memberGrade").append(
                        '<option value=\"'+data[i].discountProportion+'\">'+data[i].gradeName+'('+data[i].discountProportion+'%)'+'</option>'
                    );
                }
            }
        }
    });
}


$('#memberAvatar').click(function () {
    $('#imgInput')[0].click();
});

$('#imgInput').change(function(){
    var files=$('#imgInput')[0].files[0];
    var formData = new FormData();
    formData.append("upload", files);
    $.ajax({
        url:'dataMemberInformation_uploadPicture.action',
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
        $('#promptContent').html('图片上传失败！');
        $('#Info_prompt').modal('show');
    }
    function succFunction(data) {
        if(data.mark=='1'){
            var newsrc=getObjectURL(files);
            $('#memberAvatar').attr("src", newsrc);
            $('#memberAvatar').attr("name", data.fileName);
            $('#imgInput').attr("name", data.fileName);
        }else{
            $('#promptContent').html('图片上传失败！');
            $('#Info_prompt').modal('show');
        }
    }
});


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


$('#addMember').click(function () {
    var memberSex;
    var man=$($('#memberSex').children()[0].children[0]).attr("class");
    var woman=$($('#memberSex').children()[1].children[0]).attr("class");

    if(man=='fa fa-dot-circle-o'){
        memberSex='男';
    }else if(woman=='fa fa-dot-circle-o'){
        memberSex='女';
    }
    var memberData={
        'socialCreditCode':sessionStorage.getItem("socialCreditCode"),
        'storeName':sessionStorage.getItem("storeName"),
        'memberName':$('#memberName').val(),
        'memberPhone':$('#memberPhone').val(),
        'memberSex':memberSex,
        'memberDateBirth':$('#memberDateBirth').val(),
        'memberIdnumber':$('#memberIdnumber').val(),
        'memberOrganization':$('#memberOrganization').val(),
        'memberAddress':$('#memberAddress').val(),
        'memberPassword':$('#memberPassword').val(),
        'memberGrade':$('#memberGrade').val(),
        'memberIntegral':$('#memberIntegral').val(),
        'memberSource':'',
        'favorableAmount':$('#favorableAmount').val(),
        'accountBalance':'',
        'handselBalance':'',
        'cumulativeConsumption':'',
        'memberAvatar':$("#memberAvatar").attr('name'),
        'remark':$('#remark').val()
    };

    $(function(){
        $.ajax({
            url: 'dataMemberInformation_addMemberInformation.action',
            type: 'post',
            dataType:'json',
            data:memberData,
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
            if(data.mark=='1'){
                $('#promptContent').html('新增成功！');
                $('#Info_prompt').modal('show');
            }else{
                $('#promptContent').html('新增失败！');
                $('#Info_prompt').modal('show');
            }
        }
    });
})



$('#btnClose').click(function(){
    $('#Info_prompt').modal('hide');
});

$(function() {
    $('#Info_prompt').on('hide.bs.modal',function() {
        window.location.href='m_addMember.html';
    })
});

