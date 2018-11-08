<!-- wordCounter.php
This page is used to display info about the words entered
both here or at the index page using "$_POST['words']". This
is done via the "post" method talked about in index.php.
!!To change to case sensitive, comment out line 46!!
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

<!-- this next section is just like the section on index.php except the button just refreshes the current page.-->
<div>
	<form action="wordcounter.php" method="post">
		<h2>Word Counter</h2>
		<textarea rows="8"cols="40"placeholder="Enter words here"name="words"autofocus="autofocus"></textarea>
		<br>
		<input type="submit">
	</form>
</div>

<div>
	<a href="index.php"> Back </a>
</div>

<h1> <u>Words:</u> <?php echo str_word_count($_POST['words']) ?> </h1>
<br>
<div>

<?php


require 'WordItem.php';

## str_word_count( string, format 1) converts $_POST['words'] (a large string) into an array of the words.
$wordsArray = str_word_count($_POST['words'] , 1);


##comment this line out for case sensitivity
$wordsArray = array_map('strtolower',$wordsArray);


##This loop prints each word seperated by commas.
foreach($wordsArray as $key => $value)
{
	echo $wordsArray[$key]." ";
}


##############################
##This loop takes the array of words and puts them
## in a new array ($countedWords) of WordItem objects. 
## These objects (WordItem.php) contain a count and
## a word. Transffering the array of words to an array
##of these objects keeps count of and removes duplicates.
##############################
$countedWords = array();
foreach ($wordsArray as $value)
{
	$searchResult = wordSearch($countedWords,$value); #is word already in new array?
	if ($searchResult!=-1) #is it :D
	{#yes
		$countedWords[$searchResult]->incrementCount(); 
	} else
	{#no
		array_push($countedWords, new WordItem($value));
	}
}

echo "<br/>------------------------";

#usort
usort($countedWords, 'wordItemSort');

#usort sort funct
function wordItemSort($itemA, $itemB)
{
	if($itemA->getCount()==$itemB->getCount())
	{
		return strcasecmp( $itemA->getWord() , $itemB->getWord() );
	}else
	{
		return ($itemA < $itemB ? 1 : -1);
	}	
}

#This loop prints the words and theri frequency.
foreach ($countedWords as $key => $value)
{
	echo "<br/>".$countedWords[$key]->printItem();
}


/****************************
**Custom array search function searches
**an array of WordItems for a word. 
**IN: $theArray, array of WordItems to be searched
**IN: $theWord, the word being searched for
**OUT: -1 if not found, key of found item.
*****************************/
function wordSearch($theArray, $theWord)
{
	foreach($theArray as $key => $value)
	{
		if ($theArray[$key]->getWord() == $theWord)#case sensitive version
		{
			return $key;
		}
	}
	return -1;
}
	
?>
</div>

<br>

</body>
</html>