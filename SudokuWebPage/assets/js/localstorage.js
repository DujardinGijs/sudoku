/**
 * Created by Gijs on 27/03/2017.
 */
var HighScore = [];
var getHighScore = function () {
    var HighScore = JSON.parse(localStorage.getItem("HighScore"));
};
var saveHighScore = function () {
    localStorage.setItem("HighScore", JSON.stringify(HighScore));
};