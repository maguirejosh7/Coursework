/* Matrix.h provides a class for manipulating 2-dimensional vectors.
 * Student Name: Anna Brink, Joshua Maguire
 * Date: February 26, 2013
 * Begun by: Joel Adams, for CS 112 at Calvin College.
 */

#ifndef MATRIX_H_
#define MATRIX_H_

#include "Vec.h"
#include <fstream>
#include <iostream>
using namespace std;

template <class Item>

class Matrix {
public:

	/** Default Constructor
	 */
	Matrix();

	/** Explicit Constructor
	 */
	Matrix(unsigned rows, unsigned columns);

	/** Read Subscript.
	 * \param index The position of the row.
	 * \return A vector of items which represents the row.
	 */
	const Vec<Item> & operator[](unsigned index) const;

	/** Write Subscript.
	 * \param index The position of the row that will be written over.
	 * \return A vector of items which represents the row.
	 */
	Vec<Item> & operator[](unsigned index);

	/** Equality.
	 * \param m2 The matrix compared to the one the function is called on.
	 * \return True if the matrices are equal and false if not.
	 */
	bool operator==(const Matrix<Item>& m2) const;

	/*This operator method compares
	 * matrixs m1 and myVec to see if they
	 *  not equal each other.
	 * returns a bool...
	 *
	 * @param Matrix& m1
	 *
	 * precondition: Matrix& \m1 is a valid matrix, could be null...
	 * postcondition: returns bool false if they are equal
	 *
	 *made by Joshua Maguire
	 */
	bool operator!=(const Matrix<Item>& m1) const;


	istream& readFrom(istream& in);

	/** Writes the matrix out to an ostream.
	 * \param out The stream to write the matrix to.
	 * \return The stream entered to enable chaining of operator<<()
	 * \author Anna Brink
	 */
	ostream& writeTo(ostream& out);

	/** Fills the matrix with information from a file
	 * \param fileName The name of the file with matrix information.
	 * \author Anna Brink
	 */
	void readFrom(string fileName);

	/*This method writes contents of myVec to the file filename.
	 *
	 * @param string fileName
	 *
	 * precondition: fileNAme is name of valid txt filename
	 * postcondition: contents of fileName written to txt.
	 *
	 * made by Joshua Maguire
	 */
	void writeTo(string fileName) const;

	/*This method returns my matrix + the second matrix.
	 *
	 *
	 * @param Matrix& m2
	 *
	 * precondition: Matrix& m2 is a valid matrix, could be empty
	 * postcondition: returns m2 + myVec
	 *
	 * made by Joshua Maguire
	 */
	Matrix<Item> operator+(const Matrix<Item>& m2) ;

	/** Subtracts a second matrix from the matrix.
	 * \param m2 The matrix subtracted from the matrix the function is called upon.
	 * \return A matrix containing the difference of the two matrices.
	 * \author Anna Brink
	 */
	Matrix<Item> operator-(const Matrix<Item>& m2) const;

	/** Creates a matrix whose columns are the rows of the matrix the function is called
	 * upon and whose rows are the columns of the matrix the function is called upon.
	 * \return The matrix created.
	 * \author Anna Brink
	 */
	Matrix<Item> getTranspose() const;

	/** Accessor methods
	 */
	unsigned getRows() const;
	unsigned getColumns() const;

private:
	unsigned			myRows;
	unsigned			myColumns;
	Vec< Vec<Item> >	myVec;

