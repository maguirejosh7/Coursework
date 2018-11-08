/*
 * List.h
 *
 *  Created on: Mar 5, 2013
 *      Author: Daniel Woltanski & Joshua Maguire
 */

#ifndef LIST_H_
#define LIST_H_
#include <iostream>
#include <cstdlib>
#include <stdexcept>
#include <fstream>
#include <cassert>
#include <string>
#include <cstdio>
using namespace std;


//Class declaration and method declarations.
template <class Item>
class List {
public:
	List();
	List (const List& original);
	List& operator= (const List& original);
	void append(const Item& it);
	unsigned getSize() const;
	Item& getFirst() const;
	Item& getLast() const;
	bool operator==(const List& l2) const;
	bool operator!= (const List& l2) const;
	void readFrom(istream& in);
	void writeTo(ostream& out) const;
	void readFrom(const string& fileName);
	void writeTo(const string& fileName);
	void prepend(const Item& it);
	int getIndexOf(Item value);
	void insert(const Item& value, int index);
	Item& remove(int index);
	virtual ~List();
private:
	//=========== Node declarations =============================
	struct Node{
		Item myItem;
		Node* myNext;
		Node();
		Node(Item it, Node* next);
		virtual ~Node();

		};
//============= List instance variables =========================
	unsigned mySize;
	Node* myFirst;
	Node* myLast;


	friend  class ListTester;
};


//======================== List methods ===========================================================
/*This is the default constructor.
 * It initializes our instance variables.
 * Postconditions: mySize is set to 0, and both pointers are set to NULL.
 */
template <class Item>
List<Item>::List() {
	mySize = 0;
	myFirst = NULL;
	myLast = NULL;

}

/*This is the copy constructor
 * Code by Joel Adams.
 * It makes a deep copy of a List.
 */
template <class Item>
List<Item>::List(const List<Item>& original) {
	myFirst = myLast = NULL;          //  set pointers
	mySize = 0;                       //  and size to 'empty' values
	if (original.getSize() > 0) {     //  if there are nodes to copy:
		Node* oPtr = original.myFirst; //  start at the first node
		while (oPtr != NULL) {         //  while there are more nodes:
			append(oPtr->myItem);       //   append the item in that node
			oPtr = oPtr->myNext;        //   advance to next node
		}
	}
}

/*This is the assignment overloader.
 * It assigns the values in the list to the right of the '=' sign to the List on the left.
 * Parameters: original is the List on the right of the '=' sign.
 * Precondition: original must be a valid, constructed List.
 * Returns: *this is the List on the left of the '=' sign, to which all of original's values have been copied.
 * Postcondition: the original List's values have been copied into the left-hand-side List.
 */
template <class Item>
List<Item>& List<Item>::operator= (const List<Item>& original){
	if(this != &original){
		if (myFirst != NULL){
			delete myFirst;
			myFirst = NULL;
			myLast = NULL;
			mySize = 0;
		}
		if (original.myFirst != NULL){
			Node* nPtr = original.myFirst;
			while(nPtr != NULL){
				append(nPtr->myItem);
				nPtr = nPtr->myNext;


			}
		}
	}
	return *this;
}

/*This is the getSize accessor.
 * It returns the size of the List.
 * Returns: mySize.
 */
template <class Item>
unsigned List<Item>::getSize() const{
	return mySize;
}

/*This is the getFirst accessor.
 * It returns the Item at the myFirst pointer.
 * Returns: myFirst->myItem gets the Item stored in the first node.
 * Postcondition: if the List is empty, throws an exception, otherwise the Item is returned.A
 */
template <class Item>
Item& List<Item>::getFirst() const{
	if (mySize <= 0 || myFirst == NULL){
		throw underflow_error("Cannot retrieve an Item that is not stored.");
	}
	return myFirst->myItem;
}

/*This is the getLast accessor.
 * It returns the Item at the myLast pointer.
 * Returns: myLast->myItem gets the Item stored in the last node.
 * Postcondition: if the List is empty, throws an exception, otherwise the Item is returned.A
 */
template <class Item>
Item& List<Item>::getLast() const{
	if (mySize <= 0 || myFirst == NULL){
		throw underflow_error("Cannot retrieve an Item that is not stored.");
	}
	return myLast->myItem;
}

/*This is the append method.
 * It allows us to add new Items to the List.
 * Parameters: it is the Item that we want to add to the List.
 * Preconditions: it must be a valid value of type Item.
 * Postconditions: it has been added to the List, all pointers have been updated as necessary.
 */
template <class Item>
void List<Item>::append(const Item& it){
	Node* nodePtr = new Node (it, NULL);


	if(mySize == 0 && myFirst == NULL){
		myFirst = nodePtr;
	} else {
		myLast->myNext = nodePtr;
	}
	myLast = nodePtr;
	mySize += 1;

}

