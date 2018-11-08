# Duck.rb | Defines the Duck class which inherits attributes and methods
#   from the Bird superclass.
#
# Begun by: Dr. Adams, for CS 214 at Calvin College.
# Completed by: Joshua Maguire
# Date: 5/4/14
####################################################

require_relative 'Bird'

class Duck < Bird
	def call
		'Quack!'
	end

end