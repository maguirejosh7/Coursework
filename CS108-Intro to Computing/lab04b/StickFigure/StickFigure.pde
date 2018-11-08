// This program makes a scalable figure
//by Joshua Maguire and Kyle Mart
//      9/27/2012

void setup(){
 background(255);
 size (300,300);
 smooth();
 noLoop();
}

//calls for a fiture
void draw(){
  renderFigure ();
}

//the figure is scaled
void renderFigure() {
float x = 150;
float y = 150;
float diameter = 24;
//draw body
line( x , y + diameter * 0.5,x,y + diameter * 1.5 );
//draw arms
line( x-diameter * 0.5 , y + diameter, x + diameter * .5, y + diameter);
//draw left leg
line(x,y + diameter * 1.5,x-diameter*.5,y + diameter * 2);
//draw right leg
line(x,y + diameter * 1.5,x+diameter*.5,y + diameter * 2);
//draw head
ellipse(x,y,diameter,diameter);


}
