/* Vec.cpp defines the methods for Vec, a simple vector class.
 * Student:Joshua Maguire
 * Date:2/19/13
 * Begun by: Joel C. Adams, for CS 112 at Calvin College.
 */

#include "Vec.h"
#include <stdexcept>

Vec::Vec() {
	mySize=0;
	myArray=NULL;
}
Vec::Vec(unsigned size) {
	mySize=size;
	myArray = new Item[size];
	for(unsigned i=0;i<mySize;i++){
				myArray[i]=0;
			}
}
Vec::~Vec() {
	delete[] myArray;
	mySize=0;
	myArray=NULL;
}
Vec::Vec(const Vec& original) {//makes copy of original
	//make myarray copy of original
	mySize=original.mySize;
	if(original.mySize>0){
		Item *array = new Item[mySize];
		myArray=array;
		for(unsigned i=0;i<original.mySize;i++){
			myArray[i]=original.myArray[i];
		}
	}
	else{myArray=NULL;}
}
Vec& Vec::operator=(const Vec& original) {//copies orig to myArray
	if(myArray!=original.myArray){


		if(mySize>0){delete [] myArray; myArray=NULL;}	//1
		if(original.mySize>0){							//2
			Item *newArray = new Item[original.mySize];
			myArray=newArray;
		}
		mySize=original.mySize;							//3

	}
	for(unsigned i=0;i<original.mySize;i++){
		myArray[i]=original.myArray[i];
	}
	return *this;
}
unsigned Vec::getSize() const {
	return mySize;
}
void Vec::setItem(unsigned index, const Item& it) {
	if(myArray==NULL||index < 0||index >= mySize){
		throw range_error ("index not in array range");
	}
	myArray[index]=it;
}
Item Vec::getItem(unsigned index) const {
	if(myArray==NULL||index < 0||index >= mySize){
		throw range_error ("index not in array range");
	}
	return(myArray[index]);
}
void Vec::setSize(unsigned newSize) {
	if(mySize!=newSize){
		if(newSize==0){
			delete[]myArray;
			myArray=NULL;
			mySize=0;
		}
		else{
			Item *array = new Item[newSize];
			if(newSize>mySize){
				for(unsigned i=0;i<mySize;i++){
					array[i]=myArray[i];
				}
				for(unsigned i=mySize;i<newSize;i++){
					array[i]=myArray[i];
				}
			}
			else{
				for(unsigned i=0;i<newSize;i++){
					array[i]=myArray[i];
				}
			}
			mySize=newSize;
			delete[]myArray;
			myArray=array;
		}
	}
}
bool Vec::operator==(const Vec& v2) {
	if(mySize!=v2.mySize){return false;}
	else{
		for(unsigned i=0;i<mySize;i++){
			if(v2.myArray[i]!=myArray[i]){return false;}
		}
		return true;
	}
}
void Vec::writeTo(ostream& out) const {
	for(unsigned i=0;i<mySize;i++){
		out << myArray[i] << "\n" << flush;
	}

  }
void Vec::readFrom(istream& in) {
	for(unsigned i=0;i<mySize;i++){
		in >> myArray[i];
	}
   }
