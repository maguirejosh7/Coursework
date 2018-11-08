///* Stack.cpp defines the dynamically allocated (array-based ) Stack operations.
// * Joel Adams, for CS 112 at Calvin College.
// * Student Name:Joshua MAguire
// * Date:3/26/2013
// */
//
////#include "Stack.h"
//
///* explicit-value constructor
// * Parameter: size, an unsigned value.
// * Precondition: size > 0.
// * Postcondition: myTop == 0 && myCapacity == size
// *              && myArray contains the address of a dynamic array of 'size' entries.
// */
//Stack::Stack(unsigned size)
//{
//	if(size>0)
//	{
//		myTop = 0;
//		myCapacity = size;
//		myArray = new Item[size];
//	}
//	else
//	{
//		throw StackException("stack(size)", "size must be positive!");
//	}
//}
//
///* copy constructor
// * Parameter: original, a Stack (const reference).
// * Postcondition: I am a copy of original.
// */
//Stack::Stack(const Stack& original) {
//	makeCopyOf(original);
//}
//
///* utility method containing code refactored from
// *  the copy constructor and operator=.
// * Parameter: original, a Stack (const reference).
// * Postcondition: I am a copy of original.
// */
//void Stack::makeCopyOf(const Stack& original) {
//	myCapacity = original.myCapacity;
//	myArray = new Item[myCapacity];
//
//	for (unsigned i = 0; i < myCapacity; i++) {
//		myArray[i] = original.myArray[i];
//	}
//	myTop = original.myTop;
//}
//
///* destructor
// * Postcondition: myCapacity == 0 && myTop == 0
// *             && myArray has been deallocated.
// */
//Stack::~Stack() {
//	delete [] myArray;
//	myArray = NULL;
//	myCapacity = 0;
//	myTop = 0;
//}
//
///* assignment operator
// * Parameter: original, a Stack (const reference).
// * Postcondition: I am a copy of original
// *              && I have been returned.
// */
//Stack& Stack::operator=(const Stack& original) {
//	if (this != &original) {
//		delete [] myArray;
//		makeCopyOf(original);
//	}
//	return *this;
//}
//
//bool Stack::isEmpty() const
//{
//	if(myTop==0){return true;}return false;//one liner! OH YEAH
//}
//bool Stack::isFull() const
//{
//	if(myCapacity==myTop){return true;}
//	return false;
//}
//void Stack::push(Item it)
//{
//	if(myTop==myCapacity)
//	{
//		throw StackException("push();","Stack is full!");
//	}else
//	{
//		myArray[myTop]=it;
//		myTop++;
//	}
//}
//Item Stack::getTop() const
//{
//	if(myTop>0)
//	{
//		return myArray[myTop-1];
//	} else
//	{
//		throw StackException("getTop()", "stack underflow");
//	}
//}
//Item Stack::pop()
//{
//	if(myTop==0)
//	{
//		throw StackException("pop()","stack underflow...Stack is empty!");
//	}else
//	{
//		myTop--;
//		return(myArray[myTop]);
//	}
//}
//unsigned Stack::getSize() const
//{
//	return(myTop);
//}
//unsigned Stack::getCapacity() const
//{
//	return(myCapacity);
//}
//void Stack::setCapacity(unsigned newCapacity)
//{
//	if(newCapacity <= myTop)
//	{
//		throw StackException("setCapacity()","newCapacity must be greater than current size(getSize()).");
//	}
//	//Item* newArray = new Item[newCapacity];
//	//for(unsigned i=0;i<myCapacity;i++)
//	//{
//	//	newArray[i]=myArray[i];
//	//}
//	//delete [] myArray;
//	//myArray = newArray;
//	//delete [] newArray;//looks deletes myArray too
//	myCapacity=newCapacity;
//}
//
//
//
//
//
//
//
