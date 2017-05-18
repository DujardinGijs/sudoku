var getHint = function() {
    
    console.log("reached");
    
    var object = {};
        object.mode ="HINT";
    
        $.ajax({
            type: "GET",
            url: "API/",
            data: object,
            dataType: "json"

        }).done(function (data, textstatus, jqXHR) {
            console.log(data);
            var x = data.x;
            var y = data.y;
            var nr = data.nr;
            console.log("x="+x+"y=" + y +"nr=" +nr);
           
        }).fail(function (jqXHR, textstatus, errorThrown) {

        });
};




$(document).ready(function () {
    console.log("running");
    $(".hint").on('click', getHint);
});