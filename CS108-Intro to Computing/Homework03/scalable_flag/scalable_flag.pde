/*
This program, created by Joshua Maguire on 9/19/2012, creates a scalable flag.

The verticle size of the flag matches the scal in pixles,
and the horizontal size is 2 times the size of the scal.
example: fScal as 100 makes a 100 by 200 flag
 */


//Scalling variable    fScal
int fScal = 800;


//setting up the canvas
smooth();
size(fScal*2,fScal);
fill (255,255,0);
background(255,255,0);

// face
strokeWeight(fScal*.02);
ellipse (fScal,fScal*0.5,fScal*.7,fScal*.7);

//eyes
strokeWeight(1);
fill (0);
ellipse (fScal*.9,fScal*.4,fScal*.1,fScal*.2);
ellipse (fScal*1.1,fScal*.4,fScal*.1,fScal*.2);

//smile
noFill();
strokeWeight(fScal*.02);
arc(fScal, fScal*.6, fScal*.4, fScal*.27, PI*.1, PI*.9);

//text of SMILE! with each char a different color
PFont smileyFont;
smileyFont = loadFont("smileyfont.vlw"); 
textFont(smileyFont, fScal*.25); 
fill(0,255,20);
text("S", fScal*.5, fScal*.21);
fill(255,0,0);
text("M", fScal*.7, fScal*.21);
fill (0,0,255);
text("I", fScal*.95, fScal*.21);
fill(180,0,255);
text("L", fScal*1.12, fScal*.21);
fill(255,150,0);
text("E", fScal*1.28, fScal*.21);
fill(0,255,255);
text("!", fScal*1.48, fScal*.21);

//stroke weight change with scal?
