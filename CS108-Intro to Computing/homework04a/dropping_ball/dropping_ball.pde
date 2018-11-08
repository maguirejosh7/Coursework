//this program, finished by Joshua Maguire, allows
//you to play with a ball with gravity and velocity

//global variables
final int BALL_SIZE = 25;
float gravity = 0.20; // fall acceleration
int width = 500, height = width;
float ballX, ballY;         // ball location
float deltaX, deltaY;       // ball velocity
//setting up screen and ball starting position and velocity
void setup() {
  size(width, height);
smooth();
// Start the ball in the upper left.
ballX = 15;
ballY = 15;
// Set the rate of change for x and y(velocity)
deltaX = 0;
deltaY = 0;
}
//when mousepressed, gravity and velocity = 0, ball = mouse position.
void mousePressed (){
ballX = mouseX;
ballY = mouseY;
deltaX = 0;
deltaY = 0;
gravity = 0;
}
//whem moused released gravity goes on again and velocity calculated.
void mouseReleased(){
  gravity = .2;
  deltaX = mouseX - pmouseX;
  deltaY = mouseY - pmouseY;
}
//ball follows mouse when mouse dragged
void mouseDragged(){
  ballX = mouseX; 
  ballY = mouseY;
  
}
//every frame ball gets more velocity from gravity
//and screen is erased 
void draw() {
  // Erase the ball at the previous location.
background(255);
// Draw the ball at the current location.
fill(80, 130, 190);
ellipse(ballX, ballY, BALL_SIZE, BALL_SIZE);
// Move the ball to the right and down.
ballX += deltaX;
ballY += deltaY;
deltaY += gravity;
}
//when any key pressed, program stops
void keyPressed(){
  stop();
}
