-- namer.adb "test-drives" the Name type.
--
-- Begun by: Dr. Adams, CPSC 280, October 1999.
-- Completed by: Joshua Maguire
-- Date: 4/14/14
----------------------------------------------

with Ada.Text_IO; use Ada.Text_IO;
with name_package; use name_package;

procedure namer is


  aName : name_package.Name ;
  
    ----------------------------------------------
  -- Put(Name) displays a Name value.          -
  -- PRE: Nm has been initialized.             -
  -- Receive: Nm, a Name.                      -
  -- Output: Nm, to the screen.                -
  ----------------------------------------------
  procedure Put(Nm: in name_package.Name) is
  begin
    Put( getFullName(Nm) );
  end Put;


begin
   name_package.Init(aName, "John    ", "Paul    ", "Jones   ");

   pragma Assert( name_package.getFirst(aName) = "John    ",
                   "getFirst() failed");
   pragma Assert( name_package.getMiddle(aName) = "Paul    ", 
                   "getMiddle() failed");
   pragma Assert( name_package.getLast(aName) = "Jones   ", 
                   "getLast() failed");
   pragma Assert( name_package.getFullName(aName) = "John     Paul     Jones   ",
                    "getFullName() failed");
   Put(aName); New_line;
   Put("All tests passed!"); New_line;
end namer;

