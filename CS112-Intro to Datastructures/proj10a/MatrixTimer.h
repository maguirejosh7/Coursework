/* MatrixTimer.h declares a class to record Matrix operations' timing data.
 * Joel Adams, for CS 112 at Calvin College.
 * Copyright Joel C. Adams, 2009.  All Rights Reserved.
 *
 * edited by Joshua Maguire on 5/7/13
 */

#ifndef MATRIX_TIMER
#define MATRIX_TIMER

#include <string>
#include <fstream>  // ifstream, ofstream
#include <iostream> // cin, cout, <<, >>
#include <iomanip>  // setw()
#include "Matrix.h" // Matrix class
#include "omp.h"    // OpenMP library
using namespace std;

class MatrixTimer {
public:
	MatrixTimer(unsigned numTrials, const string& logFile);
	~MatrixTimer();
	void run();
	void timeAddition();
	void timeTranspose();
	void timeMakeCopyOf();
	void timeInitialize();
	void timeEquals();
	void timeMultiply();
protected:
	double average() const;
private:
	unsigned myNumTrials;
	double*  myTrialTimes;
	ofstream myLogStream;
	Matrix	 myMatrix, myMatrix2;
};

/* explicit-value constructor
 * Parameters: numTrials, the number of time-trials for each operation
 *             logFile, a file where time-trial data are logged.
 * Postcondition: my instance variables have all been initialized.
 */

inline 
MatrixTimer::MatrixTimer(unsigned numTrials, const string& logFile) {
	myNumTrials = numTrials;
	myTrialTimes = new double[numTrials];
	if (logFile != "") {
		myLogStream.open( logFile.c_str() );
	} 
	cout << "\nLoading matrices..." << flush;
	//	myMatrix.fill("testFiles/4096x4096.txt");
	//	myMatrix2.fill("testFiles/4096x4096.txt");
	myMatrix.fill("testFiles/1024x1024.txt");
	myMatrix2.fill("testFiles/1024x1024.txt");
}

/* destructor
 * Postcondition: my dynamic array has been returned to the heap &&
 *                 my log file has been closed.
 */
inline 
MatrixTimer::~MatrixTimer() {
	delete [] myTrialTimes;
	if ( myLogStream.is_open() ) {
		myLogStream.close();
	}
}

/* method to run time-trials
 * Postcondition: my time-trials have been run.
 */
inline 
void MatrixTimer::run() {
	cout << endl;
	timeAddition();
	timeTranspose();
	timeMakeCopyOf();
	timeInitialize();
	timeEquals();
	timeMultiply();

	cout << endl;
}


/* time the addition operation
 * Postcondition: the addition operation has been performed
 *                      myNumTrials times, &&
 *                 myLogStream contains the time-trial times and
 *                      their average &&
 *                 an asterisk has been display on the screen
 *                      for each time-trial &&
 *                 their average has been displayed on the screen.
 */
inline 
void MatrixTimer::timeAddition() {
	cout << "Timing Matrix addition: \t" << flush;
	myLogStream << fixed << "\nTiming Matrix addition ...\n";
	double start = 0, stop = 0;
	for (unsigned i = 0; i < myNumTrials; i++) {
		cout << " * " << flush;
		start = omp_get_wtime();
		myMatrix + myMatrix2;
		stop = omp_get_wtime();
		myTrialTimes[i] = stop - start;
		myLogStream << "\nTrial " << i << ": " << myTrialTimes[i];
	}
	double avgTime = average();
	cout << '\t' << fixed << setw(7) << setprecision(5) << avgTime << endl;
	myLogStream << "\nAverage: " << fixed << setw(7)  << setprecision(5)
                				<< avgTime << endl;
}

/* utility method to average the time-trials in myTrialTimes.
 * Precondition: myNumTrials > 0 &&
 *                myTrialTimes contains that many trial-times
 * Return: the average of the trial-times in myTrialTimes.
 */
inline 
double MatrixTimer::average() const {
	double sum = 0;
	for (unsigned i = 0; i < myNumTrials; i++) {
		sum += myTrialTimes[i];
	}
	return sum / myNumTrials;
}

/* time the transpose operation
 * Postcondition: the transpose operation has been performed
 *                      myNumTrials times, &&
 *                 myLogStream contains the time-trial times and
 *                      their average &&
 *                 an asterisk has been display on the screen
 *                      for each time-trial &&
 *                 their average has been displayed on the screen.
 */
inline 
void MatrixTimer::timeTranspose() {
	cout << "Timing Matrix transpose: \t" << flush;
	myLogStream << "\nTiming Matrix transpose ...\n";
	double start = 0, stop = 0;
	for (unsigned i = 0; i < myNumTrials; i++) {
		cout << " * " << flush;
		start = omp_get_wtime();
		myMatrix.transpose();
		stop = omp_get_wtime();
		myTrialTimes[i] = stop - start;
		myLogStream << "\nTrial " << i << ": " << myTrialTimes[i];
	}
	double avgTime = average();
	cout << '\t' << fixed << setw(7) << setprecision(5) << avgTime << endl;
	myLogStream << "\nAverage: "  << fixed << setw(7)  << setprecision(5)
                    				<< avgTime << endl;
}


