/* Vec.h provides a simple vector class named Vec.
 * Student Name: Nathan Terschak, Joshua Maguire
 * Date: 2/26/2013
 * Begun by: Joel C. Adams, for CS 112 at Calvin College.
 */

#ifndef VEC_H_
#define VEC_H_
#include <fstream>
#include <iostream>
#include <stdexcept>
#include <cassert>
using namespace std;

template<class Item>

class Vec {
public:
	Vec();
	Vec(unsigned size);
	Vec(const Vec& original);
	virtual ~Vec();
	Vec& operator=(const Vec& original);
	void setSize(unsigned newSize);
	unsigned getSize() const;
	void setItem(unsigned index, const Item& it);
	Item getItem(unsigned index) const;
	bool operator==(const Vec& v2) const;
	void writeTo(ostream& out) const;
	void readFrom(istream& in);
	const Item& operator[] (unsigned index) const;
	Item& operator[] (unsigned index) ;
	bool operator!=(Vec& v) const;
	void readFrom(string fileName);
	void writeTo(string fileName) const;
	Vec operator+(const Vec& v1) const;
	Vec operator-(const Vec& v)const;
	double operator*(const Vec& v1) const;
private:
	unsigned mySize;
	Item * myArray;
	friend class VecTester;
	friend class MatrixTester;
};

template<class Item>
Vec<Item>::Vec() {
	/*This is the Vec default constructor.
	 * it sets mySize to 0 and myArray to NULL.
	 *
	 * precondition:
	 * postcondition: mySize=0, myArray=NULL.
	 *
	 */

	mySize = 0;
	myArray = NULL;
}

template<class Item>
Vec<Item>::Vec(unsigned size) {
	/*This is the explicit constructor for Vecs.
	 * It makes a vec of size size and sets the values
	 * to 0.
	 *
	 * @param unsigned size
	 *
	 * precondition:size is valid positive int, greater than -1.
	 * postcondition:Array of size size created, values are all 0.
	 */
	mySize = size;
	myArray = new Item[size];
	for (unsigned i = 0; i < size; i++) {
		myArray[i] = 0;
	}
}

template<class Item>
Vec<Item>::Vec(const Vec<Item>& original) {
	/*This is the copy constructor. It copies original array
	 * to myArray using this syntax:Vec v2(v1);..so v1 is copied to v2.
	 *
	 * @param Vec& original is a valid vec, could be null though.
	 *
	 * precondition: original is a valid vec
	 * postcondition: myArray is now a copy of original.
	 *
	 */
	mySize = original.mySize;
	if (original.mySize > 0) {
		myArray = new Item[mySize];
		for (unsigned i = 0; i < mySize; i++) {
			myArray[i] = original.myArray[i];
		}
	} else {
		myArray = NULL;
	}

}

template<class Item>
Vec<Item>::~Vec() {
	/*This id the descructor. It resets myArray and size to null and 0.
	 *
	 * precondition: myArray and mySize are anything...
	 * postcondition: values reset to 0 and NULL.
	 *
	 */
	delete [] myArray;
	myArray = NULL;
	mySize = 0;
}

template<class Item>
Vec<Item>& Vec<Item>::operator=(const Vec& original) {
	/*This is the method for the operator =.
	 * It makes myArray equal to original array. ex. v2 = v1;
	 *
	 * @param Vec& original
	 *
	 * precondition: original is a valid array, could be null and 0.
	 * postcondition: myArray and mySize are the same as originals values.
	 *
	 */
	if (this != &original) {
		if (mySize != original.mySize) {
			if (mySize > 0) {
				delete [] myArray;
				myArray = NULL;
			}
			if (original.mySize > 0) {
				myArray = new Item[original.mySize];
			}
		}
		mySize = original.mySize;
		for (unsigned i = 0; i < mySize; i++) {
			myArray[i] = original.myArray[i];
		}
	}
	return *this;
}

template<class Item>
unsigned Vec<Item>::getSize() const {
	/*This accessor method returns mySize of the Vec.
	 *
	 * precondition: none
	 * postcondition: none
	 *
	 */
	return mySize;
}

