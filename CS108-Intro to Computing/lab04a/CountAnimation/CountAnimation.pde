//creates a thing by Joshua Maguire on 9/20/2012
//global variables
int lN;
String oS;

void setup(){
size (300,300);
background(255,50,222);
lN = 1;
oS ="1";
}

void draw(){

 //Use text() to place the current 
 //output string at the current line number.
 text (oS,1,12*lN);
 
//update count by 1
lN = lN+1;


//update output to append a space and new count
  
 oS = oS+"  "+lN;
 
}
