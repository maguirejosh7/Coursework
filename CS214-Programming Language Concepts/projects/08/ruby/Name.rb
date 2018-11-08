# Name.rb houses the class and module for names/name
# Completed by: Joshua Maguire
# Date: 4/14/14
####################################################


module Names
	class Name

	  def initialize(first, middle, last)
		@first, @middle, @last = first, middle, last
	  end

	  attr_reader :first, :middle, :last

	  def fullName
		@first + " " + @middle + " " + @last
	  end

	  def print
		puts fullName
		fullName
	  end
	end
end