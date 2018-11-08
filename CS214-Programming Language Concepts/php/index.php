<!-- index.php
This is the homepage / default page.
It uses no php, however it does send
other pages / files data. 
Because my project was on php, not html,
I did not try to bedazzle it.
By Joshua Maguire on 5/15/14 -->
<html>
<head>
	<style>
		h1 {color:blue;font-size:40;}
		h2 {color:purple;font-size:20;}
	</style>
	<title>Home</title>
	<h1>My Home Page</h1>
</head>
<body>

<br>


<div>
	<form action="wordcounter.php" method="post"> <!-- the "post" method allows us to send data to the next page in an array using "$_POST['words']".-->
		<h2> Text Tool</h2>
		<!-- this next line is the text box. placeholder puts grey text in the box when its empty, autofocus puts the cursor
			 in the box. -->
		<textarea rows="8"cols="40"placeholder="Enter words here"name="words"autofocus="autofocus"></textarea>
		<br>
		<!-- these next two lines are buttons. The first activates the previous action...taking you to wordcounter.php.
			 The second line overrides the default action with Dvorak.php. -->
		<input type="submit"value="Count!">
		<input type="submit"value="Dvorak!"formaction="Dvorak.php">
	</form>
</div>

</body>
</html>