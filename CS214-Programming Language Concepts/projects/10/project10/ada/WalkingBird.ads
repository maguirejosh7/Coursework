

with Bird_Package; use Bird_Package;

package WalkingBird is 

--type WalkingBird is new Bird_Type with private;

function movement(A_WalkingBird: in WalkingBird) return String;

private
	type WalkingBird is new Bird_Type with	
		record
			null;
		end record;

end WalkingBird;