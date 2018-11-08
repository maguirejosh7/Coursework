/* array.cpp defines "C style" array operations
 * Name:Joshua Maguire
 * Date:2/11/13
 * Begun by: Joel Adams, for CS 112 at Calvin College.
 */
 
#include "array.h"

void initialize(double *a, int size) {
	int val = 0;
	for (int i = 0; i < size; i++) {
		val = i+1;
		a[i] = val;
	}
}
 
void print(double *a, int size) {
	for (int i = 0; i < size; i++) {
		cout << *a << '\t';
		a++;
	}
}		

double average(double *a, int size) {
	double result;
	for (int i = 0; i < size; i++) {
		result+=a[i];
	}
	result=result/size;
	return result;
}
