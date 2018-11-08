//creates a face that moves around as it fades away
//by Joshua Maguire on 10/3/2012

//global variables for face position
float faceX,faceY;

//setup, smooth, background, setting global variables, etc
void setup(){
  smooth();
  size (400,400);
  background (255);
  faceX=200;
  faceY=200;
}
//always drawing the face where faceX and faceY are
void draw(){
  fill (255,255,255,40);
  rect (0,0,400,400);
  homestarface (faceX,faceY);

}

//when mousePressed or dragged, faceX changes to mouseX, then in draw it will draw
//the face where the mouse is
void mousePressed(){
  faceX=mouseX;
  faceY=mouseY;
  
}

void mouseDragged(){
  faceX=mouseX;
  faceY=mouseY;
}

//method for homestars face
void homestarface (float x,float y){
  //face outline
  strokeWeight(2);
  smooth();
  line (x-30,y,x-15,y+40);
  line (x+20,y,x-30,y);
  noFill();
  arc(x+40, y+28, 100, 170, PI*1.1, TWO_PI*1.01);
  //hat and spinner
  line (x+50,y-55,x+55,y-65);
  line (x+30,y-80,x+80,y-50);
  line (x+80,y-50,x+85,y-70);
  line (x+85,y-70,x+25,y-65);
  line(x+30,y-80,x+25,y-65);
  line(x,y-42,x+75,y-30);
  arc(x-5,y-33,20,20,PI*.6, TWO_PI*.86);
  line(x-10,y-25,x,y-22);
  //eyes
  fill(0);
  ellipse (x+15,y-20,8,8);
  ellipse (x+60,y-17,8,8);
}
