Layer 2 Design:


Source Address 8 
Multicast 1
[Multicast Length] 4
Destination Address 8 
Payload Length 8 (8 bit length represents how many bytes)
Payload 1-256 bytes (2048) byte = 8bits
Check Sum 1
 

Multicast Length is only specified if Multicast is 1, and determines the amount of Destination Addresses.

Destination Address is FF for broadcast. 00 is always defined as the address server.

The first computer to connect to a wire is the address server. It must respond as 00 and give out new addresses when other computers come online.

When Payload Length is 0, the Payload is assumed to be one bytes long. The requester can put a requested address in the payload field, but the address server does not need to grant that specific address (ex if that address is already taken.)

EX: From new host: 03 0 00 00 03 **

       From address server: 00 0 03 00 06 **

Meaning: New host: "Server I have no address, I'll call myself 3 and I want 3." Host: "Ok 3, you can have address 6".

If there is already a host 3, he should ignore this exchange (because the payload length is 00).

Check Sum is a parity bit. Count the number of 1s in the frame, and the bit is 1 if odd, 0 if even.

A check sum is calculated obviously before transfer and then when the frame is received. If the calculated check sum and the read check sum do not match, then the frame should be ignored.

Uses CSMA/CD. Listen first, detect for collisions. 