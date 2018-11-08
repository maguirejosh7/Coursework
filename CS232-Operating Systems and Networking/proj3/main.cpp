/*
 * main.cpp
 *
 *  Created on: April 7, 2016
 *  Author: jlm54
 */

#include "CommandLine.h"

using namespace std;

int main() {
	CommandLine c(cin);
	cout << "argv[0] = " << c.getCommand() <<  endl;
	cout << "argc = " << c.getArgCount() << endl;
	cout << "argv = " << c.getArgVector() << endl;
	cout << "argv[1] = " << c.getArgVector(1) << endl;
	cout << "noAmpersand = " << c.noAmpersand() << endl;
}
