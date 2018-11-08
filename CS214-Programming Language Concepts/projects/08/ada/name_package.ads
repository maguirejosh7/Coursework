-- name_package.ads declares the Name type and its operations.
--
-- Begun by: Dr. Adams, CS 214 at Calvin College.
-- Completed by: Joshua Maguire
-- Date: 4/14/14
--------------------------------------------------------------

package Name_Package is

  type Name is private;
  ----------------------------------------------
  -- Init initializes a Name variable          
  -- Receive: Nm, the Name variable;          
  --          First, the first name;         
  --          Middle, the middle name;      
  --          Last, the last name.         
  -- Return: Nm, its fields set to First, 
  --               Middle, and Last.     
  ----------------------------------------------
  procedure Init(Nm: out Name; First, Middle, Last : in String) ;
	
	
  ----------------------------------------------
  -- getFirst(Name) retrieves Name.myFirst        
  -- Receive: Nm, a Name.                      
  -- PRE: Nm has been initialized.            
  -- Return: Nm.myFirst.                     
  ----------------------------------------------
  function getFirst( Nm: in Name) return String;

  ----------------------------------------------
  -- getMiddle(Name) retrieves Name as a String 
  -- Receive: Nm, a Name.        
  -- PRE: Nm has been initialized.
  -- Return: Nm.myMiddle. 
  ----------------------------------------------
  function getMiddle( Nm: in Name) return String;
  
  ----------------------------------------------
  -- getLast(Name) retrieves Name.myLast       
  -- Receive: Nm, a Name.                    
  -- PRE: Nm has been initialized.            
  -- Return: Nm.myLast.                        
  ----------------------------------------------
  function getLast( Nm: in Name) return String;
  
  ----------------------------------------------
  -- getFullName(Name) retrieves Name as a String -
  -- Receive: Nm, a Name.                      -
  -- PRE: Nm has been initialized.             -
  -- Return: a String representation of Nm.    -
  ----------------------------------------------
  function getFullName( Nm: in Name) return String;
  

  
  private
  NAME_SIZE : constant Positive := 8;

  type Name is
      record
         myFirst,
         myMiddle,
         MyLast : String(1..NAME_SIZE);
      end record;

  
  end Name_Package;


