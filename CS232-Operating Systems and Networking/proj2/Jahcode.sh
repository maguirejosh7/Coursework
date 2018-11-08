#!/bin/sh

for i in $( cat machinesSB354.txt ); do

#for loop started that initializes each computer name to i for each loop as the loop progresses
	PING=$( ping -c 1 $i)
	TTL=$( echo $PING | grep 'ttl' | awk -F'=' '{print $3 }'| awk -F' ' '{print $1}')
	UNRCH=$( echo $PING | grep "Unreachable" | awk -F'Destination ' '{print $2}' | awk -F' From' '{print $1}' | awk -F' -' '{print $1}')
	#Initializes the variables PING, TTL, and UNRCH
	#The if loops then go through the variables to determine the following characteristics for each workstation
	#If the computer had errors with the ping, then the computer is turned off
	#If the computer's ttl was not 64 but 128, then it is running Windows
	#If the computer's ttl was 64, then the program lists the users and their number following their username.
	#If the ttl is neither 
	if [ "$UNRCH" != "Host Unreachable" ] 
	then
		if [ $TTL -eq '64' ]
		then
			ECHO=$( echo | ssh $i who --count)
			echo The users on $i are $ECHO
		else 
			ECHO=$( echo | ssh $i who -count)
			echo $i is being used by $ECHO  and is running Windows
		fi
	else 
		echo $i is turned off
	fi
done

