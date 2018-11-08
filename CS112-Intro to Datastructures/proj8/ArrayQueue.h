/* ArrayQueue.h declares a Queue class using a dynamic array.
* Begun by: Joel Adams, for CS 112 at Calvin College.
* Student name:Joshua Maguire
* Date:4/9/13
* 
* Class Invariant: 
*    mySize == 0 ||
*    mySize > 0 && myArray[myFirst] == getFirst()
*               && myArray[myLast-1] == getLast().
* 
*  (When I am not empty:
*     myFirst is the index of my oldest value;
*     myLast is the index of the spot where the next
*       item to be appended will be placed.)      
*/


#ifndef ARRAY_QUEUE_H_
#define ARRAY_QUEUE_H_

#include "QueueException.h"
#include "ArrayQueue.h"
#include <cstring>      // memcpy()
using namespace std;

template<class Item>

class ArrayQueue {
public:
	ArrayQueue(unsigned size);
	ArrayQueue(const ArrayQueue& original);
	virtual ~ArrayQueue();
	ArrayQueue& operator=(const ArrayQueue& original);
	unsigned getSize() const;
	unsigned getCapacity() const;
	bool isEmpty() const;
	bool isFull() const;
	Item getFirst() const;
	Item getLast() const;
	void append(Item it);
	Item remove();
	void setCapacity(unsigned cap);

protected:
	virtual void makeCopyOf(const ArrayQueue& original);
private:
	unsigned mySize;       // number of items I contain
	unsigned myCapacity;   // how many items I can store
	unsigned myFirst;      // index of oldest item (if any)
	unsigned myLast;       // index of next available spot for append (if any)
	Item*    myArray;      // dynamic array of items

	friend class ArrayQueueTester;
};
template<class Item>
ArrayQueue<Item>::ArrayQueue(unsigned size)
{
	if(size<1){throw QueueException ("ArrayQueue::ArrayQueue","capacity was less than 1");}
	mySize = 0;
	myCapacity = size;
	myFirst = 0;
	myLast = 0;
	myArray = new Item[size];

}
template<class Item>
ArrayQueue<Item>::ArrayQueue(const ArrayQueue<Item>& original) {
	makeCopyOf(original);
}
template<class Item>
void ArrayQueue<Item>::makeCopyOf(const ArrayQueue<Item>& original) {
	mySize = original.mySize;
	myCapacity = original.myCapacity;
	myFirst = original.myFirst;
	myLast = original.myLast;
	myArray = new Item[myCapacity];
	memcpy(myArray, original.myArray, myCapacity*sizeof(Item) );
}
template<class Item>
ArrayQueue<Item>::~ArrayQueue() {
	delete [] myArray;
	myArray = NULL;
	mySize = myFirst = myLast = 0;
}

template<class Item>
ArrayQueue<Item>& ArrayQueue<Item>::operator=(const ArrayQueue<Item>& aQueue) {
	if (this != &aQueue) {
		delete [] myArray;;
		makeCopyOf(aQueue);
	}
	return *this;
}
template<class Item>
bool ArrayQueue<Item>::isEmpty() const {
	return mySize == 0;
}
template<class Item>
bool ArrayQueue<Item>::isFull() const {
	return getSize() == myCapacity;
}
template<class Item>
unsigned ArrayQueue<Item>::getCapacity() const {
	return myCapacity;
}
template<class Item>
unsigned ArrayQueue<Item>::getSize() const {
	return mySize;
}
template<class Item>
Item ArrayQueue<Item>::getFirst() const{
	if(isEmpty()){throw EmptyQueueException("ArrayQueue::getFirst");}
	return myArray[myFirst];
}
template<class Item>
Item ArrayQueue<Item>::getLast() const{
	if(isEmpty()){throw EmptyQueueException("ArrayQueue::getLast");}
	return myArray[(myLast-1+myCapacity) % myCapacity];
}
template<class Item>
void ArrayQueue<Item>::append(Item it){
	if(isFull()){throw FullQueueException("ArrayQueue::append()");}
	myArray[myLast]=it;
	myLast = ((myLast+1) % myCapacity);
	mySize++;
}
template<class Item>
Item ArrayQueue<Item>::remove(){
	if(isEmpty()){throw EmptyQueueException("ArrayQueue::remove()");}
	Item result = myArray[myFirst];
	mySize--;
	myFirst=((myFirst+1)% myCapacity);
	return result;
}

template<class Item>
void ArrayQueue<Item>::setCapacity(unsigned cap)
{
	if(cap<1||cap<mySize){throw QueueException ("ArrayQueue::setCapacity()","new capacity is less than 1 and or less than mySize!");}
	if(mySize>0)
	{
		Item* newArray = new Item[cap];
		unsigned tempIndex = myFirst;
		for (unsigned i = 0;i<mySize;i++)
		{
			newArray[i]=myArray[tempIndex];
			tempIndex=(tempIndex+1)%myCapacity;
		}
		delete [] myArray;
		myArray = newArray;
		myFirst=0;
		myLast=mySize;

	}
	myCapacity = cap;


}
#endif /*ARRAY_QUEUE_H_*/
