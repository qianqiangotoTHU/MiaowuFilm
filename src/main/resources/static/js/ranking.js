var sortitem = "全部排行";
$(function () {
    var sortbanner = document.querySelector('.sort-banner')
    sortbanner.addEventListener("click", function (event) {
        sortbanner.querySelector('.on').classList.remove('on');
        event.target.parentElement.classList.add("on");
        sortitem = event.target.parentElement.querySelector("span").textContent;
        getMovies();
    })
})

function getMovies() {
    console.log(sortitem);
}