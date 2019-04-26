'use strict';
jQuery(document).ready(function() {


});

function uploadImg(event) {
    var e=event||window.event;
    var targetElement=e.target||e.srcElement;
    var inputElement=$(targetElement).siblings("input")[0];
    inputChange(inputElement,targetElement);
}

function inputChange(inputElement,imageElement){
    $(inputElement).click();
    console.log(inputElement);
    $(function () {
        $(inputElement).change(function(){
            var files=$(inputElement)[0].files[0];
            var formData = new FormData();
            formData.append("upload", files);
            $.ajax({
                url:'dataEmployeeInformation_uploadPicture.action',
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
                }
            }
        });
    });
}

$('#gender label').on('click',function(){
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

$('#marriageStatus label').on('click',function(){
    var labelUnmarried=$(this).parent().children()[0].children;
    var labelMarried=$(this).parent().children()[1].children;
    var labelFor=$(this).attr("for");
    if(labelFor=="unmarried"){
        $(this.children).removeClass().addClass("fa fa-dot-circle-o");
        $(labelMarried).removeClass().addClass("fa fa-circle-o");
    }else if(labelFor=="married"){
        $(this.children).removeClass().addClass("fa fa-dot-circle-o");
        $(labelUnmarried).removeClass().addClass("fa fa-circle-o");
    }
});


$('#healthStatus label').on('click',function(){
    var labelHealth=$(this).parent().children()[0].children;
    var labelUnhealthy=$(this).parent().children()[1].children;
    var labelFor=$(this).attr("for");
    if(labelFor=="health"){
        $(this.children).removeClass().addClass("fa fa-dot-circle-o");
        $(labelUnhealthy).removeClass().addClass("fa fa-circle-o");
    }else if(labelFor=="unhealthy"){
        $(this.children).removeClass().addClass("fa fa-dot-circle-o");
        $(labelHealth).removeClass().addClass("fa fa-circle-o");
    }
});



$('#addStaff').click(function(){
    var gender;
    var marriageStatus;
    var healthStatus;
    var man=$($('#gender').children()[0].children[0]).attr("class");
    var woman=$($('#gender').children()[1].children[0]).attr("class");
    if(man=='fa fa-dot-circle-o'){
        gender=1;
    }else if(woman=='fa fa-dot-circle-o'){
        gender=0;
    }

    var unmarried=$($('#marriageStatus').children()[0].children[0]).attr("class");
    var married=$($('#marriageStatus').children()[1].children[0]).attr("class");

    if(married=='fa fa-dot-circle-o'){
        marriageStatus=1;
    }else if(unmarried=='fa fa-dot-circle-o'){
        marriageStatus=0;
    }

    var health=$($('#healthStatus').children()[0].children[0]).attr("class");
    var unhealthy=$($('#healthStatus').children()[1].children[0]).attr("class");

    if(health=='fa fa-dot-circle-o'){
        healthStatus=1;
    }else if(unhealthy=='fa fa-dot-circle-o'){
        healthStatus=0;
    }
    var employeePicture=$("#employeePicture").attr('name');

    console.log(gender);
    console.log(marriageStatus);
    console.log(healthStatus);


    var dataJson={
        'socialCreditCode':sessionStorage.getItem("socialCreditCode"),
        'storeName':sessionStorage.getItem("storeName"),
        'employeeName':$('#employeeName').val(),
        'gender':gender,
        'contactNumber':$('#contactNumber').val(),
        'appellation':$('#appellation').val(),
        'idNumber':$('#idNumber').val(),
        'dateBirth':$('#dateBirth').val(),
        'height':$('#height').val(),
        'politicalStatus':$('#politicalStatus').val(),
        'employmentStatus':$('#employmentStatus').val(),
        'marriageStatus':marriageStatus,
        'birthplace':$('#birthplace').val(),
        'employeePicture':employeePicture,
        'homeAddress':$('#homeAddress').val(),
        'department':$('#department').val(),
        'post':$('#post').val(),
        'healthStatus':healthStatus,
        'education':$('#education').val(),
        'graduatedTime':$('#graduatedTime').val(),
        'profession':$('#profession').val(),
        'graduatedSchool':$('#graduatedSchool').val(),
        'employeeIntroduction':$('#employeeIntroduction').val(),
        'remark':$('#remark').val()
    };
    $(function () {
        $.ajax({
            url: 'dataEmployeeInformation_addEmployeeInformation.action',
            type: 'post',
            dataType:'json',
            data:dataJson,
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