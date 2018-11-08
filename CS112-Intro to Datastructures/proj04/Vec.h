/* Vec.h provides a simple vector class named Vec.
 * Student Name: Anna Brink
 * Date: February 26, 2013
 * Begun by: Joel C. Adams, for CS 112 at Calvin College.
 */

#ifndef VEC_H_
#define VEC_H_

#include <iostream>
#include <fstream>
#include <stdexcept>
#include <cassert>
#include <string>
using namespace std;

template <class Item>

class Vec {
public:
	/** Initializes the size to zero and the array to NULL
	 * \author Anna Brink
	 */
	Vec();

	/** Initializes a vec of the specified size.
	 * \param size The size of the vec.
	 * \author Anna Brink
	 */
	Vec(unsigned size);

	/** Copies a vector.
	 * \param original Vector that is copied.
	 * \author Anna Brink
	 */
	Vec(const Vec<Item>& original);

	virtual ~Vec();

	/** Copies the other vector.
	 * \param original Vector that is copied.
	 * \return a reference to this vec.
	 * \author Anna Brink
	 */
	Vec& operator=(const Vec<Item>& original);

	/** Sets the size of the vector.
	 * \param newSize The size which will be set for the vector.
	 * \author Anna Brink
	 */
	void setSize(unsigned newSize);

	/** Gets the size of the vector.
	 * \return The size of the vector.
	 * \author Anna Brink
	 */
	unsigned getSize() const;

	/** Sets the value of a particular item.
	 * \param index The index (from 0 through size-1) of the item to change.
	 * \param it The item that will be stored at index.
	 * \author Anna Brink
	 */
	void setItem(unsigned index, const Item& it);

	/** Gets the value of a particular item.
	 * \param index The index (from 0 through size-1) of the item to get.
	 * \return The item.
	 * \author Anna Brink
	 */
	Item getItem(unsigned index) const;


	/** Determines if the two vectors are equal.
	 * \param v2 The vector compared to the vector the function is called on.
	 * \return true if the vectors are equal and false otherwise.
	 * \author Anna Brink
	 */
	bool operator==(const Vec<Item>& v2) const;

	/** Writes the vector one element at a time to an ostream.
	 * \param  out The ostream which the elements are written to.
	 * \author Anna Brink
	 */
	void writeTo(ostream& out) const;

	/** Reads values from an istream and assigns them to the vector.
	 * \param in The stream used to input the values.
	 * \author Anna Brink
	 */
	void readFrom(istream& in);

	/** Retrieves the value at the indicated index from the Vec
	 * \param index The index of the item to retrieve.
	 * \return The item at the index.
	 * \author Anna Brink
	 */
	const Item & operator[](unsigned index) const;

	/** Sets the value at the indicated index to the assigned item.
	 * \param index The index where the Item is set.
	 * \author Anna Brink
	 */
	Item & operator[](unsigned index);

	/** Determines if the vectors are not equal.
	 * \param v2 The vector compared to the vector the function is called on.
	 * \return true if the vectors are not equal and false otherwise.
	 * \author Anna Brink
	 */
	bool operator!=(const Vec<Item>& v2) const;

	/** Fills the vector the function is called on with the values in the file
	 * \param fileName The name of the file which contains an integer determining the size and values to store in the vector.
	 * \author Anna Brink
	 */
	void readFrom(const string& fileName);

	/** Writes the vector out to the file one element at a time after printing its size.
	 * \param fileName The name of the file which will have the size followed by the elements each on a new line.
	 * \author Anna Brink
	 */
	void writeTo(const string& fileName);

	/** Adds two vectors together by adding corresponding elements.
	 * \param v2 The vector added to the vector the function is called on.
	 * \return The Vec containing elements which are the sums of corresponding
	 * 			elements in v2 and the vector the function is called on.
	 * \author Anna Brink
	 */
	Vec<Item> operator+(const Vec<Item>& v2) const;

	/** Subtracts a vector from the vector the function is called upon
	 * \param v2 The vector subtracted from the vector the function is called upon.
	 * \return The resulting vector
	 * \author Anna Brink
	 */
	Vec<Item> operator-(const Vec<Item>& v2) const;

	/** Finds the dot product of the vector the function is called on and the vector passed.
	 * \param v2 The vector passed to the function.
	 * \return The dot product.
	 * \author Anna Brink
	 */
	double operator*(const Vec& v2) const;

private:
	unsigned mySize;
	Item * myArray;

	friend class VecTester;
};

template <class Item>
Vec<Item>::Vec() {
	mySize = 0;
	myArray = NULL;
}

template <class Item>
Vec<Item>::Vec(unsigned size) {
	mySize = size;
	myArray = new Item[mySize] ();
}

template <class Item>
Vec<Item>::Vec(const Vec<Item>& original) {
	mySize = original.mySize;
	if( mySize > 0) {
		myArray = new Item[mySize];
		for (unsigned i = 0; i < mySize; i++) {
			*(myArray + i) = *(original.myArray + i);
		}
	}
	else {
		myArray = NULL;
	}
}

template <class Item>
Vec<Item>::~Vec() {
	delete [] myArray;
	mySize = 0;
	myArray = NULL;
}

