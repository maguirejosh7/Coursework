-- circle_area.adb computes the area of a circle.
--
-- Input: The radius of the circle.
-- Precondition: The radius is a positive number.
-- Output: The area of the circle.
--
-- Begun by: Dr. Nelesen, CS 214 at Calvin College.
-- Completed by: Joshua Maguire
-- Date:2/10/14
----------------------------------------------------

with Ada.Text_IO, Ada.Float_Text_IO;
use  Ada.Text_IO, Ada.Float_Text_IO;

procedure ada_rectangle_area is

   l, w, area: float; --2 new variables

   -- function rectangleArea computes a rectangle's area, given its length and width
   -- Parameter: l, w float
   -- Precondition: l,w >= 0.0
   -- Return: the area of the rectangle
   ----------------------------------------------------
   function rectangleArea(l,w: in float) return float is --declare function
   begin	--start of function (after declaring new variables)
      return l*w; --return area of circle (PI*r^2)
   end rectangleArea; --end of function

begin                           --begin beginning of program (after above declarations of new vars.
   Put_Line("To compute the area of a rectangle,"); --newline of txt
   Put("enter its length: "); --new txt
   Get(l); --..from keyboard
   Put("enter its width: "); --new txt
   Get(w); --..from keyboard
   area := rectangleArea(l,w); --calls function to previously declared variables

   Put("The area is "); --txt
   Put(area); --output area var
   New_Line; --..
end ada_rectangle_area; --end prgrm
