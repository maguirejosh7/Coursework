/* Penguin.h
 *
 * Begun by: Dr. Adams, CS 214 at Calvin College.
 * Completed by: Joshua Maguire
 * Date: 5/5/14
 */

#ifndef PENGUIN
#define PENGUIN	

#include "Bird.h"
#include "WalkingBird.h"

 class Penguin : public WalkingBird

{
  public:
  Penguin(const string & name);
  string call() const;
  string className() const;
  private:
};


   inline Penguin::Penguin(const string & name)
    : WalkingBird(name)
   {
   }

   inline string Penguin::call() const
   {
     return "Huh-huh-huh-huuuuh!";
   }
   
      inline string Penguin::className() const
   {
     return "Penguin";
   }
 
   #endif
 