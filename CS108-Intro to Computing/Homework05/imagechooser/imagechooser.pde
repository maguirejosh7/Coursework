/*
*This program will show thumbnails for several images and a
*large version of the clicked one.
*Homework05 by Joshua Maguire for CS 108 on 10/10/2012
*/




//ATTENTION!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//>>>>>>>   THIS PROGRAM LOADS SLOOOOOOOOOWLYYYYY    <<<<<<<


//Global Variables
PImage picA, picB, picC, picD;

//setup, loads 4 images and draws their thumbnails
void setup(){
  size (500,300);
  background(0,255,0);
  smooth();
  picA = loadImage("a.JPG");
  picB = loadImage("b.JPG");
  picC = loadImage("c.JPG");
  picD = loadImage("d.JPG");
  image (picA, 0, 0  ,100,75);
  image(picB, 0, 75,100,75);
  image(picC, 0, 150,100,75);
  image(picD, 0, 225,100,75);
}


//if mouse in box 1, image 1.
//else if mouse in box 2, image 2
//  ^   ^  ^     ^   ^  3, ^   3
//  ^   ^  ^     ^   ^  4, ^   4
//else draw green box around big image
void draw(){}
void mousePressed(){
  if (mouseX<=100 && mouseY <= 75){
    image(picA, 100,0,400,300);
  }
  else if (mouseX<=100 && mouseY > 75 && mouseY < 150){
    image(picB, 100,0,400,300);
  }
  else if (mouseX<=100 && mouseY > 150 && mouseY < 225){
    image(picC, 100,0,400,300);
  }
  else if (mouseX<=100 && mouseY > 225 && mouseY < 300){
    image(picD, 100,0,400,300);
  }
  else {
    fill (0,255,0);
    rect (100,0,500,400);
  }
}