/*This is the Destructor.
 * Code by Joel Adams.
 * Postcondition: the List has been entirely deleted.
 */
template <class Item>
List<Item>::~List() {
	delete myFirst;          // delete first node, invoking ~Node() (does nothing if myFirst == NULL)
	myFirst = myLast = NULL; // clear myFirst and myLast (optional)
	mySize = 0;              // clear mySize (optional)
}

/* This is the equality overloader.
 * It allows us to compare 2 Lists.
 * Parameters: l2 is the list on the right hand side of the '==' sign.
 * Preconditions: l2 must be a valid List object.
 * Returns: either true or false is returned, depending on if the 2 Lists are indeed equal or not.
 * Postcondition: if the two Lists are not the same, false is returned. Otherwise, true is returned.
 */
template <class Item>
bool List<Item>::operator==(const List<Item>& l2)const{

	if (mySize != l2.mySize){
		return false;
	} else if (myFirst == NULL && l2.myFirst == NULL){
		return true;
	}
	if(myFirst->myItem != l2.myFirst->myItem){
		return false;
	}
	Node* lPtr = l2.myFirst;
	Node* rPtr = myFirst;
	while (lPtr != NULL) {
		if(lPtr->myItem == rPtr->myItem){
			lPtr = lPtr->myNext;
			rPtr = rPtr->myNext;
		} else {
			return false;
		}
	}
	if (myLast->myItem != l2.myLast->myItem){
		return false;
	}
	delete rPtr;
	delete lPtr;
	return true;
}

/*This is the not-equal overloader.
 * It allows us to compare two Lists and determine if they are not equal.
 * Parameters: l2 is the List on the right side of the '!=' sign.
 * Preconditions: l2 must be a valid List.
 * Returns: if the lists are equal, returns false. Otherwise, returns true.
 */
template <class Item>
bool List<Item>::operator!= (const List<Item>& l2) const{
	if (mySize != l2.mySize){
		return true;
	} else if (myFirst == NULL && l2.myFirst == NULL){
		return false;
	}
	Node* lPtr = l2.myFirst;
	Node* rPtr = myFirst;
	while (lPtr != NULL) {
		if(lPtr->myItem != rPtr->myItem){
			return true;
		}
		lPtr = lPtr->myNext;
		rPtr = rPtr->myNext;
	}
	delete rPtr;
	delete lPtr;
	return true;
}

/*This is the istream version of the readFrom method.
 * It allows us to read a List from a stream.
 * Parameters: in is the istream that we will use to read values; it must be a valid istream.
 * Postcondition: all values have been read into the List until a new line character is encountered.
 */
template <class Item>
void List<Item>::readFrom(istream& in){
	Item value;
	while(true){
		if (in.peek() == '\n'){
			break;
		} else {
			in >> value;
			append(value);
		}
	}
}

/*This is the ostream version of the writeTo method.
 * It allows us to output a List to a stream.
 * Parameters: out is the outstream that will we put values into; it must be a valid ostream.
 * Postcondition: all values in the List have been output, spaced by tabs, and with a new line character at the end.
 */
template <class Item>
void List<Item>::writeTo(ostream& out) const{
	Node* ptr = myFirst;
	while (ptr != NULL){
		out << ptr->myItem << "\t";
		ptr = ptr->myNext;
	}
	out << "\n";
}

/*This is the file version of the readFrom method.
 * It allows us to read a List from a file.
 * Parameters: fileName is the string we will use to construct the file; it must be a valid string.
 * Postcondition: all values have been read into the List until the end of file character is encountered.
 */
template <class Item>
void List<Item>::readFrom(const string& fileName){
	ifstream fin(fileName.c_str());
	delete myFirst;
	Item value;
	while(fin.peek() != char_traits<wchar_t>::eof()){
		fin >> value;
		append(value);
	}
	fin.close();
}

/*This is the file version of the writeTo method.
 * It allows us to output a List to a file.
 * Parameters: fileName is the string we will use to construct the file; it must be a valid string.
 * Postcondition: all values in the List have been output, spaced by tabs.
 */
template <class Item>
void List<Item>::writeTo(const string& fileName){
	ofstream fout (fileName.c_str());
	Node* ptr = myFirst;
	while (ptr != myLast){
		fout << ptr->myItem << "\t";
		ptr = ptr->myNext;
	} if (ptr == myLast){
		fout << ptr->myItem;
	}
	fout.close();
}

/*This is the prepend method.
 * It allows us to add a new value to the beginning of the List.
 * Parameters: it is the value we want to stick in the List; it must be valid value of type Item.
 * Postconditions: a new Node has been created with the value of it inside, and added to the end of the list, updating pointers as necessary.
 *
 */
