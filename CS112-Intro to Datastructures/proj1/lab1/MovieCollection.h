/*
 *MovieCollection.h
 *  Created on: Feb 5, 2013
 *      Author: jlm54
 */
#ifndef MOVIECOLLECTION_H_
#define MOVIECOLLECTION_H_

#include <string>
#include "Movie.h"
#include <vector>
#include <cassert>
#include <iostream>

#include <fstream>
#include <vector>
using namespace std;

class MovieCollection {
public:
	MovieCollection();
	MovieCollection(const string& fileName);

	vector<Movie> searchByDirector(const string& directorName) const;
	vector<Movie> searchByYear(const int& year) const;
	vector<Movie> searchByTitlePhrase(const string& titlePhrase) const;
	void addMovie(const Movie& newMovie);
	void removeMovie(const Movie& newMovie);
	void save() const;

private:
	vector<Movie> myMovies;//this is the collection vector
	string t;//used to make 'fileName' in the MovieCollection::MovieCollection method visible to other methods.
};

#endif /*MOVIECOLLECTION_H_*/
