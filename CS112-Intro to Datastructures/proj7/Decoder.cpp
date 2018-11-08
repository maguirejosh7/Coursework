/* Decoder.cpp - a class used to encode / decode text
* by Joshua Maguire for cs 112 on 4/1/2013
*/

#include "Decoder.h"

//constructor. because class is at this point so simple, this doesn't do anything.
Decoder::Decoder(void)
{
}

//unneccacarry 
Decoder::~Decoder(void)
{
}

/*decode method.
*parameter: string outFileName, string inFileName -names of txt's to use for getting text(in) and dumping coded text(out)
*post condition: txt red in from inFileName  decoded/encoded and dumped in outputFile.txt
*/

void Decoder::Decode( string inFileName,string outFileName)
{
	ofstream out(outFileName.c_str());
	ifstream in(inFileName.c_str());
	assert(out.is_open());
	assert(in.is_open());

	char nextChar;
	Stack<char> charStack(1);//stack to store words
	while(in.peek() != char_traits<wchar_t>::eof())//while not end of file for linux
//	while(!in.eof()) uncomment this for windows
	{
		nextChar=in.get();//get next char.
		if(isalnum(nextChar))//if ^ is num or letter
		{
			if(charStack.isFull())
			{
				charStack.setCapacity(2*charStack.getCapacity());
			} 
			charStack.push(nextChar);
		}
		
		
		
		else//ellse it's a space or symble and word must be popped followed by nextChar.
		{
			while(!charStack.isEmpty())
			{
				out << charStack.pop();
			}
			out << nextChar;
		}
		
	}
}
