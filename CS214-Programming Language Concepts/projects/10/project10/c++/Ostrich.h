/* Ostrich.h
 *
 * Begun by: Dr. Adams, CS 214 at Calvin College.
 * Completed by: Joshua Maguire
 * Date: 5/5/14
 */

#ifndef OSTRICH
#define OSTRICH

#include "Bird.h"
#include "WalkingBird.h"

 class Ostrich : public WalkingBird

{
  public:
  Ostrich(const string & name);
  string call() const;
  string className() const;
  private:
};


   inline Ostrich::Ostrich(const string & name)
    : WalkingBird(name)
   {
   }

   inline string Ostrich::call() const
   {
     return "Snork!";
   }
   
      inline string Ostrich::className() const
   {
     return "Ostrich";
   }
 
   #endif
 