//Scribbler by Joshua Maguire on 9/20/2012
//scribbles randomly



//global variables
float x, y;

void setup(){
 size (300,300); 
 background (255);
 x = 150;
 y = 150;
 fill (0);
}

void draw(){

  //new random variables near x and y
  float newsX = random(x-5,x+5);
  float newsY = random(y-5,y+5);
  //constraining new variables on screen
  newsX = constrain(newsX, 0, 300);
  newsY = constrain(newsY, 0, 300);
  //line from old to new
  line (x,y,newsX,newsY);
 // old = new
x=newsX;
y=newsY;

}

//whem oused pressed
void mousePressed(){
  x=mouseX;
  y=mouseY;
  //random color
  stroke (random(0,255),random(0,255),random(0,255));
}

