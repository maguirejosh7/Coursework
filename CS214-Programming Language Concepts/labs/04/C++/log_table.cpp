/* log_table.cpp displays a table of logarithms.
 *
 * Input: start, stop and increment, three doubles.
 * PRE: start < stop && increment > 0.
 * Output: A table of logarithms from start to stop,
 *         with increment as the step value.
 * Begun by: Adams, for CS 214 at Calvin College.
 * Completed by:Joshua Maguire
 ********************************************************/

#include <iostream>    // cin, cout, <<, >>
#include <cassert>     // assert()
#include <cmath>       // log10()
using namespace std;

int main() 
{
  cout << "\nTo display a table of logarithms,"
       << "\n enter the start, stop and increment values: ";
  double start, stop, increment;
  cin >> start >> stop >> increment;
  
  assert(increment > 0);
  
   for (double count = start; count <= stop; count += increment)
      cout << "\nThe logarithm of " << count
           << " is " << log10(count) << endl;
}

