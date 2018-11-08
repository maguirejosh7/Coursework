/*
 * Application.cpp
 *
 *  Created on: Mar 2, 2013
 *  Author: Anna Brink
 *  Author: Joshua MAguire
 */

#include "Application.h"

void Application::runApplication() {
    	cout 	<< "Please choose a Matrix operation from the following list.\n"
    			<< "Enter the corresponding number: \n"
    			<< "1 - addition\n"
    			<< "2 - subtraction\n"
    			<< "3 - transpose\n"
    			<< endl;
    	unsigned choice; // input from the user
    	string garbage; // collects invalid input
    	cin >> choice;
    	while (cin.fail() || choice > 3) {
    		cin.clear();
    		getline(cin, garbage);
    		cout 	<< "Invalid input.\n"
    				<< "Please enter one of the numbers from the menu to indicate your choice: "
    				<< endl;
    		cin >> choice;
    	}
    	string fileName;
    	cout << "Please enter the name of a file containing Matrix data: " << endl;
    	cin >> fileName;
    	Matrix<int> m1, m;
    	m1.readFrom(fileName);
    	switch (choice) {
    	case 1:
    	{
    		cout << "Please enter the name of a file containing Matrix data for the second matrix: " << endl;
    		cin >> fileName;
    		Matrix<int> m2;
    		m2.readFrom(fileName);
    		m = m1 + m2;
    		m.writeTo(cout);
    	}
    	break;

    	case 2:
    	{
    		cout << "Please enter the name of a file containing Matrix data for the second matrix: " << endl;
    		cin >> fileName;
    		Matrix<int> m2;
    		m2.readFrom(fileName);
    		m = m1 - m2;
    		m.writeTo(cout);
    	}
    	break;

    	case 3:
    	{
    		m = m1.getTranspose();
    		m.writeTo(cout);
    	}
    	break;

    	}
}


