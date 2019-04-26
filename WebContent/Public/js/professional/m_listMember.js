'use strict';
jQuery(document).ready(function() {

    init();
    initMemberGrade();

});

var dataJson;
var dataMemberGrade;
function init(){
    $(function(){
        $.ajax({
            url:'dataMemberInformation_getMemberInformation.action',
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
            if(data.length>0){
                dataJson=data;
                for(var i=0;i<data.length;i++){
                    $("#listMember tbody").append('<tr>'+
                            '<td style="display: none"><input type="checkbox" class="no-margin" value=\"'+data[i].id+'\"/></td>'+
                            '<td><span class="name">'+data[i].memberName+'</span></td>'+
                            '<td><span class="name">'+data[i].memberPhone+'</span></td>'+
                            '<td><span class="name">'+data[i].memberGrade+'</span></td>'+
                            '<td><span class="name">'+data[i].memberIntegral+'</span></td>'+
                            '<td><span class="name">'+data[i].accountBalance+'</span></td>'+
                            '<td><span class="name">'+data[i].cumulativeConsumption+'</span></td>'+
                            '<td><span class="name">'+data[i].favorableAmount+'</span></td>'+
                            '<td><span class="name">'+data[i].memberSex+'</span></td>'+
                            '<td><span class="name">'+data[i].memberDateBirth+'</span></td>'+
                            '<td><span class="name">'+data[i].memberOrganization+'</span></td>'+
                            '<td><span class="name">'+data[i].memberSource+'</span></td>'+
                            '<td><span class="name">'+'-'+'</span></td>'+
                            '<td><span class="name">'+data[i].remark+'</span></td>'+
                            '<td><span class="name">'+data[i].createDate.split('T')[0]+'</span></td>'+
                            '<td class="hidden-phone">'+
                            '<a href="#" onclick="editMember(event)" class="btn btn-primary btn-mini"><i class="fa fa-edit" style="font-size:16px"></i>编辑</a>'+
                            '<a href="#" onclick="deleteMember(event)" class="btn btn-warning btn-mini"><i class="fa fa-trash-o" style="font-size:16px"></i>删除</a>'+
                            '<a href="#" onclick="rechargeMember(event)" class="btn btn-success btn-mini"><i class="fa fa-archive" style="font-size:16px"></i>充值</a>'+
                            '<a href="#" onclick="favorableMember(event)" class="btn btn-info btn-mini"><i class="fa fa-briefcase" style="font-size:16px"></i>优惠券</a>'+
                            '</td>'+
                        '</tr>');
                }
            }
        }
    });
};

function initMemberGrade(){
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
            dataMemberGrade=data;
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

$('#memberAvatar').click(function (event) {
    $('#imgInput')[0].click(function (event) {
        event.stopImmediatePropagation();

    });
    event.stopImmediatePropagation();
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
    return false;
});


function editMember(event){
    var thisJson=getJson(event);
    var baseUrl=getRootPath();

    if(thisJson.memberSex=='1'){
        $($("label[for='man']").children()[0]).removeClass().addClass("fa fa-dot-circle-o");
        $($("label[for='woman']").children()[0]).removeClass().addClass("fa fa-circle-o");
    }else if(thisJson.memberSex=='0'){
        $($("label[for='woman']").children()[0]).removeClass().addClass("fa fa-dot-circle-o");
        $($("label[for='man']").children()[0]).removeClass().addClass("fa fa-circle-o");
    }

    $('#memberAvatar').attr("src", baseUrl+'/images/'+thisJson.memberAvatar);
    $('#memberId').val(thisJson.id);
    $('#memberName').val(thisJson.memberName);
    $('#memberPhone').val(thisJson.memberPhone);
    $('#memberDateBirth').val(thisJson.memberDateBirth);
    $('#memberIdnumber').val(thisJson.memberIdnumber);
    $('#memberOrganization').val(thisJson.memberOrganization);
    $('#memberAddress').val(thisJson.memberAddress);
    $('#memberPassword').val(thisJson.memberPassword);
    $('#favorableAmount').val(thisJson.favorableAmount);
    $("#memberGrade").find("option:contains("+thisJson.memberGrade+")").attr("selected",true);
    $('#memberIntegral').val(thisJson.memberIntegral);
    $('#accountBalance').val(thisJson.accountBalance);
    $('#handselBalance').val(thisJson.handselBalance);
    $('#remark').val(thisJson.remark);
    $('#memberModal').modal('show');
}


function deleteMember(event){
    var thisJson=getJson(event);
    $(function(){
        $.ajax({
            url: 'dataMemberInformation_deleteMemberInformation.action',
            type: 'post',
            dataType:'json',
            data:{'id':thisJson.id},
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


$('#rechargeAmount').change(function () {
    $('#RrechargeAmount').text($('#rechargeAmount').val());
});

$('#addRecharge').click(function () {
    var memberData;
    for(var i=0;i<dataJson.length;i++){
        if($('#RmemberId').val()==dataJson[i].id){
            memberData=dataJson[i];
        }
    }

    var rechargeData={
        'memberId':memberData.id,
        'socialCreditCode':memberData.socialCreditCode,
        'storeName':memberData.storeName,
        'memberName':memberData.memberName,
        'memberPhone':memberData.memberPhone,
        'memberIdNumber':memberData.memberIdnumber,
        'rechargeAmount':$('#rechargeAmount').val(),
        'paymentMethod':$('#paymentMethod').val(),
        'remark':$('#Rremark').val()
    };

    $(function(){
        $.ajax({
            url: 'recordMemberRecharge_addRecordMemberRecharge.action',
            type: 'post',
            dataType:'json',
            data:rechargeData,
            timeout: 3000,
            ache: false,
            error: erryFunction,    //错误执行方法
            success: succFunction   //成功执行方法
        });
        function erryFunction(){
            $('#memberRecharge').modal('hide');
            $('#promptContent').html('充值失败！');
            $('#Info_prompt').modal('show');
        }
        function succFunction(data){
            if(data.mark=='1'){
                $('#memberRecharge').modal('hide');
                $('#promptContent').html('充值成功！');
                $('#Info_prompt').modal('show');
            }else{
                $('#memberRecharge').modal('hide');
                $('#promptContent').html('充值失败！');
                $('#Info_prompt').modal('show');
            }
        }
    });


});

function favorableMember(event){

}

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


function getRootPath(){
    var curWwwPath=window.document.location.href;
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    var localhostPaht=curWwwPath.substring(0,pos);
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}


$('#memberAvatar').click(function () {
    $('#imgInput')[0].click(function (event) {
        event.stopImmediatePropagation();
    });
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
    return url;
}


$('label[for="man"]').on('click',function(){
    $($("label[for='man']").children()[0]).removeClass().addClass("fa fa-dot-circle-o");
    $($("label[for='woman']").children()[0]).removeClass().addClass("fa fa-circle-o");
});

$('label[for="woman"]').on('click',function(){
    $($("label[for='woman']").children()[0]).removeClass().addClass("fa fa-dot-circle-o");
    $($("label[for='man']").children()[0]).removeClass().addClass("fa fa-circle-o");
});


$('#memberUpdate').click(function () {
    var memberSex;
    var memberData;
    var man=$($("label[for='man']").children()[0]).attr("class");
    var woman=$($("label[for='woman']").children()[0]).attr("class");
    if(man=='fa fa-dot-circle-o'){
        memberSex='男';
    }else if(woman=='fa fa-dot-circle-o'){
        memberSex='女';
    }
    for(var i=0;i<dataJson.length;i++){
        if($('#memberId').val()==dataJson[i].id){
            memberData=dataJson[i];
        }
    }

    memberData.memberName=$('#memberName').val();
    memberData.memberPhone=$('#memberPhone').val();
    memberData.memberSex=memberSex;
    memberData.memberDateBirth=$('#memberDateBirth').val();
    memberData.memberIdnumber=$('#memberIdnumber').val();
    memberData.memberOrganization=$('#memberOrganization').val();
    memberData.memberAddress=$('#memberAddress').val();
    memberData.memberPassword=$('#memberPassword').val();
    memberData.memberGrade=$('#memberGrade').val();
    memberData.memberIntegral=$('#memberIntegral').val();
    memberData.favorableAmount=$('#favorableAmount').val();
    memberData.memberAvatar=$("#memberAvatar").attr('name');
    memberData.remark=$('#remark').val();

    $(function(){
        $.ajax({
            url: 'dataMemberInformation_updateMemberInformation.action',
            type: 'post',
            dataType:'json',
            data:memberData,
            timeout: 3000,
            ache: false,
            error: erryFunction,    //错误执行方法
            success: succFunction   //成功执行方法
        });
        function erryFunction(){
            $('#memberModal').modal('hide');
            $('#promptContent').html('编辑失败！');
            $('#Info_prompt').modal('show');
        }
        function succFunction(data){
            if(data.mark=='1'){
                $('#memberModal').modal('hide');
                $('#promptContent').html('编辑成功！');
                $('#Info_prompt').modal('show');
            }else{
                $('#memberModal').modal('hide');
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
        window.location.href='m_listMember.html';
    })
});

