$(function () {
    var searchbtn = document.querySelector('.search-btn')
    searchbtn.addEventListener("click", function () {
        var text = $('input').val();
        search(text)
    })
})

function search(name) {
    //这是搜索函数
    console.log(name)
}