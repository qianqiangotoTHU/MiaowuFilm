var sortitem = "播放数量";
var area = "全部";  //地区默认为全部
var type = "全部";  //类型默认为全部
$(function () {
    //获取url中的参数
    var url = document.location.toString();
    var queryString = url.split('?')[1] || '';
    var arr = queryString.split('&') || [];
    for(var i = 0; i<arr.length; i++) {
        var keyString = decodeURIComponent(arr[i].split('=')[0]);
        var valueString = decodeURIComponent(arr[i].split('=')[1]);
        if("region" === keyString) {area = valueString;}
        if("type" === keyString) {type = valueString;}
        if("sort" === keyString) {
            sortitem = valueString;
            if(sortitem==="1") sortitem="播放数量";
            else if(sortitem==="2") sortitem="上映时间";
            else if(sortitem==="3") sortitem="最高评分";
        }
    }
    if (area==="") area="全部";
    if (type==="") type="全部";
    if (sortitem==="") sortitem="播放数量";

    //给“地区”标蓝，以表示目前选项
    var areaList = document.querySelector(".area");
    for (var i of areaList.children)
    {
        if (i.textContent===area) i.classList.add("on")
        else i.classList.remove("on");
    }
    //增加点击事件，改变标蓝的块和相应数据，并刷新页面
    areaList.addEventListener("click", function (event) {
        area = event.target.textContent;  //被点击之后就会修改area的值
        getMovies();
    })

    //给“类型”标蓝，以表示目前选项
    var typeList = document.querySelector(".type");
    for (var i of typeList.children)
    {
        if (i.textContent==type) i.classList.add("on")
        else i.classList.remove("on");
    }
    //增加点击事件，改变标蓝的块和相应数据，并刷新页面
    typeList.addEventListener("click", function (event) {
        type = event.target.textContent;  //被点击之后就会修改type的值
        getMovies();
    })

    var sortbanner = document.querySelector('.sort-banner')
    for (var i of sortbanner.children)
    {
        if(i.querySelector("span").textContent===sortitem) {
            i.classList.add("on");
            i.querySelector('.down').classList.add("active");
        }else
        {
            i.classList.remove("on");
            i.querySelector('.down').classList.remove("active");
        }
    }
    sortbanner.addEventListener("click", function (event) {
        event.target.parentElement.classList.add("on");
        event.target.parentElement.querySelector(".down").classList.add("active");
        sortitem = event.target.parentElement.querySelector("span").textContent;
        getMovies();
    })
})

//获取全部电影接口
function getMovies() {
    console.log(sortitem + ' ' + area + type);
    if (area==="全部") area="";
    if (type==="全部") type="";
    if(sortitem=="播放数量") sortitem=1;
    else if(sortitem=="上映时间") sortitem=2;
    else if(sortitem=="最高评分") sortitem=3;
    window.location.href="/index?region="+area+"&type="+type+"&sort="+sortitem;
}