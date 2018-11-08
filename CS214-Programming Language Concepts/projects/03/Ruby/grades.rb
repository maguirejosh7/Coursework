#grades.rb computes letter grade of given int class average
# Input:int average
# Output: the letter grade associated with average
#
# By: Joshua Maguire
# Date:2/26/14
###############################################################


#computeGrages outputs letter grade coresponding to recieved int
# Input:int average
# Output: the letter grade associated with average
def computeGrades(myAverage)
	case (myAverage/10)
		when 9..10 then puts 'A' #if myAverage is in range 9 to 10 after being divided by 10, then put "A".
		when 8..9 then puts 'B'#^^^...
		when 7..8 then puts 'C'
		when 6..7 then puts 'D'
		else puts 'F'
	end		
end


if __FILE__ == $0 #If file run directly
	print "Enter int average:"
	average=gets.chomp.to_f #get the int from keyboard
	computeGrades(average) #run method, which outputs result.
end
