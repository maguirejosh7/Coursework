# birds.rb | Tests out the menagerie of bird classes.
#
# Begun by: Dr. Adams, for CS 214 at Calvin College.
# Completed by:Joshua Maguire
# Date: 5/4/14
######################################################

#in this version of ruby, require tries to find files in the load path.
#thats why I use require_relative. Also, ruby is smart enough to now need .rb
#This change is also in Owl, Duck, Duck, and Goose. 
require_relative 'Duck' 
require_relative 'Goose'
require_relative 'Owl'

bird0 = Bird.new "Hawkeye"
bird0.print

bird1 = Duck.new "Donald"
bird1.print

bird2 = Goose.new "Mother"
bird2.print

bird3 = Owl.new "Woodsey"
bird3.print