/* ListTester.h declares the test-class for class List.
 * Joel Adams, for CS 112 at Calvin College.
 * Student Name: Daniel Woltanski
 * Date: March 5, 2013
 */

#ifndef LISTTESTER_H_
#define LISTTESTER_H_

class ListTester {
public:
	void runTests();
	void testDefaultConstructor();
	void testNodeDefaultConstructor();
	void testNodeExplicitConstructor();
	void testAppend();
	void testDestructor();
	void testCopyConstructor();
	void testAssignment();
	void testEquality();

	//These are the tests I wrote.
	void testInequality();
	void testReadFromStream();
	void testWriteToStream();
	void testReadFromFile();
	void testWriteToFile();
	void testPrepend();
	void testSearch();
	void testInsert();
	void testDelete();

	void testSort();
};

#endif /*LISTTESTER_H_*/
