-- arrays.adb reads in a user-specified amount of values into an array, then prints them out. Driver driven. 
--
-- Begun by: Dr. Adams, for CS 214 at Calvin College.
-- Completed by: Joshua Maguire
-- Date:4/8/14
------------------------------------------------------

with Ada.Text_IO; use Ada.Text_IO;             -- Put(String)
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO; 
with Ada.Float_Text_IO; use Ada.Float_Text_IO;
procedure arrays is


type Vector is array (Positive range <>) of Float;-- Declare Vector type

itsSize,temp: Float;


-- readArray reads in an arrays contents.
--input: float array anArray
---------------------------------------
procedure readArray(anArray: in out Vector) is
--	myArray:Vector:=anArray;
begin
	Put("Enter array elements:");
	for i in 1..anArray'Length Loop
		Get(temp);
		anArray(i):=temp;
		--Get(anArray(i));--------???????? why doesn't this work?
		 
	end Loop;
end readArray;

procedure printArray(anArray : Vector) is 
-- printArray prints an arrays contents.
-- Input: float array anArray, int size, ostream
-- Output: arrays contents
-------------------------------
begin
	Put_Line("");	Put_Line("");
for i in 1..anArray'Length Loop
	Put(anArray(i));
	Put_Line("");
end Loop;
end printArray;


begin
   Put("Enter array size:");
   Get (itsSize);
   declare
   	theArray: Vector(1..Integer(itsSize));
   begin
   	readArray(theArray);
   	printArray(theArray);
   end;   
end arrays;
