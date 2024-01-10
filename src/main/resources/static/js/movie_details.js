function play(video,vip){
        $.get("/index/VipFilm", {
            "vip":vip
        }, function(result) {
            if(result=="needVip"){
                alert("播放该电影需要vip!");
                window.location.href="/index/toVipCharge";
            }
            else if(result=="playFilm")
            {
                window.location.href="/video/"+video;
            }
            else {
                alert(result);
                window.location.href="/index/toLogin";
            }
        });
        return false;
}

