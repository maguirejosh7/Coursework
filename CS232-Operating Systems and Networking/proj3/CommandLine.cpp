	/*
 * CommandLine.cpp
 *
 *  Created on: April 7, 2016
 *  Author: jlm54
 *
 * This class parses a stream into a char** array with argCount number of arguments
 */

#include "CommandLine.h"
#include <stdlib.h>
using namespace std;

 
//constructor takes in stream and parses command line variables (argv & argc)
CommandLine::CommandLine(std::istream& in) {

	argCount = 0;
	argArray = NULL;
	ampersand = false;
	//get input
	string input;
	getline(in, input);
	//Find and remove ampersand, set ampersand bool true
	int searchPos = input.find("&");
	if (searchPos != string::npos)
	{
		cout << "Ampersand found!" << endl;
		ampersand = true;
		input.erase(input.find("&"),2); //not the best way I realize
		cout << input << endl;
	}
	//split string into array by spaces. not best approutch
	int whiteSpaces = 0;
	for(int i = 0; i < input.length(); i++)
	{
		if(input[i] == ' ')
			whiteSpaces++;
	}
	cout << "spaces: " << whiteSpaces << endl;
	//split by words (spaces)
	argArray = (char**) calloc(whiteSpaces+1, sizeof(char));
	// tempArray holds input string as char* array
	char *tempArray = (char*)input.c_str();
	//tokenPtr pointer will point to the token found by strtok
	char *tokenPtr = NULL;
	tokenPtr = strtok(tempArray, " ");
	
	while(tokenPtr != NULL)
	{
		cout << tokenPtr << endl;
		argArray[argCount] = tokenPtr;
		//strtoks consecutive calls find the next token after the first one.
		tokenPtr=strtok(NULL," ");
		argCount++;
	}
	cout << "argCount: " << argCount << endl;
}

CommandLine::~CommandLine() {
	//unsure how to free memory for argArray
	// for(int i = 0;i<argCount;i++)
	// {
		// free(argArray[1]);
	// }
	// free(argArray);
}

//return a pointer to the command portion of the command-line (i.e., argv[0]).
 char* CommandLine::getCommand() const
{
	return argArray[0];
}

//return the number of command-line arguments on the command-line (i.e., argc).
 int CommandLine::getArgCount() const
{
	return argCount;
}

//return a pointer to a char* array, each entry of which points to one 'word' of the command-line (i.e., argv).
 char** CommandLine::getArgVector() const
{
	return argArray;
}

//return a pointer to the ith (zero-relative) command-line 'word' (i.e., argv[i]).
char* CommandLine::getArgVector(int i) const
{
	return argArray[i];
}

//returns true if no ampersand was found
bool CommandLine::noAmpersand() const
{
	return !ampersand;
}