 /* arrays.cpp reads in a user-specified amount of values into an array, then prints them out. Driver driven. 
 *
 * Begun by: Dr. Adams, for CS 214 at Calvin College.
 * Completed by: Joshua Maguire
 * Date:4/2/14
 */
 
 #include <iostream>
 #include <string>   
 using namespace std;


/* readArray reads in an arrays contents.
 * Input: double array anArray, int size, istream
 * Output:
 **********************************/
void readArray(double anArray[], int itsSize, istream & in = cin)
{
      for (int i = 0; i < itsSize; i++) {
      	 cout << "\nenter its contents:";
         cin >> anArray[i];
      }
}
 
/* printArray prints an arrays contents.
 * Input: double array anArray, int size, ostream
 * Output: arrays contents
 **********************************/
void printArray(double anArray[], int itsSize, ostream & out = cout)
{
      for (int i = 0; i < itsSize; i++) {
         cout << anArray[i] << endl;
         }
}
      
//driver, calls both methods, inputs size of our array.
int main()
{
	cout << "\nEnter array size:";
	int theSize;
	cin >> theSize;
	double theArray[theSize];
	readArray(theArray, theSize, cin);
	printArray(theArray, theSize, cout);
}
