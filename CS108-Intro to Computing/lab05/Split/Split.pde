// This program creates random dots in a circle on the screen
//by Joshua Maguire and David Jaggard

//global variables
float x;
float y;
float z;

void setup(){
  background (255);
  size (500,500);
  noStroke();
}


void draw(){
  x = random(500);
  y = random (500); 
  //z = dist(250,250,x,y);
  
  if (x<=250){
    fill (0,0,255);
    ellipse (x,y,20,20);
  }
  else {
    fill (0,255,0);
    ellipse (x,y,20,20);
  }
  
  
}
