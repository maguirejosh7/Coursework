/* grades.cpp tests the letterGrade method given from the project. By Joshua Maguire on 2/26/14 for Calvin College.*/

#include <iostream>

using namespace std;

char letterGrade(int average);//declaring method


int main()
{
  cout << "testing letterGrade method...\n";
  cout << "average 100 = " << letterGrade(100) << "\n";
  cout << "average 90 = " << letterGrade(90) << "\n";
  cout << "average 80 = " << letterGrade(80) << "\n";
  cout << "average 77 = " << letterGrade(77) << "\n";
  cout << "average 61 = " << letterGrade(61) << "\n";
  cout << "average 55 = " << letterGrade(55) << "\n";
  cout << "average 111 = " << letterGrade(111) << "\n";
  cout << "testing complete.\n";
}


   char letterGrade(int average)
   {
      switch (average / 10)
      {
         case 10: case 9:
            return 'A';
         case 8:
            return 'B';
         case 7:
            return 'C';
         case 6:
            return 'D';
         default:
            return 'F';
      }
   }
