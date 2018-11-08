/* bstReader.cpp houses methods for a bstReader which
 * reads in a txt file with ints, sstores them in a BST
 * and then retrieves the height. call like this:
 *			bstReader bst0;
 *			bst0.getHeights();
 * Joshua Maguire, for CS 112 at Calvin College.
 * Date:4/23/2013
 */
#include "bstReader.h"

bstReader::bstReader()
{
}

bstReader::~bstReader(void)
{
}

/* 
This method asks for a txt name, reads values into a BST,
and retrieves the height. If duplicates are found, couts an 'x',
otherwise progress is shown as '.'s. duplicates (if any) are 
dumped in 'duplicates.txt'. Thankyou and goodnight.
 */
void bstReader::getHeights() const
{
	string inputFile;
	cout << "\nEnter name/location of txt file (example file.txt) :"<< flush;
	cin >> inputFile;
	cout << "reading values from file..." << flush;
	ifstream in(inputFile.data());
	assert(in.is_open());
	ofstream out("duplicates.txt");
	assert(out.is_open());
	BST<long long> bst1;
	int dupCounter=0;
	long long  numLine;
	in>>numLine;
	int progress =0;//for progress bar
	while(!in.eof())
	{
		try
		{
			bst1.insert(numLine);
		}catch (Exception e1)
		{
			dupCounter++;
			out<<numLine<<endl;
			cout << "x" << flush;
		}
		progress++;
		if(progress==100000){cout<<"."<<flush;progress=0;}//progress bar. x's mean duplicate
		in>>numLine;
	}
	cout<<"\nbst from "<<inputFile<<"is "<<bst1.getHeight()<<" tall with "<<dupCounter<<" duplicates."<<endl;
}