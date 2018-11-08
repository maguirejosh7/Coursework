/*
Lab 2 by Joshua Maguire and Adam Hensen
   This program makes a smiley with color
*/


smooth ();
size (200,200);
//head
fill (255,255,0);
ellipse (100,100,150,150);
//eyes
fill (0,0,0);
ellipse (80,80,25,40);
ellipse (120,80,25,50);
//eye sparkles
fill (255,255,255);
ellipse (85,75,5,5);
ellipse (125,75,5,5);
//smile
noFill ();
arc(100, 120, 80, 80, QUARTER_PI, PI-QUARTER_PI);
