-- split.adb splits an input string about a specified position.
--
-- Input: Astring, a string,
--        Pos, an integer.
-- Precondition: pos is in Astring'Range.
-- Output: The substrings Astring(Astring'First..Pos-1) and
--                        Astring(Pos..Astring'Last).
--
-- Begun by: Dr. Adams, for CS 214 at Calvin College.
-- Completed by:Joshua MAguire
-- Date:3/6/14
--------------------------------------------------------------

with Ada.Text_IO, Ada.Integer_Text_IO,Ada.Strings.Fixed; 
use  Ada.Text_IO, Ada.Integer_Text_IO,Ada.Strings.Fixed;

procedure split is

   EMPTY_STRING : String := "                                        ";

   Astring, Part1, Part2 : String  := EMPTY_STRING;
   Pos, Chars_read       : Natural;
 
   ------------------------------------------------
   --  computeSplit() splits a string in two.           
   -- Receive: The_String, the string to be split,
   --          Position, the split index.        
   -- PRE: 0 < Position <= The_String.length(). 
   --     (Ada arrays are 1-relative by default)
   -- Passback: First_Part - the first substring,
   --           Last_Part - the second substring.
   ------------------------------------------------
procedure computeSplit( Astring : in String; Pos : in Natural; Part1, Part2 : in out String) is
begin
	move(Astring(Astring'First .. Pos), Part1);--copy Astring from start to Pos into Part1 string
	move(Astring(Pos+1 .. Astring'Last), Part2);--similarly ^^
end computeSplit;--don't return anything, this is a procedure. Our work here is done.

begin                                           -- Prompt for input
   Put("To split a string, enter the string: ");
   Get_Line(Astring, Chars_Read);
   Put("Enter the split position: ");
   Get(Pos);

   computeSplit(Astring, Pos, Part1, Part2);

   Put("The first part is ");
   Put_Line(Part1);
   Put(" and the second part is ");
   Put_Line(Part2);

end split;

