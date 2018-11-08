/*
 * MovieCollection.cpp
 *
 *  Created on: Feb 5, 2013
 *      Author: jlm54
 */

#include "MovieCollection.h"
#include <fstream>
#include <vector>
using namespace std;

MovieCollection::MovieCollection(const string& fileName) {
	ifstream fin( fileName.c_str() );
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
