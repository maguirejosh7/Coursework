/*
Lab 2 by Joshua Maguire and Adam Hensen
    This program makes a smile face with text and color
*/
//face
smooth ();
size (200,200);
fill (255,255,0);
ellipse (100,100,150,150);
fill (0,0,0);
ellipse (80,80,25,40);
ellipse (120,80,25,50);
fill (255,255,255);
ellipse (85,75,5,5);
ellipse (125,75,5,5);
noFill ();
arc(100, 120, 80, 80, QUARTER_PI, PI-QUARTER_PI);
//text
fill (255,155,0);
PFont fonta;
fonta = loadFont("Tunga-48.vlw");
textFont(fonta, 32);
text("!Smile!", 60, 200);
