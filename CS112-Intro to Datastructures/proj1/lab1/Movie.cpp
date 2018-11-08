/* Movie.cpp
 * Student Name:Josh Maguire
 * Date:2/11/13
 * Begun by: Joel Adams, for CS 112 at Calvin College.
 */

#include "Movie.h"
//#include <fstream>

Movie::Movie() {//constructor
	myTitle = "";
	myYear = 0;
	myDirector = "";
}
Movie::Movie(const string& title, int year, const string& director) {//explicit constructor
	myTitle = title;
	myYear = year;
	myDirector = director;
}
string Movie::getTitle() const {
	return myTitle;
}
int Movie::getYear() const {
	return myYear;
}
string Movie::getDirector() const {
	return myDirector;
}
void Movie::readFrom(istream& in) {
	getline(in, myTitle);
	in >> myYear;
	string newLine; getline(in, newLine);
	getline(in, myDirector);
}
void Movie::writeTo(ostream& out) const {
	out <<myTitle<< '\n'
	    <<myYear<<'\n'
	    <<myDirector<<'\n';
}
bool Movie::operator==(const Movie& movie2) const {
if ( myTitle == movie2.getTitle() && myYear == movie2.getYear()
			&& myDirector == movie2.getDirector() ) {return true;}
}
