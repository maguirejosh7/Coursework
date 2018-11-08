/* ListTester.cpp defines the test methods for class List.
 * Joel Adams, for CS 112 at Calvin College.
 * Students: Daniel Woltanski,  Human joshuaMaguire* = new Human(0010101001,male,greeneyes,tail,superbrain);
 * Date: March 5, 2013
 */


#include "ListTester.h" // ListTester
#include "List.h"       // List
#include <iostream>     // cin, cout
#include <cassert>      // assert()
#include <cstdlib>      // exit()
#include <stdexcept>    // underflow_error
#include <fstream>
#include <cassert>


using namespace std;

void ListTester::runTests() {
	cout << "Running List tests..." << endl;
	testDefaultConstructor();
	testNodeDefaultConstructor();
	testNodeExplicitConstructor();
	testAppend();
	testDestructor();
	testCopyConstructor();
	testAssignment();
	testEquality();
	testInequality();
	testReadFromStream();
	testWriteToStream();
	testReadFromFile();
	testWriteToFile();
	testPrepend();
	testSearch();
	testInsert();
	testDelete();
	cout << "All tests passed!" << endl;
	cout << "ALL TESTS PASSED!!!!" << endl;
}

void ListTester::testDefaultConstructor() {
	cout << "Testing List default constructor... " << flush;
	List<double> aList;
	assert( aList.mySize == 0 );
	assert( aList.myFirst == NULL );
	assert( aList.myLast == NULL );
	cout << "Passed!" << endl;
}

void ListTester::testNodeDefaultConstructor() {
	cout << "Testing Node default constructor... " << flush;
	List<double>::Node aNode;
	assert( aNode.myItem == 0 );
	assert( aNode.myNext == NULL );
	cout << "Passed!" << endl;
}

void ListTester::testNodeExplicitConstructor() {
	cout << "Testing Node explicit constructor... " << flush;
	List<int>::Node n1(11, NULL);
	assert( n1.myItem == 11 );
	assert( n1.myNext == NULL );
	cout << " 1 " << flush;

	List<int>::Node *n3 = new List<int>::Node(33, NULL);
	List<int>::Node n2(22, n3);
	assert( n2.myItem == 22 );
	assert( n2.myNext == n3 );
	cout << " 2 " << flush;
	cout << "Passed!" << endl;
}

void ListTester::testAppend() {
	cout << "Testing append()... " << flush;
	// empty List
	List<char> aList;
	assert( aList.getSize() == 0 );
	assert( aList.myFirst == NULL );
	assert( aList.myLast == NULL );
	try {
		aList.getFirst();
		cerr << "getFirst() worked on empty list" << endl;
		exit(1);
	} catch (underflow_error) {
		cout << " 0a " << flush;
	}
	try {
		aList.getLast();
		cerr << "getLast() worked on empty list" << endl;
		exit(1);
	} catch (underflow_error) {
		cout << " 0b " << flush;
	}
	// append to empty list
	aList.append(11);
	assert( aList.getSize() == 1 );
	assert( aList.myFirst != NULL );
	assert( aList.myLast == aList.myFirst );
	assert( aList.getFirst() == 11 );
	assert( aList.getLast() == 11 );
	assert( aList.myFirst->myNext == NULL );
	cout << " 1 " << flush;
	// append to a list containing 1 Item
	aList.append(22);
	assert( aList.getSize() == 2 );
	assert( aList.myFirst != NULL );
	assert( aList.myLast != NULL );
	assert( aList.myFirst != aList.myLast );
	assert( aList.getFirst() == 11 );
	assert( aList.getLast() == 22 );
	assert( aList.myFirst->myNext != NULL );
	assert( aList.myLast->myNext == NULL );
	cout << " 2 " << flush;
	// append to a list containing 2 Items
	aList.append(33);
	assert( aList.getSize() == 3 );
	assert( aList.myFirst != NULL );
	assert( aList.myLast != NULL );
	assert( aList.getFirst() == 11 );
	assert( aList.getLast() == 33 );
	assert( aList.myFirst->myNext->myItem == 22 );
	assert( aList.myLast->myNext == NULL );
	cout << " 3 " << flush;
	cout << "Passed!" << endl;
}

