/*
Lab03 by Joshua Maguire and kristen Carter on 9/13/2012
this program creates a flag that scales
*/

//Exercise 3.5
//our scalining variable is scal. 100 is a good starting point.
smooth();
int scal = 200;
fill (255,255,255);
background (255,255,255);
//size
int xsize = scal*3;
int ysize = scal*2;
size(scal*3,scal*2);
//circle
noStroke();
fill(180,0,0);
ellipse(scal*1.5,scal*1,scal*1.2,scal*1.2);

