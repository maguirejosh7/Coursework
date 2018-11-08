// This program creates random dots in a circle on the screen
//by Joshua Maguire and David Jaggard

//global variables
float x;
float y;
float z;

void setup(){
  background (255);
  size (500,500);
}


void draw(){
  x = random(500);
  y = random (500); 
  z = dist(250,250,x,y);
  
  if (z>=0 && z<=235){
    fill (255,12,123);
    noStroke();
    ellipse (x,y,20,20);
  }
  
  
  
  
}
