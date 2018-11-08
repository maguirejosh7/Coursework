/* Name.h declares class Name.
 *
 * Begun by: Dr. Adams, CS 214 at Calvin College.
 * Completed by: Joshua Maguire
 * Date:4/13/14
 */

#include <iostream> 
#include <string>          // string
using namespace std;

class Name {
public:                          // interface functions
   Name(const string & first, const string & middle, const string &
last);
   string getFirst() const;
   string getMiddle() const;
   string getLast() const;
   string getFullName() const;
   void print(ostream & out);
   
private:
   string myFirst,
          myMiddle,
          myLast;
};

