var time = 0;
var clicked = false;

var tel = function (e) {
    e.preventDefault();
    if(clicked === false) {
        i = window.setInterval(count, 1000);
        clicked = true;
    }
};

var count = function () {

    time++;
    var min = parseInt(time / 60);
    var sec = time % 60;
    min = min < 10 ? "0" + min : min;
    sec = sec < 10 ? "0" + sec : sec;
    var result = "Time: " + min + ":"+ sec;
    $("#counter").empty();
    $("#counter").append(result);
};
var getName = function () {
    var cookie =  document.cookie;
    var preset = "UserName=";
    var user = cookie.slice(preset.length);
    $("#users").append(user);
};

var setName = function (e) {
    e.preventdefault;
    var user = $("#userName").val();
    document.cookie = "UserName="+ user ;
};


var selected = function ()
{
    $(".correct").removeClass("correct");
    $(".false").removeClass("false");
    $(".selected").removeClass("selected");
    $(this).addClass("selected");
};

$(document).ready(function () {
    getName();
    $('#UserInput').on('submit',setName);
    $(".counter").on('click', tel);
    $("#table3x3").on('click', "td td", selected);

});