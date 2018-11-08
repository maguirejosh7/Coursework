// This program makes a scalable figure
//by Joshua Maguire and Kyle Mart
//      9/27/2012

//grow rates - grow2 is faster
float grow1;
float grow2;

void setup(){
 size (300,300);
 smooth();
}

//calls for a fiture
void draw(){
  background(255);
  renderFigure (50,50,24+grow1);
  renderFigure (200,200,24+grow2);
  grow1+=.01;
  grow2+=.04;
}

//the figure is scaled
void renderFigure(float x,float y,float diameter) {
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
