$(function() {
    var linkList = document.querySelectorAll(".nav-link");
    for (var link of linkList)
    {
        link.classList.remove("active");
    }

    var pathname = window.location.pathname
    if (pathname === "/index/")
    {
        var nav = document.querySelector('nav');
        nav.classList.add("fixed-top");
        nav.classList.add("bg-opacity-50");
        linkList[0].classList.add('active');
    }
    else if (pathname === "/ranking/")
    {
        linkList[1].classList.add('active');
    }
    else if (pathname === "/actorlist/")
    {
        linkList[2].classList.add('active');
    }
})