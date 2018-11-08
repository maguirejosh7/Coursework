/* Owl.h
 *
 * Begun by: Dr. Adams, CS 214 at Calvin College.
 * Completed by: Joshua Maguire
 * Date: 5/5/14
 */

#ifndef OWL
#define OWL

#include "Bird.h"
#include "FlyingBird.h"

 class Owl : public FlyingBird

{
  public:
  Owl(const string & name);
  string call() const;
  string className() const;
  private:
};


   inline Owl::Owl(const string & name)
    : FlyingBird(name)
   {
   }

   inline string Owl::call() const
   {
     return "Whoo-hoo!";
   }
   
      inline string Owl::className() const
   {
     return "Owl";
   }
 
   #endif
 