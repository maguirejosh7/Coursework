/* Owl.h
 *
 * Begun by: Dr. Adams, CS 214 at Calvin College.
 * Completed by: Joshua Maguire
 * Date: 4/29/14
 */

#ifndef OWL
#define OWL

#include "Bird.h"

class Owl : public Bird {
 public:
	Owl(const string & name);
	string call() const;
	string className() const;
 private:
};


inline Owl::Owl(const string & name)
: Bird(name)
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
