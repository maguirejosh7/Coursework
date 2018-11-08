/*
 * List.cpp
 *
 *  Created on: Mar 5, 2013
 *      Author: jlm54
 */

#include "List.h"
#include <iostream>
#include <stdexcept>
using namespace std;

List::List(){
	mySize=0;
	myFirst=NULL;
	myLast=NULL;
}
List::~List() {
	delete myFirst;          // delete first node, invoking ~Node() (does nothing if myFirst == NULL)
	myFirst = myLast = NULL; // clear myFirst and myLast (optional)
	mySize = 0;              // clear mySize (optional)
}
unsigned List::getSize() const{
	return mySize;
}
Item List::getFirst() const{
	if(mySize<1||myFirst==NULL){
		throw underflow_error("empty Node!");
	}
	return myFirst->myItem;
}
Item List::getLast() const{
	if(mySize<1||myLast==NULL){
		throw underflow_error("empty Node!");
	}
	return myLast->myItem;
}
void List::append(const Item& it){

	Node *nodePtr = new Node(it, NULL);
	if(myFirst==NULL){
		myFirst=nodePtr;
	}
	else{
		myLast->myNext=nodePtr;
	}
	myLast=nodePtr;
	mySize++;
}
List::List(const List& original) {
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
List& List::operator=(const List& original) {
	if(this!=&original){
		if(mySize>0){
			delete myFirst;
			myFirst = myLast = NULL;
			mySize = 0;
		}
		if(original.getSize()>0){
			Node* oPtr = original.myFirst;
			while (oPtr != NULL) {         //  while there are more nodes:
				append(oPtr->myItem);       //   append the item in that node
				oPtr = oPtr->myNext;        //   advance to next node
			}
		}

	}
	return *this;
}
List::Node::Node(){
	myItem=0;
	myNext=NULL;
}
List::Node::Node(Item it, Node *next){
	myItem = it;
	myNext = next;
}
List::Node::~Node() {
	//	cout << " ~Node()\n" << flush;
	delete myNext;  // delete the next node, invoking ~Node() in it
	// (does nothing if myNext == NULL)
	myNext = NULL;  // clear myNext (optional)
	myItem = 0;     // clear myItem (optional)
}

