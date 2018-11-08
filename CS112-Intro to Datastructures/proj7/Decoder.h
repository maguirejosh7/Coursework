/* Decoder.cpp - a class used to encode / decode text
* by Joshua Maguire for cs 112 on 4/1/2013
*/
#ifndef DECODER_H_
#define DECODER_H_

#include "Stack.h"
#include <iostream>
#include <fstream>
#include <cstdio>
#include <iostream>
#include <string>
#include <assert.h>

using namespace std;
class Decoder
{
public:
	Decoder(void);
	~Decoder(void);
	void Decode( string inFileName,string outFileName);

private:


};

#endif //DECODER_H_
