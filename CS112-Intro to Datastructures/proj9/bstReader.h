/* bstReader.h declars a bstReader which
 * reads in a txt file with ints, sstores them in a BST
 * and then retrieves the height. call like this:
 *			bstReader bst0;
 *			bst0.getHeights();
 * Joshua Maguire, for CS 112 at Calvin College.
 * Date:4/23/2013
 */

#ifndef bstReader_H_
#define bstReader_H_

#include <cassert>
#include <iostream>
#include <fstream>
#include "BST_Tester.h"

using namespace std;

class bstReader
{
public:
	bstReader();
	~bstReader(void);
	void getHeights() const;
private:
	

};

#endif