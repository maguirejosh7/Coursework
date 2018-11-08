/* mylist.h declares functions that extend the STL list.
 *
 * Begun by: Dr. Adams, CS 214 at Calvin College.
 * Completed by:Joshua Maguire
 * Date:4/24/14
 */

#include <list>           // list<>
using namespace std;

   void print(const list<int> & aList, ostream & out);
   int search(const list<int> & aList, int aValue);
