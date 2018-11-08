/*
 * Console.cpp
 * The console class for phils movie collection. Asks for imput and uses switch statement to
 * Determine what to do. Uses classes MovieCollection and Movie.
 *
 *  Created on: Feb 9, 2013
 *      Author: jlm54
 */

#include "Console.h"
MovieCollection pmc("PhilsCollection.txt");//global so that all methods can see it

Console::Console() {
	cout << "\n \n \n \nHello, Patrick! Welcome to Phil's Movie Collection Manager!" << endl;
	printOptions();
	cout << "And remember, Patrick... If you enter a letter, I will defenestrate you \n and flood the console window :D." << endl;
	runConsole();
}

void Console::runConsole(){
	while(true){
		cout << "choice:" << flush;
		cin >> choice;
		if (choice == 1||2||3||4||5||6||7||123||0){
			switch (choice){
			case 0:
				printOptions();
				break;
			case 1:
				searchByDirector();
				break;
			case 2:
				searchByYear();
				break;
			case 3:
				searchByTitlePhrase();
				break;
			case 4:
				addMovie();
				break;
			case 5:
				removeMovie();
				break;
			case 6:
				saveCollection();
				break;
			case 7:
				cout << "Quitter...";
				exit(1);
			case 123:
				suprise();
				break;
			default:
				cout << "I said, enter a number 0 through 7!!!" << endl;
				break;
			}
		}
		else{cout << "please enter a VALID NUMBER next time, Patrick." << endl;}
	}
}
void Console::printOptions(){
	cout << "Please enter:"	 << endl;
	cout << "0 - print options" << endl;
	cout << "1 - to search for movies by director" << endl;
	cout << "2 - to search for movies by year"	 << endl;
	cout << "3 - to search for movies by title phrase"	 << endl;
	cout << "4 - to add a new movie"	 << endl;
	cout << "5 - to remove a movie" << endl;
	cout << "6 - to save movie collection" << endl;
	cout << "123 - for a special suprise..." << endl;
	cout << "7 - to quit"	 << endl;
}
void Console::searchByDirector() {
	cout << "Director name:" << flush;
	//	string director;
	getline(cin,blankLine);
	getline(cin,director);
	cout << "\nResults:" << endl;
	sv1=pmc.searchByDirector(director);
	if (sv1.size()==0) {
		cout << "no results." << endl;
	}
	else{
		for (unsigned i = 0; i < sv1.size(); i++) {
			cout << "--------------------" << endl;
			cout << sv1[i].getTitle() << endl;
			cout << sv1[i].getYear() << endl;
			cout << sv1[i].getDirector() << endl;
			cout << "--------------------" << endl;
		}
		cout << "end of results." << endl;
	}
}
void Console::searchByYear(){
	cout << "Year:" << flush;
	cin >> year;
	sv1=pmc.searchByYear(year);
	if (sv1.size()==0) {
		cout << "no results." << endl;
	}
	else{
		cout << "\nResults:" << endl;
		for (unsigned i = 0; i < sv1.size(); i++) {
			cout << "--------------------" << endl;
			cout << sv1[i].getTitle() << endl;
			cout << sv1[i].getYear() << endl;
			cout << sv1[i].getDirector() << endl;
			cout << "--------------------" << endl;
		}
	}
}
void Console::searchByTitlePhrase(){
	cout << "Title Phrase:" << flush;
	getline(cin,blankLine);
	getline(cin,titlePhrase);
	sv1=pmc.searchByTitlePhrase(titlePhrase);

	if (sv1.size()==0) {
		cout << "no results." << endl;
	}
	else{
		cout << "\nResults:" << endl;
		for (unsigned i = 0; i < sv1.size(); i++) {
			cout << "--------------------" << endl;
			cout << sv1[i].getTitle() << endl;
			cout << sv1[i].getYear() << endl;
			cout << sv1[i].getDirector() << endl;
			cout << "--------------------" << endl;
		}
		cout << "end of results." << endl;
	}
}
void Console::addMovie(){
	cout << "new movie..." << endl;
	cout << "enter title:" << flush;
	getline(cin,blankLine);
	getline(cin,titlePhrase);
	cout << "enter year:" << flush;
	cin >> year;
	cout << "enter Director:" << flush;
	getline(cin,blankLine);
	getline(cin,director);
	Movie m1(titlePhrase, year, director);
	cout << "\n New movie:"<< titlePhrase << "-"<< year << "-" << director << " added!!!" << endl;
	pmc.addMovie(m1);

}
void Console::removeMovie(){
	cout << "remove movie..." << endl;
	cout << "enter title:" << flush;
	getline(cin,blankLine);
	getline(cin,titlePhrase);
	cout << "enter year:" << flush;
	cin >> year;
	cout << "enter Director:" << flush;
	getline(cin,blankLine);
	getline(cin,director);
	cout << "\n movie:"<< titlePhrase << "-"<< year << "-" << director << " removed!!!" << endl;
	Movie mm2(titlePhrase,year,director);
	pmc.removeMovie(mm2);
}
void Console::saveCollection(){
	cout << "are you sure you want to save? 1234 for yes, else no:" << flush;
	cin >> choice;
	if (choice == 1234){
		pmc.save();
		cout << "Saved!" << endl;
	}
	else{ cout << "save canceled!" << endl;}
}
void Console::suprise(){
	cout << "SUPRIIIIIIIIIIIIIIIISE!!!!!!!" << endl;
	cout << "             *  *  *" << endl;
	cout << "            *|_*|_*|*_" << endl;
	cout << "       .-'`|* |* |*| `'-." << endl;
	cout << "       |`-............-'|" << endl;
	cout << "       |                |" << endl;
	cout << "       |   _  .-.   _   |  " << endl;
	cout << "     ,-|'-' '-'  '-' '-'|-, " << endl;
	cout << "   /`  | _            _.|  `,  " << endl;
	cout << "   '._    `""""""""""`    _.'" << endl;
	cout << "      `''--..........--''`" << endl;
}
