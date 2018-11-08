/*This program by Joshua Maguire on 10/18/2012 does many things, 
 * most of which do things in some cases including counting words and things.
 */
package edu.calvin.jlm54.lab8;
import java.util.Scanner;
public class TextAnalysis {
	//main
	public static void main(String[] args) {
	//Exercise 8.2
		System.out.print (greenEggsAndHam.length + " words in array. \n\n");
		//Exercise 8.3
		Scanner keyboard = new Scanner(System.in);

	//main code for 8.3
		//green eggs and ham search
		System.out.println("Enter word to search for in green eggs and ham array: ");
		String word = keyboard.nextLine();
		int greenresult = search (greenEggsAndHam, word);
		System.out.println(greenresult);

		//jesus loves me search
		System.out.println("Enter word to search for in jesus loves me array: ");
		String jlMeword = keyboard.nextLine();
		int jlMeresult = search (jesusLovesMe, jlMeword);
		System.out.println(jlMeresult);
		//bla search
		System.out.println("Enter word to search for in blabla array: ");
		String blaWord = keyboard.nextLine();
		int blaResult = search (blaBla, blaWord);
		System.out.println(blaResult);

	//8.4 tests
		System.out.println("searching array for longest and shortest words...");
		//This is the array it will be searching through
		wordLength (blaBla);

	//8.5 tests
		//the array on the left side of the ()'s is the array being searched for stopwords...
		int numstopwords = stopWords(blaBla, stopWords);
		System.out.println("numbers of words excluding stopwords in array: " + numstopwords);

	}
	//search method for Exercise 8.3
	public static int search (String[] list, String word){
		for (int i = 0; i < list.length; i++){
			if (list[i].equals (word)){
				return i;
			}
		}
		return -1;
	}
	/* 8.4 algorithm-use similar method as search method used in last section to search for
	 * longest and shortest words using .length.
	 * 1. create method that recieves an array with 2 for loops. 
	 * 1.5 create bigword and smallword ints and 
	 * 2. first for loop finds biggest word using int i = 0, i < list.length and i++.
	 * 2.5 inside first for loop is an if loop that tests word.length with i.
	 * 		if word is bigger than i, it will set i equal to bigword length.
	 * 3   second for loop with if using less than i and smallword
	 * 4 return big and small results
	 */
	public static void wordLength (String[] list){
		int bigword = Integer.MIN_VALUE;
		int smallword = Integer.MAX_VALUE;
		for (int i = 0; i < list.length; i++){
			if (list[i].length() > bigword){
				bigword = list[i].length();
			}
		}
		System.out.println("the biggest word is: " + bigword);
		for (int i = 0; i < list.length; i++){
			if (list[i].length() < smallword){
				smallword = list[i].length();
			}
		}
		System.out.println("the smallest word is: " + smallword);	}
	/* Algorithm for 8.5
	 * -create method that receives an array and the stop words array.
	 * -for loop with index integer, repeats till at end of list and i++
	 * -that loop will keep array 1 going. make for loop 2 inside for loop 2 to keep track of array 2
	 * -inside loop2, if arrays .equal, att 1 to stop count
	 * -after loops, return words-stopcount
	 */
	public static int stopWords (String list[], String stopwords[]){
		int stopcount = 0;
		for (int i = 0; i < list.length; i++){
			for (int ii=0; ii<stopwords.length;ii++){
				if (list[i].equals (stopwords[ii])){
					stopcount ++;
				}
			}
		}
		return list.length - stopcount;
	}



