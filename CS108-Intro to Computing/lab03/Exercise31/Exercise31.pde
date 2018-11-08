/*
Lab03 by Joshua Maguire and kristen Carter on 9/13/2012
*/

// Exercise 3.1

//a. yes, because one is int and the other is dble/float
println(2*3);
println(2.0*3.0);
//we were correct

//b. increases by three if int, 1/3 if dble
println("----------------b------------");
println(1/3);
println(1.0/3.0);
//no, then it actually goes up by 1/3 like its supossed to.
println(1.0%3.0);
println(2.0%3.0);
//with mod operator, it goes up by 1.

//c. 
println("----------------c------------");
println(16+8/4);
println(16+(8/4));
println((16+8)/4);
//yes, the order matters - otherwise it's read left to right.

//d.
println("----------------d------------");
//println(1/0); < it knows we can't do this
println(5.1%2.0);
//the integer 2.0 goes into 5.1 with a remainder of 1.09rep.
