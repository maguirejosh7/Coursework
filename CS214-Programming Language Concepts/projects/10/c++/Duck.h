/* Duck.h
 *
 * Begun by: Dr. Adams, CS 214 at Calvin College.
 * Completed by: Joshua Maguire
 * Date: 4/29/14
 */

#ifndef DUCK
#define DUCK

#include "Bird.h"


class Duck : public Bird
{
  public:
  Duck(const string & name);
  string call() const;
  string className() const;
  private:
};


   inline Duck::Duck(const string & name)
    : Bird(name)
   {
   }

   inline string Duck::call() const
   {
     return "Quack!";
   }
   
      inline string Duck::className() const
   {
     return "Duck";
   }
 
   #endif
 