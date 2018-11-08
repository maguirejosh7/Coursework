-- fact.adb displays the factorial of a positive number n.
-- Input: unsigned n
-- PRE: positive integer
-- Output: factorial of the number
-- Begun by Professor Adams? for CS 214 at Calvin COllege
-- Edited by Joshua Maguire
--------------------------------------------------------------

with Ada.Text_IO,Ada.Integer_Text_IO;
use Ada.Text_IO, Ada.Integer_Text_IO;


procedure fact is
	n : integer; --Ada doesn't have the unsigned type. Could use mod-1 but is a little unnecesarry. Anyone who disobeys the consol WILL get errors. This is the number we will input from user.
	

	
------------computeFact FUNCTION-----------------
-- computeGrades computes the factorial of a positive number n.
-- Input: int n
-- PRE: positive integer
-- Output: factorial of the number
function computeFact(n: in integer) return integer is 
answer:integer; --declaring answer variable
begin
	answer := 1; --initializing it..
	For i in Integer Range 2 .. n loop --our count-up for loop
		answer := answer * i;          --answer *= i
	end loop;						   --i auto incremented
	
	return answer;
end computeFact;
-----------end computeFact FUNTION----------------

------main--------------
begin 
	Put("To compute n!, enter positive integer n: ");
	Get(n);
	Put(n); --Why didn't Put_Line(n) work?
	Put("! = ");
	Put(computeFact(n)); --calls function... for some reason big space inbetween "! = " and the answer...owell. 
end;
-------end main-----------------------
