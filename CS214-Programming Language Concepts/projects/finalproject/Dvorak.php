<!-- Dvorak.php
This page/file uses advanced selection to 
convert dvorak letters typed on a qwerty 
keyboard to their equal dvorak letters...
aka it unscrambles letters when a person
forgets to turn on dvorak on a qwerty board.
By Joshua Maguire on 5/15/14 -->


<html>
<head>
	<title>word counter</title>
	<style>
		h1 {font-size:30;}
		h2 {font-size:30;}
	</style>
</head>

<body>
<?php
// $wordsArray = str_word_count($_POST['words'] , 1);
$theArray= str_split($_POST['words']);

foreach ($theArray as $key => $value)
{
	switch ($value)
	{
	case "q": $theArray[$key]="'"; break;#toprow
	case "w": $theArray[$key]=","; break;
	case "e": $theArray[$key]="."; break;
	case "r": $theArray[$key]="p"; break;
	case "t": $theArray[$key]="y"; break;
	case "y": $theArray[$key]="f"; break;
	case "u": $theArray[$key]="g"; break;
	case "i": $theArray[$key]="c"; break;
	case "o": $theArray[$key]="r"; break;
	case "p": $theArray[$key]="l"; break;
	case "[": $theArray[$key]="/"; break;
	case "]": $theArray[$key]="="; break;
	case "a": $theArray[$key]="a"; break;#middlerow
	case "s": $theArray[$key]="o"; break;
	case "d": $theArray[$key]="e"; break;
	case "f": $theArray[$key]="u"; break;
	case "g": $theArray[$key]="i"; break;
	case "h": $theArray[$key]="d"; break;
	case "j": $theArray[$key]="h"; break;
	case "k": $theArray[$key]="t"; break;
	case "l": $theArray[$key]="n"; break;
	case ";": $theArray[$key]="s"; break;
	case "'": $theArray[$key]="-"; break;
	case "z": $theArray[$key]=";"; break;#last row
	case "x": $theArray[$key]="q"; break;
	case "c": $theArray[$key]="j"; break;
	case "v": $theArray[$key]="k"; break;
	case "b": $theArray[$key]="x"; break;
	case "n": $theArray[$key]="b"; break;
	case "m": $theArray[$key]="m"; break;
	case ',': $theArray[$key]="w"; break;
	case ".": $theArray[$key]="v"; break;
	case "/": $theArray[$key]="z"; break;
	case "Q": $theArray[$key]='"'; break;#toprow
	case "W": $theArray[$key]='&lt;'; break; #These characers ('<' and '>') can confuse php since php can be expected to produce html code.
	case "E": $theArray[$key]='&gt;'; break;  ##^^
	case "R": $theArray[$key]="P"; break;
	case "T": $theArray[$key]="Y"; break;
	case "Y": $theArray[$key]="F"; break;
	case "U": $theArray[$key]="G"; break;
	case "I": $theArray[$key]="C"; break;
	case "O": $theArray[$key]="R"; break;
	case "P": $theArray[$key]="L"; break;
	case "{": $theArray[$key]="?"; break;
	case "}": $theArray[$key]="+"; break;
	case "A": $theArray[$key]="A"; break;#middlerow
	case "S": $theArray[$key]="O"; break;
	case "D": $theArray[$key]="E"; break;
	case "F": $theArray[$key]="U"; break;
	case "G": $theArray[$key]="I"; break;
	case "H": $theArray[$key]="D"; break;
	case "J": $theArray[$key]="H"; break;
	case "K": $theArray[$key]="T"; break;
	case "L": $theArray[$key]="N"; break;
	case ":": $theArray[$key]="S"; break;
	case '"': $theArray[$key]="_"; break;
	case "Z": $theArray[$key]=":"; break;#last row
	case "X": $theArray[$key]="Q"; break;
	case "C": $theArray[$key]="J"; break;
	case "V": $theArray[$key]="K"; break;
	case "B": $theArray[$key]="X"; break;
	case "N": $theArray[$key]="B"; break;
	case "M": $theArray[$key]="M"; break;
	case "<": $theArray[$key]="W"; break;
	case ">": $theArray[$key]="V"; break;
	case "?": $theArray[$key]="Z"; break;
	}
	echo $theArray[$key];
}


?>
</body>
</html>