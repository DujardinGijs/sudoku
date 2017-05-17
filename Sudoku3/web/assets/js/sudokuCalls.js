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
            console.log(data)
            
           
        }).fail(function (jqXHR, textstatus, errorThrown) {

        });
};




$(document).ready(function () {
    console.log("running");
    $(".hint").on('click', getHint);
});