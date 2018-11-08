/*
 * THis is the class that detects palindromes. It works by inserting only the alphanumaric
 * characters into both a stack and a queue. THen, since one is lifo and the other fifo,
 * you can compare a reversed line to a normal line. If they match, then its a palindrome.
 * inFile:name of txt file to detect palindromes
 * outFile:where to dump results. Detected palindromes have a *** after the line
 * by Joshua Maguire on 4/16/2013
 */
#include "Palindrome.h"
//simple constructor. Used if you want to create a Palindrome object
//and only use the isPalindrome method, which doesn't need in or out files/streams.
Palindrome::Palindrome()
{
}
//constructor
//string in: name of txt file to detect palindromes
//string out: name of txt file to dump detected palindromes
Palindrome::Palindrome(string in,string out)
{
	inFile = in;
	outFile = out;
}

//destructor
Palindrome::~Palindrome(void)
{
}

/*
 * method for detecting palindromes from txt file.
 * Using string thisLine, it passes each line of
 * the txt file to the isPalindrome method, which returns
 * a bool. If is palindrome, "***" is printed at the end of
 * the line. Then new line fetched.
 * Postcondition: outFile dumps inFiles contents with *** at end of palindromes
 */
void Palindrome::detectPalindromes()
{
	ifstream in(inFile.c_str());
	ofstream out(outFile.c_str());
	assert(out.is_open());
	assert(in.is_open());
	string thisLine;
	while(!in.eof())
	{
		getline(in,thisLine);
		out << thisLine<<flush;
		if(isPalindrome(thisLine))
		{
			out << "***"<<flush;
		}
		out  << endl;
	}

}
/*
 * isPalindrome
 * Args: string line: string of chars, can be spaces or symbols.
 * postcondition:returns bool
 */
bool Palindrome::isPalindrome(string line)
{
	Stack<char> s1(1);
	ArrayQueue<char> q1(1);
	char charA;
	char charB;
	for(unsigned i = 0; i < line.size();i++)		//filling stack and queue
	{
		charA=line[i];
		if(isalnum(charA))
		{
			charA=tolower(charA);//lowercase
			try							//pushing line to stack...
			{
				s1.push(charA);
			}catch (StackException se)
			{
				s1.setCapacity(2*s1.getCapacity());
				s1.push(charA);
			}
			// line pushed to stack.
			try							//appending line to queue
			{
				q1.append(charA);
			}catch (FullQueueException fqe)
			{
				q1.setCapacity(q1.getCapacity()*2);
				q1.append(charA);
			}							//line appended to queue
		}													
	}	
											//stack and queue filled
	if(s1.isEmpty()){return false;}
	for(unsigned i = 0;i<q1.getSize();i++)//comparing
	{
		charA=q1.remove();
		charB=s1.pop();
		if(charB!=charA){return false;}
	}
	return true;
}
