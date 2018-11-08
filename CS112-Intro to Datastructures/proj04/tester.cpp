/* tester.cpp drives the testing of our Vec template and Matrix class.
 * Student: Anna Brink, Joshua Maguire
 * Date: 02/26/13
 * Begun by: Joel C. Adams, for CS 112 at Calvin College.
 */

#include "VecTester.h"
#include "MatrixTester.h"
#include "Application.h"
// #include "MatrixTester.h"

int main() {
//	VecTester vt;
//	vt.runTests();
	MatrixTester mt;
	mt.runTests();
	Application app;
	app.runApplication();
}
