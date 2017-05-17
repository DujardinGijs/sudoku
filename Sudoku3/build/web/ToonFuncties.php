<?php

function ToonIntro() {
?><div id="container">
    <h1>Programmeerproject sudoku 2017</h1>
    <div id="users">De speler is: </div>
<nav>
    <a href="mode.html">Play</a>
    <a href="highscores.html">Highscores</a>
    <a href="info.html">Info</a>
</nav>
<form id="UserInput" method="post" >
    <label for="userName">Wie speelt er?</label>
    <input type="text" name="userName" id="userName" >
    <input type="submit"  name="sub" value="click">
</form>
</div>
    <?php
}