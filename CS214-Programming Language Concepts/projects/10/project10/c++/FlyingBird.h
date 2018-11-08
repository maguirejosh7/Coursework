/* FlyingBird.h
 *
 * Begun by: Dr. Adams, CS 214 at Calvin College.
 * Completed by: Joshua Maguire
 * Date: 5/5/14
 */
 
 #ifndef FLYINGBIRD
 #define FLYINGBIRD
 
 #include "Bird.h"
 
 class FlyingBird : public Bird
 {
	public:
	FlyingBird(const string & name);
	string movement() const;
	private:
};

inline FlyingBird::FlyingBird(const string & name)
 : Bird(name)
{
}

inline string FlyingBird::movement() const
{
	return "flew past";
}


#endif