/* birds.cpp illustrates inheritance and polymorphism.
 *
 * Begun by: Dr. Adams, CS 214 at Calvin College.
 * Completed by: Joshua Maguire
 * Date: 5/5/14
 */

#include <iostream>       // cin, cout, <<, >>
using namespace std;

#include "Bird.h"         // Bird
#include "Owl.h"          // Owl
#include "Duck.h"         // Duck
#include "Goose.h"        // Goose
#include "Kiwi.h"
#include "Ostrich.h"
#include "Penguin.h"
#include "FlyingBird.h"
#include "WalkingBird.h"

int main() {
  Bird * birdPtr0 = NULL,
       * birdPtr1 = NULL,
       * birdPtr2 = NULL,
       * birdPtr3 = NULL,
	   * birdPtr4 = NULL,
	   * birdPtr5 = NULL,
	   * birdPtr6 = NULL;
	   
  birdPtr0 = new Bird("Hawkeye");
  birdPtr0->print(); cout << endl;
  
  birdPtr1 = new Duck("Donald");
  birdPtr1->print(); cout << endl;

  birdPtr2 = new Goose("Mother");
  birdPtr2->print(); cout << endl;
  
  birdPtr3 = new Owl("Woodsey");
  birdPtr3->print(); cout << endl;

  birdPtr4 = new Ostrich("Orville");
  birdPtr4->print(); cout << endl;
  
  birdPtr5 = new Kiwi("Cleo");
  birdPtr5->print(); cout << endl;
  
  birdPtr6 = new Penguin("Peter");
  birdPtr6->print(); cout << endl;
  
  delete birdPtr0;
  delete birdPtr1;
  delete birdPtr2;
  delete birdPtr3;
  delete birdPtr4;
  delete birdPtr5;
  delete birdPtr6;  
}

   inline Bird::Bird(const string & name) {
     myName = name;
   }
   
   inline string Bird::name() const {
     return myName;
   }
   
   inline string Bird::call() const {
     return "Squaaaaaaawk!";
   }
   
   inline string Bird::className() const {
     return "Bird";
   }
   
   inline string Bird::movement() const
   {
		return "went by";
	}

      inline void Bird::print(ostream & out) const {
      out << name() 
          << ' ' 
          << className() 
          << " just "
          << movement()
          << " and said " 
          << call();
   }
   
   
   