void ListTester::testDestructor() {
	cout << "Testing destructor... " << flush;
	List<long> aList;
	aList.~List();
	assert( aList.getSize() == 0 );
	assert( aList.myFirst == NULL );
	assert( aList.myLast == NULL );
	cout << " 1 " << flush;

	aList.append(11);
	aList.append(22);
	aList.append(33);
	aList.~List();
	assert( aList.getSize() == 0 );
	assert( aList.myFirst == NULL );
	assert( aList.myLast == NULL );
	cout << " 2 " << flush;
	cout << "Passed!  But double-check for memory leaks!" << endl;
}

void ListTester::testCopyConstructor() {
	cout << "Testing copy constructor... " << flush;
	// copy empty list
	List<int> list1;
	List<int> list2(list1);
	assert( list2.getSize() == 0 );
	assert( list2.myFirst == NULL );
	assert( list2.myLast == NULL );
	cout << " 1 " << flush;

	// copy nonempty list
	List<int> list3;
	list3.append(11);
	list3.append(22);
	list3.append(33);
	List<int> list4(list3);
	assert( list4.getSize() == 3 );
	assert( list4.getFirst() == 11 );
	assert( list4.getLast() == 33 );
	assert( list4.myFirst->myNext->myItem == 22 );
	assert( list4.myFirst != list3.myFirst );
	assert( list4.myLast != list3.myLast );
	cout << " 2 " << flush;
	cout << "Passed!" << endl;
}

void ListTester::testAssignment() {
	cout << "Testing assignment... " << flush;
	// empty to empty assignment
	List<short> list1;
	List<short> list2;
	list2 = list1;
	assert( list2.getSize() == 0 );
	assert( list2.myFirst == NULL );
	assert( list2.myLast == NULL );
	cout << " 1 " << flush;

	// non-empty to empty assignment
	List<short> list3;
	list3.append(11);
	list3.append(22);
	list3.append(33);
	List<short> list4;
	list4 = list3;
	assert( list4.getSize() == 3 );
	assert( list4.getFirst() == 11 );
	assert( list4.getLast() == 33 );
	assert( list4.myFirst->myNext->myItem == 22 );
	cout << " 2 " << flush;

	// equal-sized non-empty to non-empty assignment
	List<short> list5;
	list5.append(44);
	list5.append(55);
	list5.append(66);
	list5 = list3;
	assert( list5.getSize() == 3 );
	assert( list5.getFirst() == 11 );
	assert( list5.getLast() == 33 );
	assert( list5.myFirst->myNext->myItem == 22 );
	cout << " 3 " << flush;

	// empty to non-empty assignment
	List<short> list6;
	list6.append(44);
	list6.append(55);
	list6.append(66);
	List<short> list7;
	list6 = list7;
	assert( list6.getSize() == 0 );
	assert( list6.myFirst == NULL );
	assert( list6.myLast == NULL );
	cout << " 4 " << flush;

	// unequal-sized non-empty to non-empty assignment
	List<short> list8;
	list8.append(44);
	list8.append(55);
	list8.append(66);
	list8.append(77);
	list8 = list3;
	assert( list8.getSize() == 3 );
	assert( list8.getFirst() == 11 );
	assert( list8.getLast() == 33 );
	assert( list8.myFirst->myNext->myItem == 22 );
	cout << " 5 " << flush;

	// assignment chaining
	List<short> list9;
	list9.append(44);
	list9.append(55);
	list9.append(66);
	list9.append(77);
	List<short> list10;
	list10 = list9 = list8;
	assert( list10.getSize() == 3 );
	assert( list10.getFirst() == 11 );
	assert( list10.getLast() == 33 );
	assert( list10.myFirst->myNext->myItem == 22 );
	cout << " 6 " << flush;

	// self-assignment (stupid, but possible)
	List<short> list11;
	list11.append(11);
	list11.append(22);
	list11.append(33);
	list11 = list11;
	assert( list11.getSize() == 3 );
	assert( list11.getFirst() == 11 );
	assert( list11.getLast() == 33 );
	assert( list11.myFirst->myNext->myItem == 22 );
	cout << " 7 " << flush;

	cout << "Passed!  But double-check for memory leaks!" << endl;
}

