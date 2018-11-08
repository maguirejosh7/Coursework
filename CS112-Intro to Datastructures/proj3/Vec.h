/* Vec.h provides a simple vector class named Vec.
 * Student Name: Nathan Terschak, Joshua Maguire
 * Date: 2/25/2013
 * Begun by: Joel C. Adams, for CS 112 at Calvin College.
 */

#ifndef VEC_H_
#define VEC_H_

#include <iostream>
using namespace std;

typedef double Item;

class Vec {
public:
	Vec();
	virtual ~Vec();
	Vec(unsigned size);
	Vec(const Vec& original);
	Vec& operator=(const Vec& original);
	unsigned getSize() const;
	void setItem(unsigned index, const Item& it);
	Item getItem(unsigned index) const;
	void setSize(unsigned newSize);
	bool operator==(const Vec& v2);
	void writeTo(ostream& out) const;
	void readFrom(istream& in);
	const Item& operator[] (unsigned index) const;
	Item& operator[] (unsigned index);
	bool operator!=(Vec& v);
	void readFrom(string fileName);
	void writeTo(string fileName) const;
	Vec operator+(const Vec& v1) const;
	Vec operator-(const Vec& v)const;
	double operator*(const Vec& v1) const;
private:
	unsigned mySize;
	Item * myArray;
	friend class VecTester;
};

#endif /*VEC_H_*/
