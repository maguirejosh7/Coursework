/* Matrix.h provides a class for manipulating 2-dimensional vectors.
* Student Name: Joshua Maguire
 * Date:2/26/13
 * Begun by: Joel Adams, for CS 112 at Calvin College.
 */

#ifndef MATRIX_H_
#define MATRIX_H_

#include "Vec.h"

typedef double Item;

class Matrix {
public:
	Matrix();
	Matrix(unsigned rows, unsigned columns);
	unsigned getRows() const;
	unsigned getColumns() const;
//	void setSize(unsigned size);
	const Vec<Item>& operator[](unsigned index) const;//read
	Vec<Item>& operator[](unsigned index);//write
	bool operator==(const Matrix& m2) const;

private:
	unsigned         myRows;
	unsigned         myColumns;
	Vec< Vec<Item> > myVec;
	friend class MatrixTester;
};

#endif
