/* max.cpp finds the maximum value in a C++ linked list.
 *
 * Begun by: Dr. Adams, CS 214 at Calvin College.
 * Completed by:Joshua Maguire
 * Date:4/24/14
 */

#include <iostream>       // cin, cout, <<, >>
#include <algorithm>	  //for max_element
using namespace std;

#include "mylist.h"       // print()

int main() {
  list<int> list1, list2, list3, list4; //define list

  list1.push_back(99);    // 99, 88, 77, 66, 55
  list1.push_back(88);    // max is first
  list1.push_back(77);
  list1.push_back(66);  
  list1.push_back(55);

  list2.push_back(55);    // 55, 66, 77, 88, 99
  list2.push_back(66);    // max is last
  list2.push_back(77);  
  list2.push_back(88);   
  list2.push_back(99);  
  
  list3.push_back(55);    // 55, 77, 99, 88, 66
  list3.push_back(77);    // max is in the middle
  list3.push_back(99);  
  list3.push_back(88);  
  list3.push_back(66);  
  
  print(list1, cout); cout << endl;
  print(list2, cout); cout << endl;
  print(list3, cout); cout << endl;

  // display maxima of the 3 lists...
  cout << *max_element(list1.begin(), list1.end()) << endl;
  cout << *max_element(list2.begin(), list2.end()) << endl;
  cout << *max_element(list3.begin(), list3.end()) << endl;
  
  cout << "------------search tests---------------" << endl;
  //search test
  list4.push_back(55);    
  list4.push_back(77);
  list4.push_back(44);
  list4.push_back(88);  
  list4.push_back(66);

  cout << search(list1, 99) << endl;
  cout << search(list2, 99) << endl;
  cout << search(list3, 99) << endl;
  cout << search(list4, 99) << endl;
  
  cout << "all tests pasted!" << endl;

}

