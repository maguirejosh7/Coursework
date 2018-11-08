/*
 * tester.cpp
 *
 *  Created on: Feb 5, 2013
 *      Author: jlm54
 */

/* tester.cpp tests the classes in our project.
 *
 */



#include "MovieTester.h"
#include "CollectionTester.h"


int main() {
    MovieTester mt;
    mt.runTests();
    CollectionTester ct;
    ct.runTests();
}
