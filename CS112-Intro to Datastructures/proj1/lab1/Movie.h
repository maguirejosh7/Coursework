/* Movie.h
 * Student Name:Joshua Maguire
 * Date:2/11/13
 * Begun by: Joel Adams, for CS 112 at Calvin College.
 */

#ifndef MOVIE_H_
#define MOVIE_H_

#include <istream>
#include <string>
using namespace std;

class Movie {
public:
	Movie();
	Movie(const string& title, int year, const string& director);
	void readFrom(istream& in);
	void writeTo(ostream& out) const;
	string getTitle() const;
	int    getYear() const;
	string getDirector() const;
	bool operator==(const Movie& movie2) const ;
private:
	string myTitle;
	int    myYear;
	string myDirector;
};

#endif /*MOVIE_H_*/
