/*
 * MovieCollection.cpp
 *
 *This class creates Collections, vectors that store multiple movies.
 *This class also contains several methods for manipulating and searching the vector.
 *
 *  Created on: Feb 5, 2013
 *      Author: jlm54
 */

#include "MovieCollection.h"

using namespace std;

MovieCollection::MovieCollection(){

}
MovieCollection::MovieCollection(const string& fileName) {
	t = fileName;
	ifstream fin( t.c_str() );
	assert( fin.is_open() );

	Movie aMovie;
	do {
		aMovie.readFrom(fin);
		string blankLine;
		getline(fin, blankLine);
		myMovies.push_back(aMovie);
	} while ( !fin.eof() );
	fin.close();
}

vector<Movie> MovieCollection::searchByDirector(const string& directorName) const {
	vector<Movie> v;
	for (unsigned i = 0; i < myMovies.size(); i++) {
		if ( myMovies[i].getDirector().find(directorName) != string::npos ) {
			v.push_back( myMovies[i] );
		}
	}
	return v;
}

vector<Movie> MovieCollection::searchByYear(const int& year) const {
	vector<Movie> v;
	for (unsigned i = 0; i < myMovies.size(); i++) {
		if ( myMovies[i].getYear() == year) {
			v.push_back( myMovies[i] );
		}
	}
	return v;
}
vector<Movie> MovieCollection::searchByTitlePhrase(const string& titlePhrase) const {
	vector<Movie> v;
	for (unsigned i = 0; i < myMovies.size(); i++) {
		if ( myMovies[i].getTitle().find(titlePhrase) != string::npos ) {
			v.push_back( myMovies[i] );
		}
	}
	return v;
}
void MovieCollection::addMovie(const Movie& newMovie){
	myMovies.push_back(newMovie);
}
void  MovieCollection::removeMovie(const Movie& aMovie){
	for (unsigned i = 0; i < myMovies.size(); i++) {
		if ( myMovies[i].operator==(aMovie) ){
			myMovies.erase(myMovies.begin()+i);
		}
	}
}

void MovieCollection::save() const{
	ofstream dataFile (t.c_str());
	for (unsigned i = 0; i < myMovies.size(); i++) {
		if(i>0){dataFile<<endl;}
		myMovies[i].writeTo(dataFile);
	}
}




