/* mylist.cpp defines functions that extend the STL list.
 *
 * Begun by: Dr. Adams, CS 214 at Calvin College.
 * Completed by:Joshua Maguire
 * Date:4/24/14
 */

#include <iostream>     // cout, <<
using namespace std;

#include "mylist.h"

/*********************************************
 * print() displays an STL list of integers. *
 * Receive: aList, a list of integers,       *
 *          out, an ostream.                 *
 * Output: the values in aList, to out.      *
 *********************************************/
   void print(const list<int> & aList, ostream & out)
   {
      list<int>::const_iterator it = aList.begin();
      while (it != aList.end())
      {
         out << *it << '\t';
         it++;
      }
   }
   
/*********************************************
 * search() searches a list for a specified  *
  int.										 *
 * Receive: aList, a list of integers,       *
 *     aValue, int being searched for        *
 * Output: position of found int, -1 if      *
 							  not found      *
 *********************************************/
   int search (const list<int> & aList, int aValue)
   {
      list<int>::const_iterator it = aList.begin();
      int position = 0;
      while (it != aList.end())
      {
         if (aValue == *it)
         {
         	return position;
         }
         it++;
         position ++;
      }
      return -1;
   }
    
