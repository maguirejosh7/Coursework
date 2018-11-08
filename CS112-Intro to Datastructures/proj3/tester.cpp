/* tester.cpp drives the testing of our Vec class.
 * Student: Nathan Terschak, Joshua Maguire
 * Date: 2/25/2013
 * Begun by: Joel C. Adams, for CS 112 at Calvin College.
 */

#include "VecTester.h"
#include <iostream>

int main() {
	VecTester vt;
	vt.runTests();

	cout << "\n" << "Please enter number of dimensions: " << flush;
	unsigned size;
	cin >> size;
	Vec startVec(size);
	cout << "Please enter starting vector coordinates: " << endl;
	startVec.readFrom(cin);
	cout << "Please enter number of vectors to add: " << flush;
	unsigned numVectors;
	cin >> numVectors;
	Vec v(size);
	for (unsigned i = 0; i < numVectors; i++) {
		cout << "Please enter vector coordinates: " << endl;
		v.readFrom(cin);
		startVec = startVec + v;
	}
	cout << "End Position: " << endl;
	startVec.writeTo(cout);
}