template <class Item>
void List<Item>::prepend(const Item& it){
	Node* nodePtr = new Node (it, NULL);
	if(mySize == 0 && myFirst == NULL){
		myLast = nodePtr;
	}
	nodePtr->myNext = myFirst;
	myFirst = nodePtr;
	mySize += 1;
}


/*This is the getIndexOf method.
 * It allows us to find the relative location of an Item in a List.
 * Parameters: value is the Item we want to search for; it must be a valid value of type Item.
 * Returns: the index of where the value is in the List is returned. If the value is not in the List, -1 is returned.
 */
template <class Item>
int List<Item>::getIndexOf(Item value){
	Node* myPtr = myFirst;
	int i = 1;
	if(myFirst == NULL){
		return -1;
	}
	while (true){
		if(myPtr->myItem == value ){
			return i;
		}
		myPtr = myPtr->myNext;
		i++;
	}
	return -1;
}

/*This is the insert method.
 * It allows us stick a new value into the List at an arbitrary index.
 * Parameters: value is the Item that we want to stick in the List, index is the spot in the List where it will be stuck.
 * Preconditions: value must be a valid value of type Item, and index must be a valid int value.
 * Postconditions: If the index was less than or equal to 1, value was prepended to the List.
 	 	 	 If index was greater than the size of the List, value was apended to the List.
 	 	 	 If index was inside the List, value was stuck into the list at that point.
 */
template <class Item>
void List<Item>::insert(const Item& value, int index){
	Node* newPtr = myFirst;
	Node* prePtr = myFirst;
	int i = 1;
	while (true){
		if (index <= 1){
			prepend(value);
			break;
		} else if (index > mySize){
			append(value);
			break;
		} else if(index == i+1){
			newPtr = new Node(value, prePtr->myNext);
			prePtr->myNext = newPtr;
			mySize++;
			break;

		}

		prePtr = prePtr->myNext;
		newPtr->myNext = prePtr->myNext;
		i++;
	}

}

/*This is the Super_Awesome_Removal Method!
 * It allows us to destroy a node from the List, returning that node's value.
 * Parameters: index is the location in the List of the node to destroy; it must be a valid integer value.
 * Returns: copy is the Item previously stored in the node we destroyed.
 * Postconditions: If the index was less than or equal to 1, the first node was destroyed and its value ouputted.
  	  	  	  	  If the index was a valid position inside the List, the Node corresponding to that relative postion was eradicated, and the objective value previously sequestered in that Node's allocated data position was returned.
  	  	  	  	  If the index was the last spot in the List, the last node was deleted and its value returned.
  	  	  	  	  If the index was greater than the size of said List, then the very last Node in the entire List was annihilated and its value was given up.
 hehe.
 */
template <class Item>
Item& List<Item>::remove(int index){
	Node* newPtr = myFirst;
	Node* prePtr = myFirst;
	Item copy;
	for (int i = 1; i < mySize-1; i++){
		if (index <= 1){
			newPtr = myFirst->myNext;
			myFirst = newPtr;
			prePtr->myNext = NULL;
			copy = prePtr->myItem;
			delete prePtr;
			mySize--;
			return copy;
		} else if(index == i+1){
			if (index == mySize){
				myLast = prePtr;
			}

			prePtr->myNext = newPtr->myNext;
			newPtr->myNext = NULL;
			copy = newPtr->myItem;
			delete newPtr;
			mySize--;
			return copy;

		}
		prePtr = prePtr->myNext;
		newPtr = prePtr->myNext;
	}
	newPtr = myLast;
	newPtr->myNext = NULL;

	copy = newPtr->myItem;

	delete newPtr;
	myLast = prePtr;
	mySize--;
	return copy;
}

//======================== Node methods ===========================================================
/*This is the default constructor.
 * It initializes the instance variables.
 * Postcondition: myItem is set to 0, and the pointer to NULL.
 */
template <class Item>
List<Item>::Node::Node(){
	myItem = 0;
	myNext = NULL;
}

/*This is the explicit value constructor.
 * It initializes the instance variables to the user-provided values.
 * Parameters: it is the Item we want to put in the node, next is the pointer for myNext.
 * Preconditions: both it and next have to be valid values of their specific types.
 * Postcondition: myItem is set to it, myNext is set to next.
 */
template <class Item>
List<Item>::Node::Node(Item it, Node* next){
	myItem = it;
	myNext = next;
}


/*This is the Node destructor.
 * Code by Joel Adams.
 * Postcondition: the Node has deleted itself and the nodes following it.
 */
template <class Item>
List<Item>::Node::~Node() {
	//cout << " ~Node()\n" << flush;
	delete myNext;  // delete the next node, invoking ~Node() in it
	// (does nothing if myNext == NULL)
	myNext = NULL;  // clear myNext (optional)
	myItem = 0;     // clear myItem (optional)
}





#endif /* LIST_H_ */
