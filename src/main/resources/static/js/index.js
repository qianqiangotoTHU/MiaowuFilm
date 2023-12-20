var sortitem = "播放数量";
var area = "全部";  //地区默认为全部
var type = "全部";  //类型默认为全部
var gene = "全部";  //电影基因默认为全部
$(function () {
    var areaList = document.querySelector(".area");
    areaList.addEventListener("click", function (event) {
        for (var i of areaList.children)
        {
            i.classList.remove("on");
        }
        event.target.classList.add("on");
        area = event.target.textContent;  //被点击之后就会修改area的值
        getMovies();
    })

    var typeList = document.querySelector(".type");
    typeList.addEventListener("click", function (event) {
        for (var i of typeList.children)
        {
            i.classList.remove("on");
        }
        event.target.classList.add("on");
        type = event.target.textContent;  //被点击之后就会修改type的值
        getMovies();
    })

    var geneList = document.querySelector(".gene");
    geneList.addEventListener("click", function (event) {
        for (var i of geneList.children)
        {
            i.classList.remove("on");
        }
        event.target.classList.add("on");
        gene = event.target.textContent;  //被点击之后就会修改gene的值
        getMovies();
    })

    var sortbanner = document.querySelector('.sort-banner')
    sortbanner.addEventListener("click", function (event) {
        sortbanner.querySelector('.on').classList.remove('on');
        sortbanner.querySelector('.active').classList.remove('active');
        event.target.parentElement.classList.add("on");
        event.target.parentElement.querySelector(".down").classList.add("active");
        sortitem = event.target.parentElement.querySelector("span").textContent;
        getMovies();
    })
})

//获取全部电影接口
function getMovies() {
    console.log(sortitem + ' ' + area + type + gene);
}