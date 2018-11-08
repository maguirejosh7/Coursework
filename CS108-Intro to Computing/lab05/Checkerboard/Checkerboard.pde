
//This program creates a checkers board with squares of 100x100
//By Joshua Maguire and David Jaggard on 10/4/2012

//globals
float x;
float y;

// screen size and color
void setup(){
  background (255);
  size (500,500);
  smooth();
}

//gets random numbers for x and y
void draw(){
  x= random(500);
  y= random(500);
 
  //tests x and y to see if they should be drawn or not
  if ((x%200 < 100 && y%200 < 100)||(x%200 > 100 && y%200 > 100)){
  strokeWeight(10);
  point(x,y);
}
  else{
  }

// You can see real time what the numbers are and see for yourself how
//they fit into the big if statement. This helped us figure it out.
//      (!!!!!helps if you turn the framerate down!!!!!!!)
println (x%200);
println (y%200);
}

