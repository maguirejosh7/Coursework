/* average.cpp "test-drives" function Average.
 * Precondition: theArray is an array of numbers.
 * Output: the average of the values.
 *
 * Begun by: Dr. Adams, for CS 214 at Calvin College.
 * Completed by: Joshua Maguire
 * Date:3/20/14
 */

#include <numeric>
#include <iostream>
using namespace std;

double average(double anArray[], int itsSize);

int main() {

  double array0[0]; //..[]={};  or ..[0];..{};..
  double array1 [4]={9.0,8.0,7.0,6.0};
  
  cout << "\n average 1 is " << average(array0, 0) << endl;
  cout << "\n average 2 is " << average(array1, 4) << endl;
}

/*******************************************************
 * average averages the values in an array of doubles. *
 * Receive: anArray, an array of doubles.              *
 * Return: the average of the values in aVector.       *
 *******************************************************/

  double average(double anArray[], int itsSize)
   {
      if (itsSize <= 0) {
         return 0.0;
      } else {
         return accumulate(anArray, anArray+itsSize, 0.0) / itsSize;
      }
   }
