/* StackTester.h declares a test-class for a dynamically allocated (array) Stack.
 * Joel Adams, for CS 112 at Calvin College
  * eddited by JOshua Maguire on 4/1/2013.
 */

#ifndef STACKTESTER_H_
#define STACKTESTER_H_


class StackTester {
public:
	void runTests();
	void testConstructor();
	void testIsEmpty();
	void testPushAndIsFull();
	void testGetTop();
	void testPop();
	void testCopyConstructor();
	void testAssignment();
	void testDestructor();
	void testGetSize();
	void testGetCapacity();
	void testSetCapacity();
};

#endif /*STACKTESTER_H_*/

