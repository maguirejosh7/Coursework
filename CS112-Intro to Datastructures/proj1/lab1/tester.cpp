/*
 * tester.cpp
 *
 *  Created on: Feb 5, 2013
 *      Author: jlm54
 *      This main class calls all the class-tester classes, and also calls the console.
 */



#include "MovieTester.h"
#include "CollectionTester.h"
#include "Console.h"

int main() {
    MovieTester mt;
    mt.runTests();
    CollectionTester ct;
    ct.runTests();
    Console Console;
}
