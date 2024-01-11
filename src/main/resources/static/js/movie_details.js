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

function score(){
    var rating = document.querySelector('input[name="inlineRadioOptions"]:checked').value;
    var movieName = document.querySelector('.MovieName').textContent;
    $.get('/film/score',{
        'score':rating,
        'filmname':movieName
    },function (result){
        if (result=="true"){
            alert("评分成功！");
            window.location.reload();
        }
    })
}

function comment(){
    const input = document.querySelector('#exampleFormControlTextarea1').value;
    var movieName = document.querySelector('.MovieName').textContent;
    $.get('/film/comment',{
        'comment':input,
        'filmname':movieName,
    },function (result){
        if(result=="true"){
            alert("评论成功！");
            window.location.reload();
        }else alert(result);
    })
}