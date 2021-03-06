-- circle_area.adb computes the area of a circle.
--
-- Input: The radius of the circle.
-- Precondition: The radius is a positive number.
-- Output: The area of the circle.
--
-- Begun by: Dr. Nelesen, CS 214 at Calvin College.
-- Completed by: Joshua Maguire
-- Date:2/6/14
----------------------------------------------------

with Ada.Text_IO, Ada.Float_Text_IO;
use  Ada.Text_IO, Ada.Float_Text_IO;

procedure circle_area is

   radius, area : float; --2 new variables

   -- function circleArea computes a circle's area, given its radius
   -- Parameter: r, a float
   -- Precondition: r >= 0.0
   -- Return: the area of the circle whose radius is r
   ----------------------------------------------------
   function circleArea(r: in float) return float is --declare function
      PI : constant := 3.1415927; --declare new constant PI
   begin	--start of function (after declaring new variables)
      return PI * r ** 2; --return area of circle (PI*r^2)
   end circleArea; --end of function

begin                           --begin beginning of program (after above declarations of new vars.
   Put_Line("To compute the area of a circle,"); --newline of txt
   Put("enter its radius: "); --new txt
   Get(radius); --..from keyboard

   area := circleArea(radius); --calls function to previously declared variable

   Put("The area is "); --txt
   Put(area); --output area var
   New_Line; --..
end circle_area; --end prgrm
