/* Stack.h provides a (dynamic-array-based) Stack class.
 * Joel Adams, for CS 112 at Calvin College.
 * Student Name:Joshua MAguire
 * Date:3/26/2013
 * 
 * Invariant: myTop == 0 && isEmpty() && !isFull()
 *         || myTop == myCapacity && !isEmpty() && isFull()
 *         || myTop > 0 && myTop < myCapacity && !isEmpty() && !isFull().
 * Notes: 
 * 1. Member myTop always contains the index of the next empty space in myArray
 *        (the index of the array element into which the next pushed item will be placed).
 * 2. Sending push() to a full Stack throws the exception Stack::Overflow.
 * 3. Sending pop() or getTop() to an empty Stack throws the exception Stack::Underflow.
 */

#ifndef STACK_H_
#define STACK_H_

#include "StackException.h"
#include <string>
#include <iostream>
using namespace std;

template <class Item>
class Stack {
public:
	Stack(unsigned size);
	Stack(const Stack& original);
	~Stack();
	Stack& operator=(const Stack& original);
	bool isEmpty() const;
	bool isFull() const;
	void push(Item it);
	Item getTop() const;
	Item pop();
	unsigned getSize() const;
	unsigned getCapacity() const;
	void setCapacity(unsigned newCapacity);
protected:
	void makeCopyOf(const Stack& original);
	
private:
	unsigned myCapacity;
	unsigned myTop;
	Item*    myArray;
	friend class StackTester;
	friend class Decoder;
};
template <class Item>
Stack<Item>::Stack(unsigned size)
{
	if(size>0)
	{
		myTop = 0;
		myCapacity = size;
		myArray = new Item[size];
	}
	else
	{
		throw StackException("stack(size)", "size must be positive!");
	}
}

/* copy constructor
 * Parameter: original, a Stack (const reference).
 * Postcondition: I am a copy of original.
 */
template <class Item>
Stack<Item>::Stack(const Stack<Item>& original) {
	makeCopyOf(original);
}

/* utility method containing code refactored from
 *  the copy constructor and operator=.
 * Parameter: original, a Stack (const reference).
 * Postcondition: I am a copy of original.
 */
template <class Item>
void Stack<Item>::makeCopyOf(const Stack<Item>& original) {
	myCapacity = original.myCapacity;
	myArray = new Item[myCapacity];

	for (unsigned i = 0; i < myCapacity; i++) {
		myArray[i] = original.myArray[i];
	}
	myTop = original.myTop;
}

/* destructor
 * Postcondition: myCapacity == 0 && myTop == 0
 *             && myArray has been deallocated.
 */
template <class Item>
Stack<Item>::~Stack() {
	delete [] myArray;//error here
	myArray = NULL;
	myCapacity = 0;
	myTop = 0;
}

/* assignment operator
 * Parameter: original, a Stack (const reference).
 * Postcondition: I am a copy of original
 *              && I have been returned.
 */
template <class Item>
Stack<Item>& Stack<Item>::operator=(const Stack<Item>& original) {
	if (this != &original) {
		delete [] myArray;
		makeCopyOf(original);
	}
	return *this;
}
/* isEmpty method
 * Parameter:
 * Postcondition: returns true/false
 */
template <class Item>
bool Stack<Item>::isEmpty() const
{
	if(myTop==0){return true;}return false;//one liner! OH YEAH
}
/* isFull method.
 * returns true/false...
 */
template <class Item>
bool Stack<Item>::isFull() const
{
	if(myCapacity==myTop){return true;}
	return false;
}
/* push() method - puts new item on stack.
 * Parameter:Item it - item to be put on stack
 * Postcondition: Item it put on top of stack.
 */
template <class Item>
void Stack<Item>::push(Item it)
{
	if(myTop==myCapacity)
	{
		throw StackException("push();","Stack is full!");
	}else
	{
		myArray[myTop]=it;
		myTop++;
	}
}
/* getTop() method - returns Item from top of stack.
 * Postcondition: top Item returned...
 */
template <class Item>
Item Stack<Item>::getTop() const
{
	if(myTop>0)
	{
		return myArray[myTop-1];
	} else
	{
		throw StackException("getTop()", "stack underflow");
	}
}
/* pop() method - takes off top item from stack and returns Item.
 * Postcondition: top Item taken off stack. and returned
 */
template <class Item>
Item Stack<Item>::pop()
{
	if(myTop==0)
	{
		throw StackException("pop()","stack underflow...Stack is empty!");
	}else
	{
		myTop--;
		return(myArray[myTop]);
	}
}
/* getSize method - returns the current size of stack by returning myTop.
 * Postcondition: myTop aka current stack size returned.
 */
template <class Item>
unsigned Stack<Item>::getSize() const
{
	return(myTop);
}
/* getCapacity method - returns the max size of stack by returning myCapacity.
 * Postcondition: myCapacity aka max stack size returned.
 */
template <class Item>
unsigned Stack<Item>::getCapacity() const
{
	return(myCapacity);
}
/* setCapacity method - resized myCapacity aka the Stacks array.
 * Parameter unsigned newCapacity - size of desired new capacity.
 *precondition: myArray is small..
 * Postcondition: myArray is bigger, values if any were coppied.
 */
template <class Item>
void Stack<Item>::setCapacity(unsigned newCapacity)
{
	if(newCapacity <= myTop) 
	{
		throw StackException("setCapacity()","newCapacity must be greater than current size(getSize()).");
	}
	Item* newArray = new Item[newCapacity];
	for(unsigned i=0;i<myCapacity;i++) //fill new array with same values
	{
		newArray[i]=myArray[i];
	}
	delete [] myArray;
	myArray = newArray; //set new array to myArray
	myCapacity=newCapacity;//update capacity
}


#endif

