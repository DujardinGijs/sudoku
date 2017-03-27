$(document).ready(function () {
    $(".counter").on('click',tel);
});
var time = 0;
var tel = function () {
    i = window.setInterval(count, 1000);
};

var count = function(){
    time ++;
    var min = parseInt(time/60);
    var sec = time%60;
    min = min < 10?"0" + min:min;
    sec = sec < 10?"0" + sec:sec;
    var result = min + ":" + sec;
    $("#counter").empty();
    $("#counter").html(result);
};