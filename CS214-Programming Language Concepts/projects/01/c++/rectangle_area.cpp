/* rectangle_area.cpp computes the area of a circle.
 *
 * Input: length and width of rectangle
 * Precondition: The length and width are positive numbers.
 * Output: The area of the rectangle.
 *
 * Begun by: Dr. Nelesen, for CS 214, at Calvin College.
 * Completed by:Joshua Maguire
 * Date:2/10/14
 **********************************************************/

#include <iostream>             // cin, cout, >>, <<
using namespace std;

/* function rectangleArea() computes a rectangle's area, given its length and width.
 * Parameter: l,w  doubles
 * Precondition: l,w are not negative.
 * Returns: the area of the rectangle.
 */
double rectangleArea(double l,double w) {
  return l*w;               // return the area
}

int main() {
  cout << "To compute the area of a rectangle,\n enter its length... : ";
  double w,l;                   // declare variables
  cin >> l;                   // read length from the keyboard
  cout << "\n now enter its width... : ";
  cin >> w;                    // read length from the keyboard               
  double area = rectangleArea(l,w);// call method to compute area
                                   
  cout << "The area is " << area << endl;// output area
}
