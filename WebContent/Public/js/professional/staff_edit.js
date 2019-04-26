'use strict';
jQuery(document).ready(function() {

    init();

});


function init() {
    var baseUrl=document.URL;

    if(baseUrl.indexOf('staffId')>0){
        if(baseUrl.indexOf('#')>0){
            var staffId=baseUrl.split('staffId')[1].split('=')[1].split('#')[0];
        }else{
            var staffId=baseUrl.split('staffId')[1].split('=')[1];
        }
    }

    $(function () {
        $.ajax({
            url: 'dataEmployeeInformation_getEmployeeInformationById.action',
            type: 'post',
            dataType:'json',
            data:{'id':staffId},
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

                if(data[0].gender=='1'){
                    $($('#gender').children()[0].children[0]).removeClass().addClass("fa fa-dot-circle-o");
                    $($('#gender').children()[1].children[0]).removeClass().addClass("fa fa-circle-o");
                }else if(data[0].gender=='0'){
                    $($('#gender').children()[0].children[0]).removeClass().addClass("fa fa-circle-o");
                    $($('#gender').children()[1].children[0]).removeClass().addClass("fa fa-dot-circle-o");
                }

                if(data[0].marriageStatus=='1'){
                    $($('#marriageStatus').children()[0].children[0]).removeClass().addClass("fa fa-circle-o");
                    $($('#marriageStatus').children()[1].children[0]).removeClass().addClass("fa fa-dot-circle-o");
                }else if(data[0].marriageStatus=='0'){
                    $($('#marriageStatus').children()[0].children[0]).removeClass().addClass("fa fa-dot-circle-o");
                    $($('#marriageStatus').children()[1].children[0]).removeClass().addClass("fa fa-circle-o");
                }

                if(data[0].healthStatus=='1'){
                    $($('#healthStatus').children()[0].children[0]).removeClass().addClass("fa fa-dot-circle-o");
                    $($('#healthStatus').children()[1].children[0]).removeClass().addClass("fa fa-circle-o");
                }else if(data[0].healthStatus=='0'){
                    $($('#healthStatus').children()[0].children[0]).removeClass().addClass("fa fa-circle-o");
                    $($('#healthStatus').children()[1].children[0]).removeClass().addClass("fa fa-dot-circle-o");
                }

                var baseUrl=getBaseURL();

                $('#employeeName').val(data[0].employeeName);
                $('#contactNumber').val(data[0].contactNumber);
                $('#appellation').val(data[0].appellation);
                $('#idNumber').val(data[0].idNumber);
                $('#dateBirth').val(getDateList(data[0].dateBirth));
                $('#height').val(data[0].height);
                $('#politicalStatus').val(data[0].politicalStatus);
                $('#employmentStatus').val(data[0].employmentStatus);
                $('#birthplace').val(data[0].birthplace);
                $('#homeAddress').val(data[0].homeAddress);
                $('#department').val(data[0].department);
                $('#post').val(data[0].post);
                $('#employeePicture').attr('src',baseUrl+data[0].employeePicture);
                $('#healthStatus').val(data[0].healthStatus);
                $('#education').val(data[0].education);
                $('#graduatedTime').val(getDateList(data[0].graduatedTime));
                $('#profession').val(data[0].profession);
                $('#graduatedSchool').val(data[0].graduatedSchool);
                $('#employeeIntroduction').val(data[0].employeeIntroduction);
                $('#remark').val(data[0].remark);
            }
        }
    });
}

function getDateList(date){
    var dateObjet=new Date(date);
    var day = ("0" + dateObjet.getDate()).slice(-2);
    var month = ("0" + (dateObjet.getMonth() + 1)).slice(-2);
    var dateResult = dateObjet.getFullYear()+"-"+(month)+"-"+(day) ;
    return dateResult;
}

function getBaseURL(){
    var url = document.location.toString();
    var relUrl;
    if(url.indexOf("Views") != -1){
        relUrl = url.split("Views")[0]+"images/";
    }
    return relUrl;
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