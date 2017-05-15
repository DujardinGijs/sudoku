<?php
require_once 'HTMLKop.php';
require_once 'ToonFuncties.php';
require_once 'SessionStorage.php';
if (isset($_COOKIE["UserName"])){
    $naam = $_COOKIE["UserName"];
}else{$naam = "";}

ToonIntro();
if(isset($_POST["sub"])) {
    setUserName($_POST["userName"]);
}

require_once 'HTMLStaart.php';
?>

