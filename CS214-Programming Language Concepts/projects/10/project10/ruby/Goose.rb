# Goose.rb | Defines the Goose class which inherits attributes and methods
#   from the Bird superclass.
#
# Begun by: Dr. Adams, for CS 214 at Calvin College.
# Completed by: Joshua Maguire
# Date: 5/4/14
####################################################

require_relative 'Bird'

class Goose < Bird
	def call
		'Honk!'
	end

end