template <class Item>
Vec<Item>& Vec<Item>::operator=(const Vec<Item>& original) {

	if (this != &original) {
		if (mySize != original.mySize) {
			if (mySize >= 0) {
				delete [] myArray;
				myArray = NULL;
			}
			if (original.mySize > 0) {
				myArray = new Item[original.mySize];
			}
			mySize = original.mySize;
		}
		for (unsigned i = 0; i < mySize; i++) {
			myArray[i] = original.myArray[i];
		}

	}
	return *this;

}

template <class Item>
void Vec<Item>::setSize(unsigned newSize) {
	if (mySize != newSize) {
		if (newSize == 0) {
			delete [] myArray;
			myArray = NULL;
		}
		else {
			Item * newArray = new Item[newSize];

			if (mySize < newSize) {
				for (unsigned i = 0; i < mySize; i++) {
					newArray[i] = myArray[i];
				}
				for (unsigned i = mySize; i < newSize; i++) {
					newArray[i] = 0;
				}
			}
			else {
				for (unsigned i = 0; i < newSize; i++) {
					newArray[i] = myArray[i];
				}
			}

			delete [] myArray;
			myArray = newArray;
		}
		mySize = newSize;
	}
}


template <class Item>
unsigned Vec<Item>::getSize() const {
	return mySize;
}

template <class Item>
void Vec<Item>::setItem(unsigned index, const Item& it) {
	if (myArray == NULL) {
		throw range_error("This vector was null.");
	}
	else {
		if (mySize <= index) {
			throw range_error("This index is beyond the end of Vec.");
		}
		else {
			myArray[index] = it;
		}
	}
}

template <class Item>
Item Vec<Item>::getItem(unsigned index) const {
	if (myArray == NULL) {
		throw range_error("This vector was null.");
	}
	else {
		if (mySize <= index) {
			throw range_error("This index is beyond the end of Vec.");
		}
		else {
			return myArray[index];
		}
	}
}

template <class Item>
bool Vec<Item>::operator==(const Vec<Item>& v2) const {
	if (mySize != v2.getSize()) {
		return false;
	}
	else {
		for (unsigned i = 0; i < mySize; i++) {
			if (myArray[i] != v2.getItem(i)) {
				return false;
			}
		}
		return true;
	}
}

template <class Item>
void Vec<Item>::writeTo(ostream& out) const {
	for (unsigned i = 0; i < mySize; i++) {
		out << myArray[i] << endl;
	}
}

template <class Item>
void Vec<Item>::readFrom(istream& in) {
	for (unsigned i = 0; i < mySize; i++) {
		in >> myArray[i];
	}
}

template <class Item>
const Item & Vec<Item>::operator[](unsigned index) const {
	if (index >= mySize) {
		throw range_error("Vec subscript: index too large.");
	}
	return myArray[index];
}

template <class Item>
Item & Vec<Item>::operator[](unsigned index) {
	if (index >= mySize) {
		throw range_error("Vec subscript: index too large.");
	}
	return myArray[index];
}

template <class Item>
bool Vec<Item>::operator!=(const Vec<Item>& v2) const {
	if (mySize != v2.mySize) {
		return true;
	}
	else {
		for (unsigned i = 0; i < mySize; i++) {
			if (myArray[i] != v2.myArray[i]) {
				return true;
			}
		}
		return false;
	}
}

template <class Item>
void Vec<Item>::readFrom(const string& fileName) {
	unsigned size;
	ifstream fin(fileName.c_str());
	assert(fin.is_open());
	fin >> size;
	if (mySize != size) {
		delete [] myArray;
		mySize = size;
		if (mySize == 0) {
			myArray = NULL;
		}
		else {
			myArray = new Item[size];
		}
	}
	for (unsigned i = 0; i < mySize; i++) {
		fin >> myArray[i];
	}
	fin.close();
}

template <class Item>
void Vec<Item>::writeTo(const string& fileName) {
	ofstream fout(fileName.c_str());
	assert(fout.is_open());
	fout << mySize << endl;
	for (unsigned i = 0; i < mySize; i++) {
		fout << myArray[i] << endl;
	}
	fout.close();
}

template <class Item>
Vec<Item> Vec<Item>::operator+(const Vec<Item>& v2) const {
	Vec<Item> v;
	if (mySize != v2.mySize) {
		throw invalid_argument("Vec operator+: the Vecs were not the same size.");
	}
	if (mySize != 0) {
		v.setSize(mySize);
		for (unsigned i = 0; i < mySize; i++) {
			v[i] = myArray[i] + v2.myArray[i];
		}
	}
	return v;
}

template <class Item>
Vec<Item> Vec<Item>::operator-(const Vec<Item>& v2) const {
	Vec<Item> v;
	if (mySize != v2.mySize) {
		throw invalid_argument("Vec operator-: The Vecs were not the same size.");
	}
	if (mySize != 0) {
		v.setSize(mySize);
		for (unsigned i = 0; i < mySize; i++) {
			v[i] = myArray[i] - v2.myArray[i];
		}
	}

	return v;
}

template <class Item>
double Vec<Item>::operator*(const Vec<Item>& v2) const {
	double sum = 0;
	if (mySize != v2.mySize) {
		throw invalid_argument("Vec operator-: The Vecs were not the same size.");
	}
	if (mySize != 0) {
		for (unsigned i = 0; i < mySize; i++) {
			sum += myArray[i] * v2.myArray[i];
		}
	}
	return sum;
}

#endif /*VEC_H_*/
