Script started on Fri 07 Feb 2014 10:08:22 AM EST
jlm54@codd:~/214/labs/01$ cat circle_area.rb
cat: circle_area.rb: No such file or directory
jlm54@codd:~/214/labs/01$ cd 04
jlm54@codd:~/214/labs/01/04$ cd 04at circle_area.rb
#! /usr/bin/ruby
# circle_area.rb computes the area of a circle given its radius
# 
# Input: the radius of a circle
# Precondition: the radius is not negative
# Output: the area of the circle.
#
# Begun by: Dr. Nelesen, for CS 214 at Calvin College.
# Completed by: Joshua Maguire
# Date:2/7/14
###############################################################

# function circleArea returns a circle's area, given its radius
# Parameters: r, a number
# Precondition: r > 0.
# Returns: the area of a circle whose radius is r.
PI = 3.1415927 #define pie
def circleArea(r) #define funct circleArea, takes in radius
    PI * r ** 2 #math
end #end funct

if __FILE__ == $0 #if file run directly,
   print "Enter the radius: " #...
   radius = gets.chomp.to_f #gets(from keyboard, chomp excludes crazy characters)
   print "Area is: " #..
   puts circleArea(radius) #print (circleArea method) 
end
jlm54@codd:~/214/labs/01/04$ ruby circle_area.rb
Enter the radius: 1
Area is: 3.1415927
jlm54@codd:~/214/labs/01/04$ ruby circle_area.rb
Enter the radius: 2
Area is: 12.5663708
jlm54@codd:~/214/labs/01/04$ ruby circle_area.rb
Enter the radius: 2.5
Area is: 19.634954375
jlm54@codd:~/214/labs/01/04$ ruby circle_area.rb
Enter the radius: 4.99999
Area is: 78.53950334104417
jlm54@codd:~/214/labs/01/04$ exit
exit

Script done on Fri 07 Feb 2014 10:09:33 AM EST