void ListTester::testEquality() {
	cout << "Testing equality... " << flush;
	// two empty lists
	List<double> list1;
	List<double> list2;
	assert( list1 == list1 );
	cout << " 1 " << flush;

	// a non-empty list
	List<double> list3;
	list3.append(33);		// [33]
	assert( !(list3 == list1) );
	cout << " 2 " << flush;

	// equal, non-empty lists of the same size
	List<double> list4;
	list4.append(33);		// [33]
	assert( list4 == list3 );
	assert( list3 == list4 );
	cout << " 3 " << flush;

	// unequal, non-empty lists of the same size
	list3.append(55);		// [33,55]
	List<double> list5;
	list5.append(44);		// [44]
	list5.append(55);		// [44,55]
	assert( !(list5 == list3) );
	assert( !(list3 == list5) );
	cout << " 4 " << flush;

	// unequal non-empty lists of different sizes
	list4.append(44);		// [33,44]
	list4.append(55);		// [33,44,55]
	assert( !(list4 == list5) );
	assert( !(list5 == list4) );
	assert( !(list5 == list3) );
	cout << " 5 " << flush;

	cout << "Passed!" << endl;
}

/*This is the testInequality method.
 * It makes sure our inequality method works properly.
 */
void ListTester::testInequality(){
	cout << "Testing inequality... " << flush;
	// two empty lists
	List<double> list1;
	List<double> list2;
	assert( (list1 != list1) == false );
	cout << " 1 " << flush;

	// a non-empty list
	List<double> list3;
	list3.append(33);		// [33]
	assert( (list3 != list1) );
	cout << " 2 " << flush;

	// equal, non-empty lists of the same size
	List<double> list4;
	list4.append(22);		// [22]
	assert( list4 != list3 );
	assert( list3 != list4 );
	cout << " 3 " << flush;

	// unequal, non-empty lists of the same size
	list3.append(55);		// [33,55]
	List<double> list5;
	list5.append(44);		// [44]
	list5.append(55);		// [44,55]
	assert( (list5 != list3) );
	assert( (list3 != list5) );
	cout << " 4 " << flush;

	// unequal non-empty lists of different sizes
	list4.append(44);		// [33,44]
	list4.append(55);		// [33,44,55]
	assert( (list4 != list5) );
	assert( (list5 != list4) );
	assert( (list5 != list3) );
	cout << " 5 " << flush;

	cout << "Passed!" << endl;
}

/*This is the testReadFromStream method.
 * It makes sure our istream version of readFrom works properly.
 */
void ListTester::testReadFromStream(){
	cout << "Testing readFrom(istream)..." << flush;
	List<double> list1;
	assert(list1.mySize == 0);
	cout << " 1 " << flush;
	ifstream fin ("ListTest.txt");
	assert(fin.is_open() );
	cout << " 2 " << flush;
	list1.readFrom(fin);
	cout << " 3 " << flush;
	assert(list1.mySize == 6);
	cout << " 4 " << flush;
	assert(list1.myFirst->myItem == 5);
	cout << " 5 " << flush;
	assert(list1.myLast->myItem == 10);
	cout << " 6 " << flush;
	cout << "Passed!" << endl;
}

/*This is the testWriteToStream method.
 * It makes sure our ostream version of writeTo works properly.
 */
