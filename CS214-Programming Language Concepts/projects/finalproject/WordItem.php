<!-- WordItem.php
This class makes an object that allows us to 
better manipulate our words. 
It uses private variables to keep track of 
each word ($myWord) and how many times it
appears ($myCount).
By Joshua Maguire on 5/15/14 -->
<?php
class WordItem
{
	private $myCount;
	private $myWord;
	
	##constructor
	public function __construct($word)
	{
		$this->myWord = $word;
		$this->myCount = 1;
	}
	
	##accessor for $myCount
	public function getCount()
	{
		return $this->myCount;
	}
	
	##accessor for $myWord
	public function getWord()
	{
		return $this->myWord;
	}

	##increments the count of a word
	public function incrementCount()
	{
		++$this->myCount;
	}
	
	##returns the word and its count in a printable fashion.
	public function printItem()
	{
		return $this->myWord." --- ".$this->myCount;
	}
}
?>