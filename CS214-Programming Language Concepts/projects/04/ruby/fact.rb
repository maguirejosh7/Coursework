# fact.cpp displays the factorial of a positive number n.
# Input: unsigned n
# PRE: positive integer
# Output: factorial of the number
# Begun by Professor Adams? for CS 214 at Calvin COllege
# Edited by Joshua Maguire
#*******************************************************/


# computeFact computes the factorial of a positive number n.
# Input: unsigned n
# PRE: positive integer
# Output: factorial of the number
def computeFact(n) #declare..
	result=1 #set result to default 1
	for i in 2..n #for loop
		result=result*i
	end 
	puts result #print result
end


#main
if __FILE__ == $0
	print "\nTo compute n!, enter n: "
	n = gets.chomp.to_i
	print n
	print "! = "
	computeFact(n)
end
