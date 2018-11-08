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
