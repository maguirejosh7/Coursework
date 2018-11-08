// This program creates random dots in a circle on the screen
//by Joshua Maguire and David Jaggard

//global variables
float x;
float y;
float z;
float sizeC;

//setting up screen and background
void setup(){
  background (255);
  size (500,500);
  noStroke();
}

//every frame make x and y random and check their distance from
///the center fof the screen, which equals z.
void draw(){
  x = random(500);
  y = random (500); 
  z = dist(250,250,x,y);
  sizeC = random(30);
  //THEN, if its within the closest difference, blue
  if (z>=0 && z<=80 ){
    fill (0,0,255,random(75));
    ellipse (x,y,sizeC,sizeC);
  }
  //Othereise, if its in the middle, GREEN
  else if (z>80 && z<=160){
    fill (0,255,0,random(75));
    ellipse (x,y,sizeC,sizeC);
  }
  //all else, its in the outer ring and its RED
  else {
    fill (255,0,0,random(75));
    ellipse (x,y,sizeC,sizeC);
  }
  
}
