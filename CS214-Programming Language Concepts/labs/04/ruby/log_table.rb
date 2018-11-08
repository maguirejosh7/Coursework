#! /usr/bin/ruby
# log_table.rb displays a table of logarithms
#
# Begun by: Dr. Nelesen, for CS 214 at Calvin College.
# Completed by:Joshua Maguire
#
# Input:  The start, stop and increment values
# Precondition: The start value is less than the stop value, 
#     and the increment is greater than 0
# Output: A table of logarithms from start to stop, with increment
#     as the step value


if __FILE__ == $0
   print "Enter the start value: "
	 start = gets.chomp.to_i #Gets int from keyboard
   print "Enter the stop value: "
	 stop = gets.chomp.to_i #Gets int from keyboard
   print "Enter the increment value: "
	 counter = gets.chomp.to_f #Gets int from keyboard
	 
	 
	 while start <= stop #our simple loop
		puts "the logarithm of #{start} is #{Math.log10(start)}" #use #{value}, (rubys string literal thing
		start = start + counter #increment counter
	 end
end

