/* CollectionTester.cpp defines the MovieCollection test-methods.
 * Student Name:Joshua Maguire
 * Date:2/11/2013
 * Begun by: Joel Adams, for CS 112 at Calvin College.
 */

#include "CollectionTester.h"
#include "MovieCollection.h"


//method that runs all tests for class methods that need testing.
void CollectionTester::runTests() const {
	cout << "Testing class MovieCollection..." << endl;
	testConstructor();
	testSearchByYear();
	testSearchByTitlePhrase();
	testAddMovie();
	testRemoveMovie();
	testSaveMovie();
	cout << "All tests passed!" << endl;
}

void CollectionTester::testConstructor() const {
	cout << "- constructor..." << flush;
	MovieCollection mc("testCollection.txt");
	// case of 1 movie
	vector<Movie> v1 = mc.searchByDirector("Hand");
	assert( v1.size() == 1 );
	assert( v1[0].getTitle() == "Bambi" );
	cout << " 1 " << flush;
	// case of 2 movies
	vector<Movie> v2 = mc.searchByDirector("Spielberg");
	assert( v2.size() == 2 );
	assert( v2[0].getTitle() == "Jaws" );
	assert( v2[1].getTitle() == "Raiders of the Lost Ark" );
	cout << " 2 " << flush;
	// case of no movies
	vector<Movie> v3 = mc.searchByDirector("Hitchcock");
	assert( v3.size() == 0 );
	cout << " 3 " << flush;
	cout << " Passed!" << endl;
}
void CollectionTester::testSearchByYear() const{
	cout << "Testing SearchByYear..." << flush;
	MovieCollection mc("testCollection.txt");

	vector<Movie> v1 = mc.searchByYear(1939);
	assert( v1.size()==2);
	assert(v1[0].getTitle()=="Gone with the Wind");
	assert(v1[1].getTitle()=="The Wizard of Oz");
	cout << " 1 " << flush;


	vector<Movie> v2 = mc.searchByYear(1981);
	assert( v2.size()==1);
	assert(v2[0].getTitle()=="Raiders of the Lost Ark");
	cout << " 2 " << flush;

	vector<Movie> v3 = mc.searchByYear(1919);
	assert( v3.size()==0);
	cout << " 3 " << flush;
	cout << " Passed!" << endl;
}
void CollectionTester::testSearchByTitlePhrase() const{
	cout << "Testing searchByTitlePhrase..." << flush;
	MovieCollection mc("testCollection.txt");
	vector<Movie> v1 = mc.searchByTitlePhrase("Bambi");
	assert( v1.size() == 1 );
	assert( v1[0].getYear() == 1942 );
	cout << " 1 " << flush;
	vector<Movie> v2 = mc.searchByTitlePhrase("sdfgsdfg");
	assert( v2.size() == 0 );
	cout << " 2 " << flush;
	vector<Movie> v3 = mc.searchByTitlePhrase("Jaws");
	assert( v3.size() == 1 );
	assert( v3[0].getYear() == 1975 );
	cout << " 3 " << flush;
	cout << " Passed!" << endl;
}
void CollectionTester::testAddMovie() const{
	cout << "testing addMovie" << flush;
	MovieCollection mc("testCollection.txt");
	Movie m1("Derp", 2154, "Derpina Derpface");
	mc.addMovie(m1);
	vector<Movie> v1 = mc.searchByTitlePhrase("Derp");
	assert( v1[0].getTitle() == "Derp" );
	cout << " Passed!" << endl;
}
void CollectionTester::testRemoveMovie() const{
	cout << "testing removeMovie" << flush;
	MovieCollection mc("testCollection.txt");
	Movie m1("Derp", 2154, "Derpina Derpface");
	mc.addMovie(m1);
	mc.removeMovie(m1);
	vector<Movie> v1 = mc.searchByTitlePhrase("Derp");
	assert( v1.size() == 0 );
	cout << " Passed!" << endl;
}

void CollectionTester::testSaveMovie() const{
	cout << "testing save..." << flush;
	MovieCollection mct("savetestfile.txt");
	Movie m1("Derp", 1337, "Derpina");
	mct.removeMovie(m1);
	mct.addMovie(m1);
	mct.save();
	MovieCollection mct2("savetestfile.txt");
	vector<Movie> v12 = mct2.searchByTitlePhrase("Derp");
	assert( v12.size() == 1 );
	Movie m2("Derp", 1337, "Derpina");
	mct.removeMovie(m2);
	cout << " Passed!" << endl;
}




