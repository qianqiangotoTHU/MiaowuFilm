var sortitem = "全部排行";
$(function () {
    //获取url中的参数
    var url = document.location.toString();
    var queryString = url.split('?')[1] || '';
    var arr = queryString.split('&') || [];
    for(var i = 0; i<arr.length; i++) {
        var keyString = decodeURIComponent(arr[i].split('=')[0]);
        var valueString = decodeURIComponent(arr[i].split('=')[1]);
        if("sort" === keyString) {
            sortitem = valueString;
            if(sortitem==="1") sortitem="全部排行";
            else if(sortitem==="3") sortitem="本周排行";
            else if(sortitem==="4")sortitem="本月排行"
            else if(sortitem==="2") sortitem="好评排行";
        }
    }
    if (sortitem==="") sortitem="全部排行";

    var sortbanner = document.querySelector('.sort-banner')

    sortbanner.addEventListener("click", function (event) {
        for (let i of sortbanner.children) {
            i.classList.remove("on");
        }
        event.target.classList.add("on");
        sortitem = event.target.textContent;
        getMovies();
    })

    // sortbanner.addEventListener("click", function (event) {
    //     event.target.parentElement.classList.add("on");
    //     event.target.parentElement.querySelector(".down").classList.add("active");
    //     sortitem = event.target.parentElement.querySelector("span").textContent;
    //     getMovies();
    // })
})

//获取全部电影接口
function getMovies() {
    console.log(sortitem + ' ');

    if(sortitem==="全部排行") sortitem=1;
    else if(sortitem==="本周排行") sortitem=3;
   else if(sortitem==="本月排行")sortitem=4;
    else if(sortitem==="好评排行")sortitem=2;

    window.location.href="/ranking?&sort="+sortitem;
}