template<class Item>
void Vec<Item>::setItem(unsigned index, const Item& it) {
	/*This mutator recieves an index and a number.
	 * It changes myArray at index to number.
	 *
	 * @param unsigned index
	 * @param const Item& it
	 *
	 * precondition: index is greater than mySize
	 * postcondition: value of myArray at index is now number.
	 *
	 */
	if (index >= mySize) {
		throw range_error("Invalid Index");
	} else {
		myArray[index] = it;
	}
}
template<class Item>
Item Vec<Item>::getItem(unsigned index) const {
	/*This accessor method returns the number in the array
	 * at index. ex. vec.getItem(2)
	 *
	 * @param unsigned index
	 *
	 * precondition:index must be in the range of myArray
	 * postcondition:returns the number at index of myARray
	 *
	 */
	if (index >= mySize) {
		throw range_error("Invalid Index");
	} else {
		return myArray[index];
	}
}
template<class Item>
void Vec<Item>::setSize(unsigned newSize) {
	/*This method changes the size of myArray to newSize.
	 * It keeps current numbers in the Array, clips off extra if making
	 * array smaller and adds 0s if array is being made bigger.
	 * ex. v0.setSize(3);
	 *
	 * @param unsigned newSize
	 *
	 * precondition: newSize is > 0
	 * postcondition: myArray is now newSize big.
	 *
	 */
	if (mySize != newSize) {
		if (newSize == 0) {
			delete [] myArray;
			myArray = NULL;
			mySize = 0;
		} else {
			Item * newArray = new Item[newSize];
			if (mySize < newSize) {
				for (unsigned i = 0; i < mySize; i++) {
					newArray[i] = myArray[i];
				}
				for (unsigned i = mySize; i < newSize; i++) {
					newArray[i] = 0;
				}
			} else {
				for (unsigned i = 0; i < newSize; i++) {
					newArray[i] = myArray[i];
				}
			}
			mySize = newSize;
			delete [] myArray;
			myArray = newArray;
		}
	}
}
template<class Item>
bool Vec<Item>::operator==(const Vec<Item>& v2) const{
	/*This operator method returns true
	 * if myArray and Vec& v2 are equal, and
	 * vice versus.
	 *
	 * @param const Vec& v2
	 *
	 * precondition:Vec& v2 is a valid vec, could be null
	 * postcondition: returns true of false.
	 *
	 */
	if (mySize != v2.mySize) {
		return false;
	}
	for (unsigned i = 0; i < mySize; i++) {
		if (myArray[i] != v2.myArray[i]) {
			return false;
		}
	}
	return true;
}
template<class Item>
void Vec<Item>::writeTo(ostream& out) const {
	/*This method recieves any outstream and prints
	 * the contents of myArray to that outstream.
	 * could be cout... looks like v1.writeTo(fout);
	 *
	 * @param ostream& out
	 *
	 * precondition: out is a valid ostream
	 * postcondition: prints to out.
	 *
	 */
	for (unsigned i = 0; i < mySize; i++) {
		out << myArray[i] << "\n";
	}
}
template<class Item>
void Vec<Item>::readFrom(istream& in) {
	/*This method reads from the instream in.
	 *
	 * @paramistream& in
	 *
	 * precondition: in is a valid instream
	 * postcondition:myArray filled with contents of in.
	 *
	 */
	for (unsigned i = 0; i < mySize; i++) {
		in >> myArray[i];
	}
}
template<class Item>
const Item& Vec<Item>::operator[] (unsigned index) const {
	/*This operator allows values in myArray at position index
	 * to be called like this v1[3].
	 *
	 * @param unsigned index
	 *
	 * precondition: index is valid index of myArray
	 * postcondition: number at index returned.
	 *
	 */
	if (index >= mySize) {
		throw range_error("Invalid Index");
	} else {
		return myArray[index];
	}
}
template<class Item>
Item& Vec<Item>::operator[] (unsigned index) {
	/*This operator method is similar to the one above, but is
	 * used in different circumstances.
	 *
	 * @param unsigned index
	 *
	 * precondition: index is valid index of myArray
	 * postcondition: number at index returned.
	 *
	 */
	if (index >= mySize) {
		throw range_error("Invalid Index");
	} else {
		return myArray[index];
	}
}
template<class Item>
bool Vec<Item>::operator!=(Vec<Item>& v) const{
	/*This operator method compares
	 * myArray and vec v to see if they equal eachother.
	 * returns a bool...
	 *
	 * @param Vec& v
	 *
	 * precondition: Vec& c is a valid vec, could be null...
	 * postcondition: returns bool
	 *
	 *made by Joshua Maguire
	 */
	if(mySize!=v.mySize){return true;}
	else{

		for(unsigned i=0;i<mySize;i++){
			if(v.myArray[i]!=myArray[i]){return true;}
		}
		return false;
	}
}
template<class Item>
void Vec<Item>::readFrom(string fileName) {
	/*This method reads from a file named fileName.
	 *
	 * @param string fileName
	 *
	 * precondition: fileName is the name of a txt
	 * postcondition: myArray filled with contents of fileName.txt
	 *
	 * By Joshua Maguire
	 */
	ifstream fin(fileName.c_str());
	assert( fin.is_open() );
	fin >> mySize;
	delete[]myArray;
	if(mySize>0){
		myArray = new Item[mySize];
	}
	for(unsigned i=0;i<mySize;i++){
		fin >> myArray[i];
	}
	fin.close();

}
template<class Item>
void Vec<Item>::writeTo(string fileName) const {
	/*This method is similar to the above method, except it writes
	 * to the fileName.txt.
	 *
	 * @param string fileName
	 *
	 * precondition: fileNAme is name of valid txt
	 * postcondition: contents of fileName written to txt.
	 *
	 * By Nathan Terschak
	 */
	ofstream fout( fileName.c_str() );
	fout << mySize << "\n";
	for (unsigned i = 0; i < mySize; i++) {
		fout << myArray[i] << "\n";
	}
	fout.close();
}
template<class Item>
Vec<Item> Vec<Item>::operator+(const Vec& v1) const {
	/*This operator method adds the contents of
	 * myArray and vec v1 together, and returns it as a new vec.
	 *
	 * @param const Vec& v1
	 *
	 * precondition: vecs are all valid vecs
	 * postcondition: vecs added, returns them as new vec(returnVec).
	 *
	 * By Nathan Terschak
	 */
	if (mySize == v1.getSize()) {
		Vec returnVec(mySize);
		for (unsigned i = 0; i < mySize; i++) {
			returnVec.myArray[i] = myArray[i] + v1.myArray[i];
		}
		return returnVec;
	}
	throw invalid_argument("The two Vecs have different sizes");
}
template<class Item>
Vec<Item> Vec<Item>::operator-(const Vec& v)const{
	/*This operator method is the same as the method
	 * above except it subtracts myArray from v.myArray.
	 *
	 * @param const Vec& v
	 *
	 * precondition: vecs are all valid vecs
	 * postcondition: vecs added, returns them as new vec(returnVec).
	 *
	 * By Joshua Maguire
	 */
	if(mySize==v.mySize){
		Vec newVec(mySize);

		for(unsigned i=0; i<mySize; i++){
			newVec.myArray[i]=myArray[i]-v.myArray[i];
		}
		return newVec;
	}
	else{
		throw invalid_argument ("vecs were not same size");
	}
}
template<class Item>
double Vec<Item>::operator*(const Vec<Item>& v1) const {
	/*This operator method is the same as the above method
	 * except it multiplies them together.
	 *
	 * @param const Vec& v1
	 *
	 * precondition: vecs are all valid vecs
	 * postcondition: vecs added, returns them as new vec(returnVec).
	 *
	 * By Nathan Terschak
	 */
	if (mySize == v1.getSize() ) {
		double dProd = 0;
		for (unsigned i = 0; i < mySize; i++) {
			dProd += myArray[i]*v1.myArray[i];
		}
		return dProd;
	}
	throw invalid_argument("The two Vecs have different sizes");
}





#endif /*VEC_H_*/