void ListTester::testWriteToStream(){
	cout << "Testing writeTo(ostream) ... " << flush;
	List<double> outList;
	ifstream fin("ListTest.txt");
	assert(fin.is_open());
	outList.readFrom(fin);
	cout << " 1 " << flush;
	ofstream fout ("ListTest2.txt");
	assert(fout.is_open());
	outList.writeTo(fout);
	cout << " 2 " << flush;
	fout.close();
	cout << "Passed, see ListTest2 for values. " << endl;

}

/*This is the testReadFromFile method.
 * It makes sure our file version of readFrom works properly.
 */
void ListTester::testReadFromFile(){
	cout << "Testing readFrom(string)..." << flush;
	List<double> rList;
	rList.readFrom("ListTest3.txt");
	cout << " 1 " << flush;
	assert(rList.getSize() == 8);
	cout << " 2 " << flush;
	assert(rList.myFirst->myItem == 2);
	assert (rList.myLast->myItem == 16);
	cout << " 3 " << flush;
	cout << "Passed!" << endl;
}


/*This is the testWriteToFile method.
 * It makes sure our file version of writeTo works properly.
 */
void ListTester::testWriteToFile(){
	cout << "Testing writeTo(string)... " << flush;
	List<double> l1;
	l1.readFrom("ListTest3.txt");
	cout << " 1 " << flush;
	l1.writeTo("ListTest4.txt");
	cout << " 2 " << flush;
	List<double> l2;
	l2.readFrom("ListTest4.txt");
	cout << " 3 " << flush;
	assert ( l2 == l1);
	cout << " 4 " << flush;
	cout << "Passed!" << endl;

}


/*This is the testPrepend method.
 * It makes sure our prepend method works properly.
 */
void ListTester::testPrepend(){
	cout << "Testing prepend()... " << flush;
	// empty List
	List<double> aList;
	// prepend to empty list
	aList.prepend(11);
	assert( aList.getSize() == 1 );
	assert( aList.myFirst != NULL );
	assert( aList.myLast == aList.myFirst );
	assert( aList.getFirst() == 11 );
	assert( aList.getLast() == 11 );
	assert( aList.myFirst->myNext == NULL );
	cout << " 1 " << flush;
	// prepend to a list containing 1 Item
	aList.prepend(22);
	assert( aList.getSize() == 2 );
	assert( aList.myFirst != NULL );
	assert( aList.myLast != NULL );
	assert( aList.myFirst != aList.myLast );
	assert( aList.getFirst() == 22 );
	assert( aList.getLast() == 11 );
	assert( aList.myFirst->myNext != NULL );
	assert( aList.myLast->myNext == NULL );
	cout << " 2 " << flush;
	// prepend to a list containing 2 Items
	aList.prepend(33);
	assert( aList.getSize() == 3 );
	assert( aList.myFirst != NULL );
	assert( aList.myLast != NULL );
	assert( aList.getFirst() == 33 );
	assert( aList.getLast() == 11 );
	assert( aList.myFirst->myNext->myItem == 22 );
	assert( aList.myLast->myNext == NULL );
	cout << " 3 " << flush;
	cout << "Passed!" << endl;
}


/*This is the testSearch method.
 * It makes sure our getIndexOf method works properly.
 */
void ListTester::testSearch(){
	cout << "Testing getIndexOf()... " << flush;
	List<double> sList;
	assert( sList.getIndexOf(1) == -1);
	cout << " 1 " << flush;
	sList.readFrom("ListTest4.txt");
	cout << " 2 " << flush;
	assert(sList.getIndexOf(2) == 1);
	cout << " 3 " << flush;
	assert(sList.getIndexOf(4) == 2);
	assert(sList.getIndexOf(6) == 3);
	assert(sList.getIndexOf(8) == 4);
	assert(sList.getIndexOf(10) == 5);
	assert(sList.getIndexOf(12) == 6);
	assert(sList.getIndexOf(14) == 7);
	cout << " 4 " << flush;
	assert(sList.getIndexOf(16) == 8);
	cout << " 5 " << flush;
	cout << " Passed!" << endl;
}

/*This is the testInsert method.
 * It makes sure our insert method works properly.
 */
