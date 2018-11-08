/* roots.cpp computes the roots of a quadratic equation 
 *
 * Input: three terms of quadratic equation ( y = ax^2 + bx + c )
 * PRE: a > 0, (b^2 - 4ac) != negative
 * Output: x = root1, x = root2
 *
 * Begun by: Dr. Adams, for CS 214 at Calvin College.
 * Completed by:Joshua Maguire
 * Date:3/13/14
 **********************************************************************/


   #include <cmath>
   #include <iostream>
   using namespace std;

   bool quadraticRoots(double a, double b, double c,
                        double & root1, double & root2)
   {
      if (a != 0) {
         double arg = pow(b, 2.0) - 4 * a * c;//(b^2 - 4ac)
         if (arg >= 0) {
            root1 = (-b + sqrt(arg))/(2*a);//(-b + sqrt(arg))/2a
            root2 = (-b - sqrt(arg))/(2*a);//(-b - sqrt(arg))/2a
            return true;
         } else {
            cerr << "\n*** quadraticRoots(): b^2 - 4ac is negative!" << endl;
            root1 = root2 = 0.0;
            return false;
         }
      } else {
         cerr << "\n*** QuadraticRoots(): a is zero!" << endl;
         root1 = root2 = 0.0;
         return false;
      }
   }

int main() 
	{
	double rootA, rootB, rootC, root1, root2; //declare variables
	cout << "\nEnter terms for quadratic equation:";
	cin >> rootA >> rootB >> rootC;
	if (quadraticRoots(rootA, rootB, rootC, root1, root2))
	 {
		cout << "x = " << root1 << ", x = " << root2 << endl;
	 }
	}

	
