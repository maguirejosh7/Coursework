// This program makes a scalable figure
//by Joshua Maguire and Kyle Mart
//      9/27/2012

//global variables
float xMove;
float yMove;
float x1,x2,y1,y2;
float sunX;
float sunY;
float stickColor1;
float stickColor2;

void setup(){
 size (300,300);
 smooth();
 x1 = 50;
 y1 = 50;
 x2 = 200;
 y2 = 200;
 sunX = 200;
 sunY = 50;
}

//calls for a figure
void draw(){
  background(255);
//calculates stick color 1/2by looking at its distance to the sun
  stickColor1 = dist(sunX,sunY,x1,y1);
  stickColor2 = dist(sunX,sunY,x2,y2);
  renderFigure (x1,y1,stickColor1);
  renderFigure (x2,y2,stickColor2);
  //asks for new numbers close to it
  x1 = changeCoordinate(x1,0,300);
  y1 = changeCoordinate(y1,0,300);
  x2 = changeCoordinate(x2,0,300);
  y2 = changeCoordinate(y2,0,300);
//draw sun
  fill(255,255,0);
  ellipse(sunX,sunY,50,50);
}

//the figure is scaled
void renderFigure(float x,float y,float hotness) {
float diameter = 24;
//changes figure color depending on hotness(stickColor1/2)
stroke(255-hotness,0,0);
//draw body
line( x , y + diameter * 0.5,x,y + diameter * 1.5 );
//draw arms
line( x-diameter * 0.5 , y + diameter, x + diameter * .5, y + diameter);
//draw left leg
line(x,y + diameter * 1.5,x-diameter*.5,y + diameter * 2);
//draw right leg
line(x,y + diameter * 1.5,x+diameter*.5,y + diameter * 2);
//draw head
noFill();
ellipse(x,y,diameter,diameter);
}

//gives us a random number constrained to the screen
//and sends it back to change coordinate.
float changeCoordinate(float value,float lowerBound,float upperBound) {
value += random(-5,5);
value=constrain(value,lowerBound,upperBound);
return value;
}
