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

var addNum = function (){
    if(!($(".selected p").attr("class") == "fixed"))
    {
        var id = $(".selected").attr("id");
        var idsplit = id.split("è");
        var x = idsplit[0];
        var y = idsplit[1];
    
        
        var object = {};
            object.mode = "SET";
            object.x = x;
            object.y = y;
            object.nr = $(this).attr("id");
        
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/Sudoku/API/",
            data: object,
            dataType: "json"

        }).done(function (data, textstatus, jqXHR) {
            
            $(".selected p").text(data.nr);            
             
        }).fail(function (jqXHR, textstatus, errorThrown) {

        });
        
        
    }
    
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
    $(".numbers").on('click', addNum);

});