<?php

function setUserName ($naam){
    if ($naam ==! null){
        setcookie('UserName',$naam);
    }
}