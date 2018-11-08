Script started on Mon 24 Feb 2014 04:21:55 PM EST
jlm54@thompson:~/214/labs/03$ cat year_codes.rb
#! /usr/bin/ruby
# year_codes.rb translates an academic year into a numeric code
# Begun by: Dr. Nelesen, for CS 214 at Calvin College 
#continued by Joshua Maguire on 2/22/14
################################################################

# Input:  The name of an academic year
# Precondition: The academic year is a string with a value of freshman, 
#   sophomore, junior or senior
# Output: The corresponding integer code for the given academic year


def yearCode(year) #define yearCode function ### end
 if year =~ /freshman/ then return 1
 elsif year =~ /sophomore/ then return 2
 elsif year =~ /junior/ then return 3
 elsif year =~ /senior/ then return 4
 else return 0
 end
end




if __FILE__ == $0
   print "Enter the year: "
   year = gets
   print "Numeric code is: "
   puts yearCode(year)
end
jlm54@thompson:~/214/labs/03$ ruby year_codes.rb
Enter the year: freshman
Numeric code is: 1
jlm54@thompson:~/214/labs/03$ ruby year_codes.rb
Enter the year: sophomore
Numeric code is: 2
jlm54@thompson:~/214/labs/03$ ruby year_codes.rb
Enter the year: junior
Numeric code is: 3
jlm54@thompson:~/214/labs/03$ ruby year_codes.rb
Enter the year: senior
Numeric code is: 4
jlm54@thompson:~/214/labs/03$ ruby year_codes.rb
Enter the year: hello
Numeric code is: 0
jlm54@thompson:~/214/labs/03$ exit

Script done on Mon 24 Feb 2014 04:22:47 PM EST
