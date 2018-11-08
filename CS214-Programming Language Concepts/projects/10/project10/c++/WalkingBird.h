/* WalkingBird.h
 *
 * Begun by: Dr. Adams, CS 214 at Calvin College.
 * Completed by: Joshua Maguire
 * Date: 5/5/14
 */
 
 #ifndef WALKINGBIRD
 #define WALKINGBIRD
 
 #include "Bird.h"
 
 class WalkingBird : public Bird
 {
	public:
	WalkingBird(const string & name);
	string movement() const;
	private:
};

inline WalkingBird::WalkingBird(const string & name)
 : Bird(name)
{
}

inline string WalkingBird::movement() const
{
	return "walked past";
}


#endif