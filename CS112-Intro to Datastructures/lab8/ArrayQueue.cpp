/* ArrayQueue.cpp defines the methods for class ArrayQueue.
 * Joel Adams, for CS 112 at Calvin College.
 * Student name:Joshua Maguire
 * Date:4/9/13
 */

#include "ArrayQueue.h"
#include <cstring>      // memcpy()
using namespace std;

ArrayQueue::ArrayQueue(unsigned size)
{
	if(size<1){throw QueueException ("ArrayQueue::ArrayQueue","capacity was less than 1");}
	mySize = 0;
	myCapacity = size;
	myFirst = 0;
	myLast = 0;
	myArray = new Item[size];

}
ArrayQueue::ArrayQueue(const ArrayQueue& original) {
	makeCopyOf(original);
}

void ArrayQueue::makeCopyOf(const ArrayQueue& original) {
	mySize = original.mySize;
	myCapacity = original.myCapacity;
	myFirst = original.myFirst;
	myLast = original.myLast;
	myArray = new Item[myCapacity];
	memcpy(myArray, original.myArray, myCapacity*sizeof(Item) );
}

ArrayQueue::~ArrayQueue() {
	delete [] myArray;
	myArray = NULL;
	mySize = myFirst = myLast = 0;
}


ArrayQueue& ArrayQueue::operator=(const ArrayQueue& aQueue) {
	if (this != &aQueue) {
		delete [] myArray;;
		makeCopyOf(aQueue);
	}
	return *this;
}

bool ArrayQueue::isEmpty() const {
	return mySize == 0;
}

bool ArrayQueue::isFull() const {
	return getSize() == myCapacity;
}

unsigned ArrayQueue::getCapacity() const {
	return myCapacity;
}

unsigned ArrayQueue::getSize() const {
	return mySize;
}

Item ArrayQueue::getFirst() const{
	if(isEmpty()){throw EmptyQueueException("ArrayQueue::getFirst");}
	return myArray[myFirst];
}

Item ArrayQueue::getLast() const{
	if(isEmpty()){throw EmptyQueueException("ArrayQueue::getLast");}
	return myArray[(myLast-1+myCapacity) % myCapacity];
}

void ArrayQueue::append(Item it){
	if(isFull()){throw FullQueueException("ArrayQueue::append()");}
	myArray[myLast]=it;
	myLast = ((myLast+1) % myCapacity);
	mySize++;
}

Item ArrayQueue::remove(){
	if(isEmpty()){throw EmptyQueueException("ArrayQueue::remove()");}
	Item result = myArray[myFirst];
	mySize--;
	myFirst=((myFirst+1)% myCapacity);
	return result;
}

