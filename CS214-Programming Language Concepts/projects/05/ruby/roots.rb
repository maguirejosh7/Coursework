 # roots.cpp computes the roots of a quadratic equation 
 #
 # Input: three terms of quadratic equation ( y = ax^2 + bx + c )
 # PRE: a > 0, (b^2 - 4ac) != negative
 # Output: x = root1, x = root2
 #
 # Begun by: Dr. Adams, for CS 214 at Calvin College.
 # Completed by:Joshua Maguire
 # Date:3/13/14
 ######################################################################/

#This method computes the roots of a quadratic equation. More at top of file...
def quadraticRoots(a, b, c)
	if a != 0.0
		arg = (b**2.0) - 4.0*a*c
		if arg >= 0.0
			root1= (-b + Math.sqrt(arg))/(2*a)#first root
			root2= (-b - Math.sqrt(arg))/(2*a)#second root
			print "x = #{root1}, x = #{root2}\n"#print roots
		else
			print "\n*** quadraticRoots(): b^2 - 4ac is negative!"#error
		end
	else
		print "\n*** QuadraticRoots(): a is zero!"#error
	end
end


if __FILE__ == $0
	print "\nEnter terms for quadratic equation: \n first term:"
		rootA = gets.chomp.to_f
	print "\nsecond term:"
		rootB = gets.chomp.to_f
	print "\nthird term:"
		rootC = gets.chomp.to_f
	quadraticRoots(rootA, rootB, rootC)
end
