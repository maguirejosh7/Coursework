-- roots.cpp computes the roots of a quadratic equation 
--
-- Input: three terms of quadratic equation ( y = ax^2 + bx + c )
-- PRE: a > 0, (b^2 - 4ac) != negative
-- Output: x = root1, x = root2
--
-- Begun by: Dr. Adams, for CS 214 at Calvin College.
-- Completed by:Joshua Maguire
-- Date:3/13/14
------------------------------------------------------------------

with Ada.Text_IO, Ada.Float_Text_IO, Ada.Numerics.Elementary_Functions; 
use  Ada.Text_IO, Ada.Float_Text_IO, Ada.Numerics.Elementary_Functions;


procedure roots is
rootA, rootB, rootC, root1, root2, arg : Float;
	
-- quadraticRoots cmputes the roots of a quadratic equation
-- Input: three terms of quadratic equation ( y = ax^2 + bx + c )
-- PRE: a > 0, (b^2 - 4ac) != negative
-- Output: x = root1, x = root2
procedure quadraticRoots( a, b, c: in Float; root1, root2: in out float) is
begin
	if (a /= 0.0) then
	arg := b**2 - 4.0 * A * c;--b^2 - 4ac
		if(arg >= 0.0) then
		root1:= (-b + Sqrt(arg))/(2.0*a);--(-b + sqrt(arg))/2a
		root2:= (-b - Sqrt(arg))/(2.0*a);--(-b - sqrt(arg))/2a 
		return;
		else 
		Put("*** quadraticRoots(): b^2 - 4ac is negative!");
		root1 := 0.0; root2 := 0.0;
		return;
		end if;
	else 
	Put("\n*** QuadraticRoots(): a is zero!");
	root1 := 0.0; root2 := 0.0;
	return;
	end if;	
end quadraticRoots;
 

begin
	Put("Enter first term for quadratic equation:");Get(rootA);--get first root
	Put("Second:");Get(rootB);--second..
	Put("Third:");Get(rootC);--third..
	quadraticRoots(rootA,rootB,rootC,root1,root2);
	if (root1 /= 0.0 and root2 /= 0.0) then 
	Put("x = ");Put(root1);New_Line;Put("x = ");Put(root2);--Put result
	end if;
end roots;
