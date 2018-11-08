/* tester.cpp is a "driver" to run the tests in the StackTester class.
 * Joel Adams, for CS 112 at Calvin College.
 * eddited bgy Joshua Maguire on 4/1/2013
 */
 #include "Decoder.h"
#include "StackTester.h"

int main() {
	StackTester st;
	st.runTests();
	Decoder d1;
	d1.Decode("inputFile.txt","outputFile.txt");//encode
	d1.Decode("outputFile.txt","outputFile2.txt");//decode
}

