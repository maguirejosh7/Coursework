

//tracer. draws when clicked by Joshua Maguire on 9/20/2012

//setup for canvas size

void setup(){
  size (300,300);
  background (255);
}

//empty draw to refresh the screen every frame
void draw(){
 
}
//when mouse pressed, draw...
void mouseDragged(){
  stroke (50);
  line(pmouseX,pmouseY,mouseX,mouseY);
  
}

void keyPressed(){
  save("screenshot.png");
}
