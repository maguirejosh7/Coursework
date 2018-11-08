/* Experiment2.h declares a class that times the vector and list prepend operations.
 * Begun by: Joel Adams, for CS 112 at Calvin College.
 * Student name:Joshua Maguire
 * Date:3/12/13
 */
#ifndef EXPERIMENT2_H_
#define EXPERIMENT2_H_

#include "NanoTimer.h"

class Experiment2 {
public:
	void run();
	void timePrependToVectorOfSize(unsigned size);	
	void timeRepeatedPrependUntilVectorIsSize(unsigned reps);
	void timePrependToListOfSize(unsigned size);
	void timeRepeatedPrependUntilListIsSize(unsigned maxSize);


private:
	enum repetitions {REPS = 5};
	NanoTimer myTimer;
};

#endif /*EXPERIMENT2_H_*/
