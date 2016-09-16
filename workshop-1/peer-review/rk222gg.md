# Peer Review

This a peer review performed on domain model https://www.dropbox.com/sh/eic37e7n4egq01w/AADzK0rQvBb1GoPBztP6bauQa?lst done by Rasmus Karlsson.

## Strong points of the model
The model mostly uses good names for the different conceptual classes which is key for lower the gap between mental and software models [1, p227]. Some examples of thi is the Member owns Boat, Boat Occupies Berth and Member Pays MembershipFee.

It also have a good distinction between what should be a class and what should be an attribute as is a common mistake in domain modeling [1, p. 241]. The attributes are also only added when they bring value to not add visual noise.

## Weaknessess of the model
The first possible weakness is that the model uses technical concepts such as Request, System for explaining the authentication flow. This could possibly be left out because it's not part of this domain that is trying to be modelled but also because Larman states that a Domain model is a visualization of things in a real-situation domain of interest, not of software objects [1, p224].


Another weakness is that the model contains a lot of different associations to a lot of different conceptual classes which might be able to scale down to increase visibility. Larman states that many lines on a diagram will obscure it with "visual noice" [1, p247]. One point is removing the authentication part but also other part might be able to remove such as the Secretary and the Treasurer. These can be removed because we might not really need to know which treasurer keeps-record-of membership fee and which secretary that assigns which berth. Associations worth noting usually imply knowledge of a relationship that needs to be preserved for some duration [1, p246].


One part that could be debatable if it's a weakness or not is the Calendar - Member relationship because the associations are not clear. The association Views Event(s) should probably be split up into class Member ->  association Views -> class Event. The Event could then belong to the Calendar but maybe the Calendar is just a report of the Events [1, p238]. 

## Would this domain model help the delevoper
Even though the domain model contains good namings and associations of and between the conceptual classes it might for some be hard to get a good overview of the domain because it's a lot of associations and classes the could be scaled off as mentioned above.

## Would a domain expert understand the model
From a domain experts point of view they should be able to understand the model because it uses domain specific names that the expert can relate to.

## Has the model passed the grade 2
The two separate domain models should possibly be one scaled off domain model to pass the grade 2.

## References 
1. Larman C., Applying UML and Patterns 3rd Ed, 2005, ISBN: 0131489062
