Script started on Thu 06 Feb 2014 09:23:31 AM EST
jlm54@eckert-mauchly:~/214/labs/01$ cat circle_area.cpp
/* circle_area.cpp computes the area of a circle.
 *
 * Input: The radius of the circle.
 * Precondition: The radius is a positive number.
 * Output: The area of the circle.
 *
 * Begun by: Dr. Nelesen, for CS 214, at Calvin College.
 * Completed by:Joshua Maguire
 * Date:2/6/14
 **********************************************************/

#include <iostream>             // cin, cout, >>, <<
using namespace std;

/* function circleArea() computes a circle's area, given its radius.
 * Parameter: r, a double
 * Precondition: r is not negative.
 * Returns: the area of the circle
 */
double circleArea(double r) {
  const double PI = 3.1415927;     // define a constant
  return PI * r * r;               // return an expression
}

int main() {
                                   // prompt for and input radius
  cout << "To compute the area of a circle,\n enter its radius: ";
  double radius;                   // declare a variable
  cin >> radius;                   // read radius from the keyboard
                                   // compute area
  double area = circleArea(radius);
                                   // output area
  cout << "The area is " << area << endl;
}
jlm54@eckert-mauchly:~/214/labs/01$ g[Kcat circle_area.cpp[12P./prog3cat circle_area.cpp[12P./prog3ls[Kcd hplantin/public/212/hw1..[Khplantin/public/212/hw1ls[K./prog3cat circle_area.cpp[Kg++ circle_area.cpp Wall[K[K[K[K-Wall -o cpp_circle)[K_area [A[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[Ka
jlm54@eckert-mauchly:~/214/labs/01$ ./cpp_circle_area
To compute the area of a circle,
 enter its radius: 1
The area is 3.14159
jlm54@eckert-mauchly:~/214/labs/01$ ./cpp_circle_area
To compute the area of a circle,
 enter its radius: 2
The area is 12.5664
jlm54@eckert-mauchly:~/214/labs/01$ ./cpp_circle_area
To compute the area of a circle,
 enter its radius: 2.5
The area is 19.635
jlm54@eckert-mauchly:~/214/labs/01$ ./cpp_circle_area
To compute the area of a circle,
 enter its radius: 4.99999
The area is 78.5395
jlm54@eckert-mauchly:~/214/labs/01$ exit
exit

Script done on Thu 06 Feb 2014 09:25:21 AM EST
