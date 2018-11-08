# namer.rb tests class Name and its operations
#
# Begun by: Dr. Adams, for CS 214 at Calvin College.
# Completed by: Joshua Maguire
# Date: 4/14/14
####################################################

require 'test/unit/assertions'
include Test::Unit::Assertions
require "./Name"

def testName
   name = Names::Name.new("John", "Paul", "Jones")

   assert name.first == "John", 
           "first failed"
   assert name.middle == "Paul",
           "middle failed"
   assert name.last == "Jones",
           "last failed"
   assert name.fullName == "John Paul Jones",
           "fullName failed"
   assert name.print == "John Paul Jones",
           "print failed"
   
   print "All tests passed!\n"
end

testName