/* time the transpose operation
 * Postcondition: the transpose operation has been performed
 *                      myNumTrials times, &&
 *                 myLogStream contains the time-trial times and
 *                      their average &&
 *                 an asterisk has been display on the screen
 *                      for each time-trial &&
 *                 their average has been displayed on the screen.
 */
inline
void MatrixTimer::timeMakeCopyOf() {
	cout << "Timing Matrix copy: \t\t" << flush;
	myLogStream << fixed << "\nTiming Matrix makeCopyOf ...\n";
	double start = 0, stop = 0;
	for (unsigned i = 0; i < myNumTrials; i++) {
		cout << " * " << flush;
		start = omp_get_wtime();
		Matrix myMatrix3;
		myMatrix3=myMatrix;
		stop = omp_get_wtime();
		myTrialTimes[i] = stop - start;
		myLogStream << "\nTrial " << i << ": " << myTrialTimes[i];
	}
	double avgTime = average();
	cout << '\t' << fixed << setw(7) << setprecision(5) << avgTime << endl;
	myLogStream << "\nAverage: " << fixed << setw(7)  << setprecision(5)
                				<< avgTime << endl;
}
/* time the initialize operation
 * Postcondition: the initialize operation has been performed
 *                      myNumTrials times, &&
 *                 myLogStream contains the time-trial times and
 *                      their average &&
 *                 an asterisk has been display on the screen
 *                      for each time-trial &&
 *                 their average has been displayed on the screen.
 *                 by Joshua Maguire on 5/7/13
 */
inline
void MatrixTimer:: timeInitialize() {
	cout << "Timing Matrix initialize: \t" << flush;
	myLogStream << "\nTiming Matrix initialize ...\n";
	double start = 0, stop = 0;
	for (unsigned i = 0; i < myNumTrials; i++) {
		cout << " * " << flush;
		Matrix myMatrix3;
		myMatrix3=myMatrix;
		start = omp_get_wtime();
		myMatrix3.initialize(5);
		stop = omp_get_wtime();
		myTrialTimes[i] = stop - start;
		myLogStream << "\nTrial " << i << ": " << myTrialTimes[i];
	}
	double avgTime = average();
	cout << '\t' << fixed << setw(7) << setprecision(5) << avgTime << endl;
	myLogStream << "\nAverage: "  << fixed << setw(7)  << setprecision(5)
                    				<< avgTime << endl;
}

/* time the equals operator operation
 * Postcondition: the == operation has been performed
 *                      myNumTrials times, &&
 *                 myLogStream contains the time-trial times and
 *                      their average &&
 *                 an asterisk has been display on the screen
 *                      for each time-trial &&
 *                 their average has been displayed on the screen.
 *                 by Joshua Maguire on 5/7/13
 */
inline
void MatrixTimer:: timeEquals() {
	cout << "Timing Matrix Equals: \t\t" << flush;
	myLogStream << "\nTiming Matrix Equals ...\n";
	double start = 0, stop = 0;
	for (unsigned i = 0; i < myNumTrials; i++) {
		cout << " * " << flush;
		start = omp_get_wtime();
		myMatrix==myMatrix;
		stop = omp_get_wtime();
		myTrialTimes[i] = stop - start;
		myLogStream << "\nTrial " << i << ": " << myTrialTimes[i];
	}
	double avgTime = average();
	cout << '\t' << fixed << setw(7) << setprecision(5) << avgTime << endl;
	myLogStream << "\nAverage: "  << fixed << setw(7)  << setprecision(5)
                    				<< avgTime << endl;
}


/* time the operator*(multiply) operation
 * Postcondition: the operator* operation has been performed
 *                      myNumTrials times, &&
 *                 myLogStream contains the time-trial times and
 *                      their average &&
 *                 an asterisk has been display on the screen
 *                      for each time-trial &&
 *                 their average has been displayed on the screen.
 *                 by Joshua Maguire on 5/7/13
 */
inline
void MatrixTimer:: timeMultiply() {
	cout << "Timing Matrix Multiply: \t" << flush;
	myLogStream << "\nTiming Matrix Multiply ...\n";
	double start = 0, stop = 0;
	for (unsigned i = 0; i < myNumTrials; i++) {
		cout << " * " << flush;
		start = omp_get_wtime();
		myMatrix*myMatrix2;
		stop = omp_get_wtime();
		myTrialTimes[i] = stop - start;
		myLogStream << "\nTrial " << i << ": " << myTrialTimes[i];
	}
	double avgTime = average();
	cout << '\t' << fixed << setw(7) << setprecision(5) << avgTime << endl;
	myLogStream << "\nAverage: "  << fixed << setw(7)  << setprecision(5)
                    				<< avgTime << endl;
}


#endif


