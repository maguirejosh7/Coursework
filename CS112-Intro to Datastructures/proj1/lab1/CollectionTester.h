/* CollectionTester.h tests the MovieCollection class.
 * Student Name:Joshua Maguire
 * Date:2/11/2013
 * Begun by: Joel Adams, for CS 112 at Calvin College.
 */

#ifndef COLLECTIONTESTER_
#define COLLECTIONTESTER_

#include <iostream>
#include "cassert"
#include <vector>

using namespace std;

class CollectionTester {
public:
	void testConstructor() const;
    void runTests() const;
    void testSearchByYear() const;
    void testSearchByTitlePhrase() const;
    void testAddMovie() const;
    void testRemoveMovie() const;
    void testSaveMovie() const;


};

#endif /*COLLECTIONTESTER_*/
