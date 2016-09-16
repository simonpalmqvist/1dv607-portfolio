# Peer Review

This a peer review performed on domain model https://github.com/LindaOtt/1dv607-workshop-1/blob/master/Workshop_1_grade_2.jpg done by Linda Ott Olander.

## Strong points of the model
The domain model takes the key concepts from the use cases and presents it with classes taken from real world objects and tries to avoid using software objects. 
This goes inline with the purpose of the domain model or as Larman states it illustrates noteworthy concepts in a domain. [1, p229]
It also does a good job and follows the mapmaker strategy [1, p239] in only keeping the relevant information in the domain model because it uses existing names in the territory and don't add things that are not found in the use cases.
Some examples of that is using names like Boat and Berth.

## Weaknessess of the model
As mentioned above the domain model use good conceptual classes except for the User since that is a bit generic and don't give a clear representation of the Member and the other roles. For example it's only the Member who probably owns a boat and wants a berth for it.
A part of the domain model that might be a weakness and debatable is the Calendar since it's first attribute Event probably should be an conceptual class because it's not a text or a number [1, p241]. If the Event then is a conceptual class the Calendar might be a duplicate of data since it's just a report of different events [1, p238].

## Would this domain model help a developer
It's easy to grasp and should therefor aid the developer in understanding and communicating over the domain.

## Would a domain expert understand the model
The concepts of the model would be understandable for a domain expert except for the User part which is a bit too generic named and not all the roles should be able to own boats or update the Calendar as mentioned earlier in the review.

## Has the model passed the grade 2
This is a good attempt in modelling this domain area that is easy to grasp so it should pass the grade 2.

## References 
1. Larman C., Applying UML and Patterns 3rd Ed, 2005, ISBN: 0131489062
