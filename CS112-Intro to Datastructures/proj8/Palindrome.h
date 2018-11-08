/*
 * THis is the class that detects palindromes. It works by inserting only the alphanumaric
 * characters into both a stack and a queue. THen, since one is lifo and the other fifo,
 * you can compare a reversed line to a normal line. If they match, then its a palindrome.
 * inFile:name of txt file to detect palindromes
 * outFile:where to dump results. Detected palindromes have a *** after the line
 * by Joshua Maguire on 4/16/2013
 *
 */
#ifndef PALINDROME_H_
#define PALINDROME_H_
#include <iostream>
#include <cassert>
#include <fstream>
#include "Stack.h"
#include "ArrayQueue.h"

using namespace std;

class Palindrome
{
public:
	Palindrome(string in,string out);
	Palindrome(void);
	~Palindrome(void);
	void detectPalindromes();
	bool isPalindrome(string line);
private:
	string inFile;
	string outFile;
};

#endif
