$(function () {
    var searchbtn = document.querySelector('.search-btn')
    searchbtn.addEventListener("click", function () {
        var text = $('input').val();
        search(text)
    })
})

function search(name) {
    window.location.href="/actorlist?search="+name;
}