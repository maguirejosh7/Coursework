	/* Bird.h provides class Bird.
 *
 * Begun by: Dr. Adams, CS 214 at Calvin College.
 * Completed by: Joshua Maguire
 * Date: 4/29/14
 */

#ifndef BIRD
#define BIRD

#include <string>
using namespace std;

   class Bird {
     public:
      Bird(const string & name);
	  virtual ~Bird() {}
      string name() const;
      virtual string call() const;
      void print(ostream & out = cout) const;
      virtual string className() const;
     private:
      string myName;
   };

#endif

