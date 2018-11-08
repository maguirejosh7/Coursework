/* LinkedQueue.cpp defines the methods for class LinkedQueue.
 * Joel Adams, for CS 112 at Calvin College.
 * Student name:Joshua Maguire
 * Date:4/9/13
 */

#include "LinkedQueue.h"

LinkedQueue::LinkedQueue(){
	mySize =0;
	myFirst=NULL;
	myLast=NULL;
}

Item LinkedQueue::getFirst() const{
	if(isEmpty()){throw EmptyQueueException("LinkedQueue::getFirst");}
	return myFirst->myItem;
}

Item LinkedQueue::getLast() const{
	if(isEmpty()){throw EmptyQueueException("LinkedQueue::getLast");}
	return myLast->myItem;
}

void LinkedQueue::append(const Item& it){
	if(isFull()){throw FullQueueException("LinkedQueue::append(Item it)");}
	Node* nPtr = new Node(it,NULL);
	if(isEmpty()){myFirst=nPtr;}
	else{
		myLast->myNext=nPtr;
	}
	myLast=nPtr;
	mySize++;
}

Item LinkedQueue::remove(){
	if(isEmpty()){throw EmptyQueueException("LinkedQueue::remove()");}
	Item result = myFirst->myItem;
	Node* nPtr = myFirst;
	if(!myFirst->myNext){myFirst=NULL;}
	else{myFirst=myFirst->myNext;}
	nPtr->myNext=NULL;
	delete nPtr;
	mySize--;
	return result;
}
LinkedQueue::LinkedQueue(const LinkedQueue& original) {
	makeCopyOf(original);
}

void LinkedQueue::makeCopyOf(const LinkedQueue& original) {
	mySize = original.mySize;
	if ( mySize == 0 ) {
		myFirst = myLast = NULL;
	} else {
		myFirst = new Node(original.getFirst(), NULL);
		Node * temp0 = original.myFirst->myNext;
		Node * temp1 = myFirst;
		while (temp0 != NULL) {
			temp1->myNext = new Node(temp0->myItem, NULL);
			temp1 = temp1->myNext;
			temp0 = temp0->myNext;
		}
		myLast = temp1;
	}
}

LinkedQueue::~LinkedQueue() {
	delete myFirst;
	myFirst = myLast = NULL;
	mySize = 0;
}

LinkedQueue& LinkedQueue::operator=(const LinkedQueue& aQueue) {
	if (this != &aQueue) {
		delete myFirst;    // invokes recursive ~Node()
		makeCopyOf(aQueue);
	}
	return *this;
}



