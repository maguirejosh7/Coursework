//Exercise 5.1 by Joshua Maguire and David Jaggard

//a.-----------------------------

//prints true
//println (true);

//nooleans and strings can't mix
//println (true == "true");

//false or not false = true
//println(false || !false);

//the two !s cancel out
//println (!!true);

//can't divide by zero, order doesn't matter in this one or next one
//println((1/0 == 1) || false );

//can't divide by zero
//println (false || (1/0 == 1));


//b. ------------------------------------------------------------
//you need a variable
//println(5 = 5);

//this is a boolean expressions so you do not need a variable
//println(5 == 5);

//4 does not equal 5 is true
//println(4 != 5);

//invalid statement...returns an error since it cannot have < and >
//println(4 <> 5);

//int i = -5;

//println(1 <=i <= 100);
//this is an invalid expression since the left side will return a boolean
//which will then be compared to 100 which is invalid

/*too small (false)
int i = -5;
println(1 <= i && i <= 100);
*/

//too large (false)
//int i = 500;
//println(1 <= i && i <= 100);

//nicely in range (true)
//int i = 50;
//println(1 <= i && i <= 100);

//borderline (true);
//int i = 1;
//println(1 <= i && i <= 100);

