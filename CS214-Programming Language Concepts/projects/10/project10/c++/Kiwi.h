/* Kiwi.h
 *
 * Begun by: Dr. Adams, CS 214 at Calvin College.
 * Completed by: Joshua Maguire
 * Date: 5/5/14
 */

#ifndef KIWI
#define KIWI

#include "Bird.h"
#include "WalkingBird.h"

 class Kiwi : public WalkingBird

{
  public:
  Kiwi(const string & name);
  string call() const;
  string className() const;
  private:
};


   inline Kiwi::Kiwi(const string & name)
    : WalkingBird(name)
   {
   }

   inline string Kiwi::call() const
   {
     return "KEEWEE!";
   }
   
      inline string Kiwi::className() const
   {
     return "Kiwi";
   }
 
   #endif
 