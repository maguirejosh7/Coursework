/*
 * Console.h
 *
 *  Created on: Feb 9, 2013
 *      Author: jlm54
 */

#ifndef CONSOLE_H_
#define CONSOLE_H_
#include <iostream>
#include "MovieCollection.h"
#include "Movie.h"
#include <stdlib.h>//exit(1)
#include <stdio.h>//exit(1)
#include <string>

using namespace std;

class Console {
public:
	Console();
	void runConsole();
	void searchByDirector() ;
	void searchByYear();
	void searchByTitlePhrase();
	void addMovie();
	void removeMovie();
	void saveCollection();
	void printOptions();
	void suprise();


private:
	int choice;
	string director;
	int year;
	string titlePhrase;
	string blankLine;//blank string for cleaning before using getline
	vector<Movie> sv1;//vector used for searching
};

#endif /* CONSOLE_H_ */
