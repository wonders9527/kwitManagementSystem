'use strict';
jQuery(document).ready(function() {

    $(function () {
        $('img').click(function (event) {
            e=event||window.event;
            var targetElement=e.target||e.srcElement;
            var image=targetElement;
            var input=$('input[name='+targetElement.name+']');
            return input.click();
        });
    });

    $(function () {
        $('input').change(function(event){
            e=event||window.event;
            var targetElement=e.target||e.srcElement;
            var input=targetElement;
            var image=$('img[name='+targetElement.name+']');
            var files=targetElement.files[0];
            var formData = new FormData();
            formData.append("upload", files);
            console.log(formData);
            $.ajax({
                url:'dataRechargeInformation_uploadPicture.action',
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
                console.log(data);
                var newsrc=getObjectURL(files);
                image.attr("src", newsrc);
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



    $('.controls label').on('click',function(){
        if($(this).attr("for")=='yes'&&$(this.children).attr("class")=='fa fa-circle-o'){
            $(this.children).removeClass("fa fa-circle-o").addClass("fa fa-dot-circle-o");
            $($('.controls label[for="no"]')[0].children).removeClass("fa fa-dot-circle-o").addClass("fa fa-circle-o");
        }else if($(this).attr("for")=='no'&&$(this.children).attr("class")=='fa fa-circle-o'){
            $(this.children).removeClass("fa fa-circle-o").addClass("fa fa-dot-circle-o");
            $($('.controls label[for="yes"]')[0].children).removeClass("fa fa-dot-circle-o").addClass("fa fa-circle-o");
        }
    });



});


function saveRecharge(){
    var dataJson={
        storeName:$('#storeName').val(),
        storeIndustry:$('#storeIndustry').val(),
        storeAddress:$('#storeAddress').val(),
        contactPeople:$('#contactPeople').val(),
        contactPhone:$('#contactPhone').val(),
        attendantPhone:$('#attendantPhone').val(),
        operateState:getOperateState(),
        storePicture:getStorePicture()
    };

    console.log(dataJson);

};

function getOperateState(){
    if($($('.controls label[for="yes"]')[0].children[0]).attr("class")=="fa fa-dot-circle-o"){
        return "营业";
    }else{
        return "歇业";
    }
    //	console.log($($('.controls label[for="yes"]')[0].children[0]).attr("class"));
    //	console.log($($('.controls label[for="no"]')[0].children[0]).attr("class"));
};

function getStorePicture(){
    var pathArray=new Array($('.imglist li a')[0].children[0].src,$('.imglist li a')[1].children[0].src,$('.imglist li a')[2].children[0].src);
    var filename=new Array();
    for(var i=0;i<pathArray.length;i++){
        if(pathArray[i].indexOf("/")>0&&i<2){
            filename[i]=pathArray[i].substring(pathArray[i].lastIndexOf("/")+1,pathArray[i].length);
        }else if(pathArray[i].indexOf("/")<=0&&i<2){
            filename[i]=pathArray[i];
        }else if(pathArray[i].indexOf("/")>0&&i>=2){
            filename[i]=pathArray[i].substring(pathArray[i].lastIndexOf("/")+1,pathArray[i].length);
        }else if(pathArray[i].indexOf("/")<=0&&i>=2){
            filename[i]=pathArray[i];
        }
    }
    return filename[0]+"&"+filename[1]+"&"+filename[2];
//	var a=storePicture;
//	console.log($('.imglist li a')[0].children.src);
//	console.log($($('.imglist li a')[0].children[0]).src);
//	console.log($('.imglist li a')[0].children[0].attr("src"));

};