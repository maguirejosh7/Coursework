/*
     Homework02 by Joshua Maguire on 9/12/2012
     This program makes a logo poste
*/
//getting canvis started
size (700,500);
background(255,255,255);
smooth ();
//loading aperture logo (curcle thing)
PImage aperturelogo;
aperturelogo = loadImage("aperturelogo.png");
image(aperturelogo, 0, 150);

//white triangle with no edges to cover up part of the logo
fill(255,255,255);
noStroke();
triangle(180, 220, 120, 290, 200, 280);

//font and text for aperture

fill(0,0,0);
PFont apertureFont;
apertureFont = loadFont("aperture.vlw"); 
textFont(apertureFont, 150); 
text("Aperture", 155, 280);

// font and blue text for LABORATORIES     laboratories.vlw
fill(1,108,214);
PFont labFont;
labFont = loadFont("laboratories.vlw"); 
textFont(labFont, 38); 
text("L A B O R A T O R I E S", 180, 327);

//companion cube (box with heart on it)
stroke(100,100,100);
strokeWeight(3);
noFill();
rect(500, 70, 100, 100);
//lines to make it look 3d
line(500,70,480,55);
line(500,170,480,155);
line(480,155,480,55);
line(480,55,570,55);
line(570,55,600,70);
//heart
PImage heart;
heart = loadImage("heart.jpg");
image(heart, 510, 75);