	//ARRAYS-----------------
	// This array includes all the words for Green Eggs and Ham, in order.	
	public static final String[] greenEggsAndHam = { "i", "am", "sam", "sam", "i", "am", "that",
		"sam-i-am", "that", "sam-i-am", "i", "do", "not", "like", "that", "sam-i-am", "do",
		"you", "like", "green", "eggs", "and", "ham", "i", "do", "not", "like", "them",
		"sam-i-am", "i", "do", "not", "like", "green", "eggs", "and", "ham", "would", "you",
		"like", "them", "here", "or", "there", "i", "would", "not", "like", "them", "here",
		"or", "there", "i", "would", "not", "like", "them", "anywhere", "i", "do", "not",
		"like", "green", "eggs", "and", "ham", "i", "do", "not", "like", "them", "sam-i-am",
		"would", "you", "like", "them", "in", "a", "house", "would", "you", "like", "them",
		"with", "a", "mouse", "i", "do", "not", "like", "them", "in", "a", "house", "i", "do",
		"not", "like", "them", "with", "a", "mouse", "i", "do", "not", "like", "them", "here",
		"or", "there", "i", "do", "not", "like", "them", "anywhere", "i", "do", "not", "like",
		"green", "eggs", "and", "ham", "i", "do", "not", "like", "them", "sam-i-am", "would",
		"you", "eat", "them", "in", "a", "box", "would", "you", "eat", "them", "with", "a",
		"fox", "not", "in", "a", "box", "not", "with", "a", "fox", "not", "in", "a", "house",
		"not", "with", "a", "mouse", "i", "would", "not", "eat", "them", "here", "or", "there",
		"i", "would", "not", "eat", "them", "anywhere", "i", "would", "not", "eat", "green",
		"eggs", "and", "ham", "i", "do", "not", "like", "them", "sam-i-am", "would", "you",
		"could", "you", "in", "a", "car", "eat", "them", "eat", "them", "here", "they", "are",
		"i", "would", "not", "could", "not", "in", "a", "car", "you", "may", "like", "them",
		"you", "will", "see", "you", "may", "like", "them", "in", "a", "tree", "not", "in",
		"a", "tree", "i", "would", "not", "could", "not", "in", "a", "tree", "not", "in", "a",
		"car", "you", "let", "me", "be", "i", "do", "not", "like", "them", "in", "a", "box",
		"i", "do", "not", "like", "them", "with", "a", "fox", "i", "do", "not", "like", "them",
		"in", "a", "house", "i", "do", "not", "like", "them", "with", "a", "mouse", "i", "do",
		"not", "like", "them", "here", "or", "there", "i", "do", "not", "like", "them",
		"anywhere", "i", "do", "not", "like", "green", "eggs", "and", "ham", "i", "do", "not",
		"like", "them", "sam-i-am", "a", "train", "a", "train", "a", "train", "a", "train",
		"could", "you", "would", "you", "on", "a", "train", "not", "on", "a", "train", "not",
		"in", "a", "tree", "not", "in", "a", "car", "sam", "let", "me", "be", "i", "would",
		"not", "could", "not", "in", "a", "box", "i", "could", "not", "would", "not", "with",
		"a", "fox", "i", "will", "not", "eat", "them", "with", "a", "mouse", "i", "will",
		"not", "eat", "them", "in", "a", "house", "i", "will", "not", "eat", "them", "here",
		"or", "there", "i", "will", "not", "eat", "them", "anywhere", "i", "do", "not", "like",
		"them", "sam-i-am", "say", "in", "the", "dark", "here", "in", "the", "dark", "would",
		"you", "could", "you", "in", "the", "dark", "i", "would", "not", "could", "not", "in",
		"the", "dark", "would", "you", "could", "you", "in", "the", "rain", "i", "would",
		"not", "could", "not", "in", "the", "rain", "not", "in", "the", "dark", "not", "on",
		"a", "train", "not", "in", "a", "car", "not", "in", "a", "tree", "i", "do", "not",
		"like", "them", "sam", "you", "see", "not", "in", "a", "house", "not", "in", "a",
		"box", "not", "with", "a", "mouse", "not", "with", "a", "fox", "i", "will", "not",
		"eat", "them", "here", "or", "there", "i", "do", "not", "like", "them", "anywhere",
		"you", "do", "not", "like", "green", "eggs", "and", "ham", "i", "do", "not", "like",
		"them", "sam-i-am", "could", "you", "would", "you", "with", "a", "goat", "i", "would",
		"not", "could", "not", "with", "a", "goat", "would", "you", "could", "you", "on", "a",
		"boat", "i", "could", "not", "would", "not", "on", "a", "boat", "i", "will", "not",
		"will", "not", "with", "a", "goat", "i", "will", "not", "eat", "them", "in", "the",
		"rain", "i", "will", "not", "eat", "them", "on", "a", "train", "not", "in", "the",
		"dark", "not", "in", "a", "tree", "not", "in", "a", "car", "you", "let", "me", "be",
		"i", "do", "not", "like", "them", "in", "a", "box", "i", "do", "not", "like", "them",
		"with", "a", "fox", "i", "will", "not", "eat", "them", "in", "a", "house", "i", "do",
		"not", "like", "them", "with", "a", "mouse", "i", "do", "not", "like", "them", "here",
		"or", "there", "i", "do", "not", "like", "them", "anywhere", "i", "do", "not", "like",
		"green", "eggs", "and", "ham", "i", "do", "not", "like", "them", "sam-i-am", "you",
		"do", "not", "like", "them", "so", "you", "say", "try", "them", "try", "them", "and",
		"you", "may", "try", "them", "and", "you", "may", "i", "say", "sam", "if", "you",
		"will", "let", "me", "be", "i", "will", "try", "them", "you", "will", "see", "say",
		"i", "like", "green", "eggs", "and", "ham", "i", "do", "i", "like", "them", "sam-i-am",
		"and", "i", "would", "eat", "them", "in", "a", "boat", "and", "i", "would", "eat",
		"them", "with", "a", "goat", "and", "i", "will", "eat", "them", "in", "the", "rain",
		"and", "in", "the", "dark", "and", "on", "a", "train", "and", "in", "a", "car", "and",
		"in", "a", "tree", "they", "are", "so", "good", "so", "good", "you", "see", "so", "i",
		"will", "eat", "them", "in", "a", "box", "and", "i", "will", "eat", "them", "with",
		"a", "fox", "and", "i", "will", "eat", "them", "in", "a", "house", "and", "i", "will",
		"eat", "them", "with", "a", "mouse", "and", "i", "will", "eat", "them", "here", "and",
		"there", "say", "i", "will", "eat", "them", "anywhere", "i", "do", "so", "like",
		"green", "eggs", "and", "ham", "thank", "you", "thank", "you", "sam-i-am" };
	//8.3 arrays
	public static final String[] jesusLovesMe = { "Jesus", "loves", "me", "this", "I", "know", "for", "the", "bible", "tells", "me", "so"};
	public static final String[] blaBla = { "bla", "bler", "duh", "hmm", "blu", "blabla", "blablabla", "ba", "der", "and"};

	// a list of common English stop words
	public static final String[] stopWords = { "a", "able", "about", "across", "after", "all",
		"almost", "also", "am", "among", "an", "and", "any", "are", "as", "at", "be",
		"because", "been", "but", "by", "can", "cannot", "could", "dear", "did", "do", "does",
		"either", "else", "ever", "every", "for", "from", "get", "got", "had", "has", "have",
		"he", "her", "hers", "him", "his", "how", "however", "i", "if", "in", "into", "is",
		"it", "its", "just", "least", "let", "like", "likely", "may", "me", "might", "most",
		"must", "my", "neither", "no", "nor", "not", "of", "off", "often", "on", "only", "or",
		"other", "our", "own", "rather", "said", "say", "says", "she", "should", "since", "so",
		"some", "than", "that", "the", "their", "them", "then", "there", "these", "they",
		"this", "tis", "to", "too", "twas", "us", "wants", "was", "we", "were", "what", "when",
		"where", "which", "while", "who", "whom", "why", "will", "with", "would", "yet", "you",
	"your" };
}




