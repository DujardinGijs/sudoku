var time = 0;
var clicked = false;

var tel = function (e) {
    e.preventDefault();
    if(clicked == false) {
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
    var user = $("#userName").val();
    $("#users").append(user);
};

$(document).ready(function () {
    $(".counter").on('click', tel);
    $("#sub").on('click',getName);

});