	friend class MatrixTester;
};
template <class Item>
Matrix<Item>::Matrix() {
	myRows = myColumns = 0;
}
template <class Item>
Matrix<Item>::Matrix(unsigned rows, unsigned columns) {
	myRows = rows;
	myColumns = columns;
	myVec.setSize(rows);
	for (unsigned i = 0; i < rows; i++) {
		myVec[i].setSize(columns);
	}
}
template <class Item>
const Vec<Item> & Matrix<Item>::operator[](unsigned index) const {
	if (index >= myRows) {
		throw range_error("Vec subscript: index too large.");
	}
	return myVec[index];
}
template <class Item>
Vec<Item> & Matrix<Item>::operator[](unsigned index) {
	if (index >= myRows) {
		throw range_error("Vec subscript: index too large.");
	}
	return myVec[index];
}
template <class Item>
bool Matrix<Item>::operator==(const Matrix<Item>& m2) const {
	if (myRows != m2.getRows() || myColumns != m2.getColumns() ) {
		return false;
	}
	else {
		return myVec == m2.myVec;
	}
}
template <class Item>
unsigned Matrix<Item>::getRows() const {
	return myRows;
}
template <class Item>
unsigned Matrix<Item>::getColumns() const {
	return myColumns;
}
template <class Item>
bool Matrix<Item>::operator!=(const Matrix<Item>& m1) const{
    if(myRows!=m1.getRows()||myColumns!=m1.getColumns()){
        return true;
    }
    else{
        for (unsigned i = 0; i < myRows; i++) {
            for (unsigned j = 0; j < myColumns; j++) {
                if(m1[i][j] != myVec[i][j]){
                    return true;
                }
            }
            return false;
        }
    }
}
template <class Item>
istream& Matrix<Item>::readFrom(istream& in) {
	for (unsigned i = 0; i < myRows; i++) {
			for (unsigned j = 0; j < myColumns; j++) {
				in >> myVec[i][j];
			}
	}
	return in;
}
template <class Item>
ostream& Matrix<Item>::writeTo(ostream& out) {
	for (unsigned i = 0; i < myRows; i++) {
			for (unsigned j = 0; j < myColumns; j++) {
				out << myVec[i][j] << "\t";
			}
		out << endl;
	}
	return out;
}
template <class Item>
void Matrix<Item>::readFrom(string fileName) {
	unsigned rows;
	unsigned columns;
	ifstream fin(fileName.c_str());
	assert( fin.is_open() );
	fin >> rows >> columns;
	myRows = rows;
	myColumns = columns;
	myVec.setSize(rows);
	for (unsigned i = 0; i < rows; i++) {
		myVec[i].setSize(columns);
		for (unsigned j = 0; j < columns; j++) {
			fin >> myVec[i][j];
		}
	}
	fin.close();
}
template <class Item>
void Matrix<Item>::writeTo(string fileName) const {
    ofstream out (fileName.c_str());
    assert( out.is_open());
    out << myRows << " " << myColumns << endl;
    for(unsigned i=0;i<myRows;i++){
        for(unsigned j=0;j<myColumns;j++){
            out << myVec[i][j] << "\t";
        }
        out << "\n";
    }
}
template <class Item>
Matrix<Item> Matrix<Item>::operator+(const Matrix<Item>& m2) {
	if (myRows != m2.getRows() || myColumns != m2.getColumns()) {
		throw invalid_argument("Matrix operator-(): The matrices are not the same size");
	}
        Matrix returnMatrix(myRows,myColumns);
        for(unsigned i=0;i<myRows;i++){
            for(unsigned j=0;j<myColumns;j++){
                returnMatrix[i][j]=myVec[i][j] + m2[i][j];
            }
        }
        return returnMatrix;

}
template <class Item>
Matrix<Item> Matrix<Item>::operator-(const Matrix<Item>& m2) const {
	if (myRows != m2.getRows() || myColumns != m2.getColumns()) {
		throw invalid_argument("Matrix operator-(): The matrices are not the same size");
	}
	Matrix m(myRows, myColumns);
	for (unsigned i = 0; i < myRows; i++) {
		for (unsigned j = 0; j < myColumns; j++) {
			m[i][j] = myVec[i][j] - m2[i][j];
		}
	}
	return m;
}
template <class Item>
Matrix<Item> Matrix<Item>::getTranspose() const {
	unsigned rows = myRows;
	unsigned columns = myColumns;
	Matrix m(columns, rows);
	for (unsigned i = 0; i < rows; i++) {
		for (unsigned j = 0; j < columns; j++) {
			m[j][i] = myVec[i][j];
		}
	}
	return m;
}

#endif
