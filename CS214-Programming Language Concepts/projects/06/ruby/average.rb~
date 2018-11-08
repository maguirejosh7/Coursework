# average.rb averages the values of an array of doubles.
# Precondition: theArray is an array of numbers
# Output: the average of the values in theArray
#
# Begun by: Dr. Adams, for CS 214 at Calvin College.
# Completed by:: Joshua Maguire
# Date: 3/10/14
########################################################

###############################################
# sum() sums the values in an array
# Receive: anArray, an array of numbers
# Return: the sum of the values in anArray.
################################################
def sum(anArray)
	total = 0.0
	anArray.each {| num |total += num}#each "num"/element in anArray, total+= it.
	return total
end
###############################################
#average averages the values in an array. 
#Receive: anArray, an array.              
#Return: the average of the values. 
###############################################
def average(anArray)
	if (anArray.size <= 0) then return 0.0
	else return (sum(anArray)/anArray.size)
	end
end

#main
if __FILE__ == $0
   array0=Array.new
   array1=[6.0,7.0,8.0,9.0]
   puts "sum 0 is: #{ sum(array0) }\n"
   puts "sum 1 is: #{ sum(array1) }\n"
   puts "average 0 is: #{ average(array0) }\n"
   puts "average 1 is: #{ average(array1) }\n"
end

