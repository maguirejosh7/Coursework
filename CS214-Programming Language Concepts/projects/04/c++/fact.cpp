/* fact.cpp displays the factorial of a positive number n.
 * Input: unsigned n
 * PRE: positive integer
 * Output: factorial of the number
 * Begun by Professor Adams? for CS 214 at Calvin COllege
 * Edited by Joshua Maguire
 ********************************************************/



 #include <iostream>
   using namespace std;
/* factorial computes the factorial of a positive number n.
 * Input: unsigned n
 * PRE: positive integer
 * Output: factorial of the number
 *****************************************************/
   double factorial(unsigned n) {
      double answer = 1.0;

      for (int i = 2; i <= n; i++) {
         answer *= i;
      }

      return answer;
   }


   int main() {
      cout << "\nTo compute n!, enter n: ";
      unsigned n;
      cin >> n;

      cout << n << "! = " << factorial(n) << endl;
   }
