/**
 * Created by Nominal on 2018/3/23 0023.
 * 微博：@李明易DY
 */
$(function () {
    $('#file').click(function () {
        
        //var file =$("#test").files[0];
        alert("123")
        $.ajax(
            {
                url: '/upload',
                type: 'POST',
                data: new FormData($('#uploadForm')[0]),
                contentType: false, //禁止设置请求类型
                processData: false,
                cache: false,
                success: function (result) {
                    //测试是否成功
                    //但需要你后端有返回值
                    alert(result);
                }
            }
        );
    });
});


