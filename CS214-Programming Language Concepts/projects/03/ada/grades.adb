--grades.adb tests the letterGrade method given from the
--project. By Joshua Maguire on 2/26/14 for Calvin College.
-----------------------------------
with Ada.Text_IO, Ada.Float_Text_IO, Ada.Strings, Ada.Integer_Text_IO;
use  Ada.Text_IO, Ada.Float_Text_IO, Ada.Strings, Ada.Integer_Text_IO;

procedure grades is
 average : integer;
 grade : character;

--function computeGrades computes the letter grade given the percentage as an int
--parameter myAverage, an int
--precondition: 
--return: char letter grade
function computeGrades (myAverage: in integer) return character is
result:character; --to be returned
begin
	case (myAverage/10) is 
		when 10 => result := 'A';
		when 9 => result :=  'A';
		when 8 => result :=  'B';
		when 7 => result :=  'C';
		when 6 => result :=  'D';
		when others => result := 'F';
	end case;
	return result;
end computeGrades;


begin
 Put("enter average as int:");
 Get(average);
 grade := computeGrades(average);
 Put(grade);
end grades;
