/* array.cpp defines "C style" array operations. It houses all methods that
 * manipulate arrays. The people in this lab ARRAYmlessly coding, so
 * that is why I helped them.
 * Name:Joshua Maguire
 * Date:2/18/13
 * Begun by: Joel Adams, for CS 112 at Calvin College.
 */

#include "array.h"

/*
 * This method Makes an array of 'size' size.
 *
 * @param double *a
 * @param int size
 * precondition: size >=0, a is an array pointer
 * postcondition:	and array is created of size size
 */
void initialize(double *a, int size) {
	int val = 0;
	for (int i = 0; i < size; i++) {
		val = i+1;
		a[i] = val;
	}
}
/*
 * This method prints the contents of an array
 *@param double *a
 *@param int size
 * precondition:size >=0, a is an array pointer
 * postcondition:console is filled with beautiful numbers
 */
void print(double *a, int size) {
	for (int i = 0; i < size; i++) {
		cout << *a << '\t';
		a++;
	}
}		
/*
 * This method compoops the average of the beautiful
 * numbers in array a.
 *@param double *a
 *@param int size
 * precondition:size >=0, a is an array pointer
 * postcondition:returns average of array a
 */
double average(double *a, int size) {//gets average of ints in array
	double result=0;
	for (int i = 0; i < size; i++) {
		result+=a[i];
	}
	result=result/size;
	return result;
}
/*
 * This method computers the sum of all ints in array a.
 * @param double *a
 * @param int size
 * precondition:size >=0, a is an array pointer
 * postcondition:returns sum of...
 */
double sum(double *a, int size) {//gets sum of ints in array
	double result=0;
	for (int i = 0; i < size; i++) {
		result+=a[i];
	}
	return result;
}
/*
 * This method reads in ints from a txt file.
 * @param double *a
 * @param int size
 * precondition:size >=0, a is an array pointer
 * postcondition:has read in ints from txt.
 */
void read(istream& in, double *a, int size){
	for (int i = 0; i < size; i++) {
		in >> a[i];
	}
}
/*
 * This method fills array a with numvalues ints from txt filename.
 * @param double *a
 * @param int& numvalues
 * @param const string& filename
 * precondition:filename must be a filename, numvalues >=0
 * postcondition:a is filled with ints from txt
 */
void fill(const string& fileName, double *&a, int &numValues){//filsl array with contents of a txt
	ifstream fin(fileName.c_str() );		//new ifstream fin
	assert( fin.is_open() );				//make sure it's open
	fin >> numValues;						//read in from the txt the first value, which will be how big the array is
	double *dA = new double[numValues];		 //new temporary array with ^^^ length
	for (int i = 0; i < numValues; i++) {	//fills temp array with txt ints
		fin >> dA[i];
	}
	delete[]a;			//deletes the old block of mem a is pointing to
	a=dA;				//a now points to dAs mem block
	fin.close();		//close ifstream
}
/*
 * This method resizes an array and fills it with 0s if made bigger.
 * chops off extras if made smaller.
 *@param double *a
 *@param int olfSize
 *@param newSize
 * precondition:a is array pointer, old size is size of a, new size is desired size for new array.
 * postcondition: new array created of 'newSize' size.
 */
void resize(double *&a, int oldSize, int newSize){
	double *nA = new double[newSize];		//new temp array
	if(newSize>=oldSize){					//if new is bigger than old
		for (int i = 0; i < oldSize; i++) { //copies what's in old to new
			nA[i]=a[i];
		}
											//now must fill rest with 0s...
		for (int i = oldSize; i < newSize; i++) {//fills rest of array
			nA[i]=0;
		}
	}
	else{									//if new is smaller..
		for (int i = 0; i < newSize; i++) {//copies what's in old to new
			nA[i]=a[i];
		}
		for (int i = newSize; i < oldSize; i++) {
		}
	}
	delete[]a;								//deletes mem a is pointing to and...
	a=nA;									//replace it with nA's block of memory.
}
/*
 * This method combines arrays a1 and a2 into array 3.
 * @param *a1
 * @param *a2
 * @param *a3
 * @param size1
 * @param size2
 * @param size3
 * precondition:a1,2 and 3 are all arrays and size1,2
 * and 3 are all the correct sizes of arrays 1,2,3.
 * postcondition:combines arrays.
 */
void concat(double *a1, int size1, double *a2, int size2, double *&a3, int &size3){
	size3=size1+size2;//...
	if(a3!=NULL){delete [] a3;cout << "a3 deleted..." << flush;}//if a3s address points to a mem block, delete it.
	double *nA = new double[size3];	//new temporary array
	for(int i = 0; i < size1; i++){	//fills temp array with a1s values
		nA[i]=a1[i];
	}
	for(int i = 0; i < size2; i++){	//fills temp array with a2s values
		nA[i+size1]=a2[i];
	}
	a3=nA;							//sets a3s address to temp arrays address.
}
//these next three lines of coding are too complex for eclipse to recognize...


