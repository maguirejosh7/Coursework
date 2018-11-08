# namer.rb tests class Name and its operations
#
# Begun by: Dr. Adams, for CS 214 at Calvin College.
# Completed by:Joshua Maguire
# Date: 4/10/14
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
	
	#Name.setFirst/Middle/Last are mutator methods, recieve a string, sets it equal to Name.First/Middle/Last...
	def setFirst(first)
		@first = first
	end
	def setMiddle(middle)
		@middle=middle
	end
	def setLast(last)
		@last=last
	end
		
 ####################################################
 # lfmi function, for a given Name, returns a 
 # string giving its Last-First-MiddleInitial form.
 # Recieve: a first, middle or last name
 # Return: string in Last-First-MiddleInitial form
 ####################################################
	def lfmi
		return @last+" "+@first+" "+@middle[0]
	end
	
	#####################################################
 # readName function reads in first, middle and 
 # last names via keyboard.
 ######################################################
  def readName
  	@first=gets.chomp.to_s
  	@middle=gets.chomp.to_s
  	@last=gets.chomp.to_s
  end
	
end # of namer class



def testName
   name = Name.new("John", "Paul", "Jones")

   assert name.first == "John", "first failed"
   assert name.middle == "Paul", "middle failed"
   assert name.last == "Jones", "last failed"
   assert name.fullName == "John Paul Jones", "fullName failed"
   assert name.print == "John Paul Jones", "print failed"
   ####### project tests########
   assert name.setFirst("Bill") == "Bill", "setFirst() failed!"
   assert name.setMiddle("Happy") == "Happy", "setMiddle() failed!"
   assert name.setLast("Tanker") == "Tanker", "setLast() failed!"
   assert name.lfmi == "Tanker Bill H","lfmi() failed!"
   puts(name.lfmi)
	 puts("Enter \"Andrew Ben Carper\" on seperate lines:");
	 name.readName
   name.print
	 assert name.fullName == "Andrew Ben Carper","readName() failed!"
   print "All tests passed!\n"
end

testName

