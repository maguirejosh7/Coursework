-- log_table.adb computes a table of logarithms.
--
-- Input: start, stop, increment, three reals.
-- Precondition: increment is positive.
-- Output: A table of logarithms beginning with log(start),
--         ending with log(stop), with intervals of increment.
--
-- Begun by: Dr. Adams, for CS 214 at Calvin College.
-- Completed by:Joshua Maguire
--------------------------------------------------------------

with Ada.Text_IO, Ada.Float_Text_IO, Ada.Numerics.Elementary_Functions;
use  Ada.Text_IO, Ada.Float_Text_IO, Ada.Numerics.Elementary_Functions;

procedure log_table is

   Start, Stop, Increment, Counter : Float;

begin                                           -- Prompt for input
   Put_Line("To print a table of logarithms,");
   Put(" enter the start, stop, and increment values: ");
   Get(Start); Get(Stop); Get(Increment);

   -- form 1: general purpose indeterminate loop.
	 Counter := Start; --counter keeps track of count in loop
	 loop
			exit when (Counter > Stop);
			Put("The logarithm of ");
			Put(Counter);
			Put(" is ");
			Put( log(Counter,10.0) );
			Counter := (Counter + Increment); --increment counter
			New_Line;
	 end loop;
	 -- end form 1 loop.

end log_table;

