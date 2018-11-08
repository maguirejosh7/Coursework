# namer.rb tests class Name and its operations
#
# Begun by: Dr. Adams, for CS 214 at Calvin College.
# Completed by:Joshua Maguire
# Date: 4/9/14
####################################################

require 'test/unit/assertions'   # needed for assert
include Test::Unit::Assertions

class Name
	def initialize(first, middle, last)
		@first, @middle, @last = first, middle, last
		#@fullName = @first+" "+@middle+" "+@last
		#@prints = puts(@fullName)
	end
	attr_reader :first, :middle, :last
	
	
	#Name.fullName concatinates together the first, middle, and last names in the Name class and returns them.
	def fullName
		 return @first+" "+@middle+" "+@last
	end
	
	##Name.Print prints(puts) Name.fullName and returns it also.
	def print
		puts fullName
		fullName#returned
	end
end



def testName
   name = Name.new("John", "Paul", "Jones")

   assert name.first == "John", "first failed"
   assert name.middle == "Paul", "middle failed"
   assert name.last == "Jones", "last failed"
   assert name.fullName == "John Paul Jones", "fullName failed"
   assert name.print == "John Paul Jones", "print failed"
   
   print "All tests passed!\n"
end

testName

