# array.rb arrays.cpp reads in a user-specified amount of values into an array, then prints them out. Driver driven.  # Begun by: Dr. Adams, for CS 214 at Calvin College.
# Completed by: Joshua Maguire
# Date:4/2/14
##############################################


###################################
#Read Array reads in contents of array
#input: an array and its size
##############################3
def readArray(theArray, itsSize)
	print "\nEnter arrays contents:\n"
	#theArray.each { |num| num=gets.chomp.to_i} Why doesn't this work?
	while itsSize > 0 do
		theArray.push(gets.chomp.to_i)
		itsSize=itsSize-1
	end
end
###############################
#printArray simply puts the arrays contents
##############################
def printArray (theArray)
 puts theArray
end

#main
if __FILE__ == $0
   print "\nEnter array size:"
   arraySize=gets.chomp.to_i
   anArray=Array.new(arraySize)
   readArray(anArray, arraySize)
   printArray(anArray)
end

