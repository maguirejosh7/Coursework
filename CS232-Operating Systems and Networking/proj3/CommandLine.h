/*
 * CommandLine.h
 *
 *  Created on: April 7, 2016
 *  Author: jlm54
 */
#include <iostream>
#include <string.h>
#ifndef COMMANDLINE_H_
#define COMMANDLINE_H_

class CommandLine {
public:
	CommandLine(std::istream& in);
	virtual ~CommandLine();
	char* getCommand() const;
	int getArgCount() const;
	char** getArgVector() const;
	char* getArgVector(int i) const;
	bool noAmpersand() const;
private:
	char **argArray;
	int argCount;
	bool ampersand;
};

#endif /* COMMANDLINE_H_ */
