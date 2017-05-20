var getHint = function() {
        
            $.ajax({
            type: "GET",
            url: "http://localhost:8080/Sudoku/API/?mode=HINT",
            dataType: "json"

        }).done(function (data, textstatus, jqXHR) {
              $("#" + data.x + "è" + data.y + " p").text(data.nr);
              $("#" + data.x + "è" +data.y + " p").addClass("hintReceived");
              
        }).fail(function (jqXHR, textstatus, errorThrown) {

        });
};

var loadNewPuzzle = function() {
  
    var object = {};
        object.mode = "GET";
        
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
            {
             $("#" + data.x + "è" + data.y + " p").text(data.nr);
             $("#" + data.x + "è" + data.y + " p").addClass("fixed");
            }  
             
             
        }).fail(function (jqXHR, textstatus, errorThrown) {

        });
            }
        } 
    
};


var checkPuzzle = function() {
    
        var object = {};
        object.mode = "CHECK";

        
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
            
            console.log(data);
             
             if (!($("#" + data.x + "è" + data.y + " p").attr("class") === "fixed" || $("#" + data.x + "è" + data.y + " p").attr("class") === "hintReceived" || $("#" + data.x + "è" + data.y + " p").text() < 1) )
             {
                                 
                 if($("#" + data.x + "è" + data.y + " p").text() == data.nr)
                 {
                     $("#" + data.x + "è" + data.y).addClass("correct");
                     $("#" + data.x + "è" + data.y + " p").addClass("fixed");
                 }
                 else
                 {
                     $("#" + data.x + "è" + data.y).addClass("false");
                 }
             }
             
        }).fail(function (jqXHR, textstatus, errorThrown) {

        });
            }
        } 
    
};



$(document).ready(function () {
    console.log("running");
    $(".hint").on('click', getHint);
    $(".check").on('click', checkPuzzle);
    loadNewPuzzle();
});