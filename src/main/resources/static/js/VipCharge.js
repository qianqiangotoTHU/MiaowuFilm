$(function() {
    $("form").submit(function() {
        $.get("/index/doVipCharge", {
    }, function(result) {
            if(result=="novip"){
                alert(result);
                users.jifen=1; // 将users.jifen()的值设置为1
            }
            else if(result=="isvip")
            {
                alert(result);
            }
            else {
                alert(result);
            }
    });
        return false;
    })
})
