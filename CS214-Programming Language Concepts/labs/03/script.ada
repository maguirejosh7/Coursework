Script started on Fri 21 Feb 2014 09:37:27 AM EST
jlm54@zuse:~/214/labs/03$ cat year_codes.adb
-- year_codes.adb converts academic year codes to corresponding years.
--
-- Begun by: Dr. Adams, for CS 214 at Calvin College.
--Continued by Joshua Maguire on 2/20/14
-- Input: year, a string
-- Precondition: year is one of "freshman", "sophomore", "junior", "senior"
-- Output: The year code (1, 2, 3 or 4) corresponding to year.
----------------------------------------------------

with Ada.Text_IO, Ada.Integer_Text_IO;
use  Ada.Text_IO, Ada.Integer_Text_IO;

procedure year_codes is

   year : String(1..9) := "         ";
   charsRead : Natural;


   function year_codes (myYear: in string ) return integer is--funct that compares input and outputs yearcode
   begin                                          
    if (myYear="freshman ") then return 1;
    elsif (myYear="sophomore") then return 2;
    elsif (myYear="junior   ") then return 3;
    elsif (myYear="senior   ") then return 4;
    else return 0;
    end if;
   end year_codes;

begin
 Put("Enter your academic year: ");           -- Prompt for input
 Get_Line(year, charsRead);                   -- Input
 Put( year_codes(year) );                       -- Convert and output
 New_Line;
end;
jlm54@zuse:~/214/labs/03$ cat year_codes.adb[1Pscript poopscriptcpp+script[1P./cpp_year_codes[4Pyear_codes year_codesg++ -Wall year_codes.cpp -o cpp_year_codes[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C[C./ year_codes[K[1Pyear_codescpp_year_codesscript cpp+scriptpoopscriptcat year_codes.adb[Kgnatmake year_codes.adb
gcc-4.6 -c year_codes.adb
gnatbind -x year_codes.ali
gnatlink year_codes.ali
jlm54@zuse:~/214/labs/03$ ./year_codes
Enter your academic year: freshman
          1
jlm54@zuse:~/214/labs/03$ ./year_codes
Enter your academic year: sophomore
          2
jlm54@zuse:~/214/labs/03$ ./year_codes
Enter your academic year: junior
          3
jlm54@zuse:~/214/labs/03$ ./year_codes
Enter your academic year: senior
          4
jlm54@zuse:~/214/labs/03$ ./year_codes
Enter your academic year: supersenior
          0
jlm54@zuse:~/214/labs/03$ exit

Script done on Fri 21 Feb 2014 09:38:20 AM EST
