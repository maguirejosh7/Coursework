Script started on Thu 20 Feb 2014 09:35:21 AM EST
jlm54@kay:~/214/labs/03$ cat year_codes.cpp
/* year_codes.cpp is a driver for function yearCode().
 * Begun by: Dr. Adams, for CS 214 at Calvin College.
 * Continued by Joshua Maguire on 2/20/14
 ****************************************************************/

#include <iostream>                      // interactive I/O
#include <string>                        // string class
using namespace std;

// REPLACE THIS LINE WITH THE DECLARATION OF yearCode()
int yearCode(const string & year);

int main() {
  cout << "\nEnter your academic year: "; // prompt
  string year;
  cin >> year;                            // read year
  cout << yearCode(year) << endl;         // display its code
}


/***************************************************************
 * yearCode() converts an academic year into its integer code. *
 * Receive: year, a string.
 * PRE: year is one of {freshman, sophomore, junior, or senior}.
 * Return: the integer code corresponding to year.
 */

// REPLACE THIS LINE WITH THE DEFINITION OF yearCode()

int yearCode(const string & year)
{
   if (year == "freshman")
      return 1;
   else
      if (year == "sophomore")
         return 2;
      else
         if (year == "junior")
            return 3;
         else
            if (year == "senior")
               return 4;
            else
               return 0;
}
jlm54@kay:~/214/labs/03$ g++ -Wall year_codes.cpp -o cpp_year_codes
jlm54@kay:~/214/labs/03$ ./year_[K[K[K[K[Kcpp_year_codes

Enter your academic year: freshman
1
jlm54@kay:~/214/labs/03$ sophmore[K[K[K[Komore
sophomore: command not found
jlm54@kay:~/214/labs/03$ sophomore[K[K[K[K[K[K[K[K[Ksophomore./cpp_year_codes

Enter your academic year: sophomore
2
jlm54@kay:~/214/labs/03$ ./cpp_year_codes

Enter your academic year: junior
3
jlm54@kay:~/214/labs/03$ ./cpp_year_codes

Enter your academic year: senior
4
jlm54@kay:~/214/labs/03$ ./cpp_year_codes

Enter your academic year: super senii or
0
jlm54@kay:~/214/labs/03$ exit
exit

Script done on Thu 20 Feb 2014 09:33:28 AM EST
