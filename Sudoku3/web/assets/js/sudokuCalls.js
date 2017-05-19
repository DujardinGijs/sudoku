var getHint = function() {
        
            $.ajax({
            type: "GET",
            url: "http://localhost:8080/Sudoku/API/?mode=HINT",
            dataType: "json"

        }).done(function (data, textstatus, jqXHR) {
              $("#" + data.x + data.y + " p").text(data.nr);
        }).fail(function (jqXHR, textstatus, errorThrown) {

        });
};

var loadNewPuzzle = function() {
  
    var object = {};
        object.x = 0;
        object.y = 0;
        object.mode = "GET";
        object.nr = 0;
        
        for (var i = 0; i < 9; i++)
        {
            for (var j = 0; j< 9; j++)
            {
                object.x = i;
                object.y = j;

            $.ajax({
            type: "GET",
            url: "http://localhost:8080/Sudoku/API/",
            data: object,
            dataType: "json"

        }).done(function (data, textstatus, jqXHR) {
            if(data.nr > 0)
             $("#" + data.x + data.y + " p").text(data.nr);
             
             
        }).fail(function (jqXHR, textstatus, errorThrown) {

        });
            }
        } 
    
};




$(document).ready(function () {
    console.log("running");
    $(".hint").on('click', getHint);
    $(".next").on('click', loadNewPuzzle);
});