$(function() {
    $("form").submit(function() {
        $.get("/index/doVipCharge", {
    }, function(result) {
            if(result=="novip"){
                alert("充值成功！");
                window.location.href="/index/toVipCharge";
            }
            else if(result=="您已是vip,请勿重复充值！")
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