void ListTester::testInsert(){
	cout << "Testing insert()... " << flush;
	// empty List
	List<double> aList;
	// insert to empty list
	aList.insert(11, 1);
	assert( aList.getSize() == 1 );
	assert( aList.myFirst != NULL );
	assert( aList.myLast == aList.myFirst );
	assert( aList.getFirst() == 11 );
	assert( aList.getLast() == 11 );
	assert( aList.myFirst->myNext == NULL );
	cout << " 1 " << flush;
	// insert by apending to a list containing 1 Item
	aList.insert(22, 2);
	assert( aList.getSize() == 2 );
	assert( aList.myFirst != NULL );
	assert( aList.myLast != NULL );
	assert( aList.myFirst != aList.myLast );
	assert( aList.getFirst() == 11 );
	assert( aList.getLast() == 22 );
	assert( aList.myFirst->myNext != NULL );
	assert( aList.myLast->myNext == NULL );
	cout << " 2 " << flush;
	// insert by prepending to a List containing 2 Items
	aList.insert(33, 1);
	assert( aList.getSize() == 3 );
	assert( aList.myFirst != NULL );
	assert( aList.myLast != NULL );
	assert( aList.getFirst() == 33 );
	assert( aList.getLast() == 22 );
	assert( aList.myFirst->myNext->myItem == 11 );
	assert( aList.myLast->myNext == NULL );
	cout << " 3 " << flush;
	//insert into the middle of List containing 3 Items.
	aList.insert(55, 2);
	assert( aList.getSize() == 4 );
	assert( aList.myFirst->myNext->myItem == 55 );
	cout << " 4 " << flush;
	//insert by prepending to a negative index, which places the value at index 1.
	aList.insert(90, -12);
	assert( aList.getSize() == 5 );
	assert( aList.getFirst() == 90 );
	cout << " 5 " << flush;
	//inserting by apending to an overly large index, which places the value at the last index.
	aList.insert(66, 78);
	assert( aList.getSize() == 6 );
	assert( aList.getLast() == 66 );
	cout << " 6 " << flush;
	cout << "Passed!" << endl;
}
/* This is our Delete method tester.
 * It makes sure our delete method works properly.
 * This is the longest, hardest, most frusterating test in the whole program. If you don't like it, write your own!
 *
 * From Josh:					    ___/-,
 * "To our left is a text dog>>"    /\/\
 */
void ListTester::testDelete(){
	cout << "Testing remove()... "<< flush;
	List<double> tList;
	tList.readFrom("ListTest4.txt");
	assert( tList.getSize() == 8);
	assert(tList.getLast() == 16);
	assert(tList.getFirst() == 2);
	cout << " 1 " << flush;
	//testing removal from a less than 1 index.
	tList.remove(0);
	assert( tList.getSize() == 7);
	assert(tList.getLast() == 16);
	assert(tList.getFirst() == 4);
	cout << " 2 " << flush;
	//testing removal from index 1.
	tList.remove(1);
	assert( tList.getSize() == 6);
	assert(tList.getLast() == 16);
	assert(tList.getFirst() == 6);
	cout << " 3 " << flush;
	//testing removal from the middle of the list.
	tList.remove(3);
	assert( tList.getSize() == 5);
	assert( tList.getFirst() == 6);
	assert( tList.getLast() == 16);
	cout << " 4 " << flush;
	//testing removal from the last index (equal to mySize).
	tList.remove(5);
	assert( tList.getSize() == 4);
	assert( tList.getLast() == 14);
	assert( tList.getFirst() == 6);

	cout << " 5 " << flush;
	//testing removal from the end of the list by an index greater than mySize.
	tList.remove(900);
	assert( tList.getSize() == 3);
	assert( tList.getLast() == 12);
	assert( tList.getFirst() == 6);
	cout << " 6 " << flush;
	cout << " Passed! " << endl;
	cout << "All tests passed!" << endl;
	cout << "ALL TESTS PASSED!!!!" << endl;

}
