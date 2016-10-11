# Peer review

## Getting the application running
I could get the application running without any problems. It also fulfilled all the requirements and gave error messages when needed.

## Diagrams
The class diagram corresponds well to the implemented solution except one missing dependency between the MemberDAO and the Member. It also uses the correct UML notations described by Scott W. Ambler [1] which makes it easy to understand. The sequence diagrams however is not showing the whole use cases, for example the list members diagram don't show the looping over members. 

## Implementation/Design
getBoatTypeFromMenuSelection validates the Model-View separation principle [2, p329-330] since the model contains view logic and the method should probably be placed in the view or controller class instead to keep the view logic separated from the model.

Another thing that can be improved is letting the Member class add, delete and update Boats instead of the MemberRegistry since they have the information needed to fulfill the actions. This goes inline with the GRASP information expert pattern explained by Larman [3, p426-427].

Duplication occur in some places in the view. for example the Scanner object is instantiated in several places which could be done once in the constructor and used as a private member and the method Textstring is always called together with readInt or readString and can therefor be moved into these methods instead. These cases don't follow the DRY principle and may require changes in several places if the logic needs to change in the future as decribed by Robert C. Martin [3, p48]

## As a developer would the diagrams help you and why/why not?
The class diagram would help to get a good overview of the system because it has the right notations and is aligned with the code implementation.

Regarding the sequence diagrams I think they would not help since they don't capture the whole use case and flow in the application.

## What are the strong points of the design/implementation, what do you think is really good and why?
The strong points with the design/implementation is follows the GRASP-patterns very well which gives benefits like reducing impact of future changes and making the different classes understandable by being focused on solving one thing [2, p424-434].

## What are the weaknesses of the design/implementation, what do you think should be changed and why?
The weaknesses with the design/implementation is the duplication of code in the view that should be refactored, which will make the controller easier to read/change as described above.

## Do you think the design/implementation has passed the grade 2 criteria?
Definitely, the things I have found is minor things that would improve the design/implementation further but this is a great design/implementation.

## References
1. Scott W. Ambler, UML 2 Class Diagrams, 2009, http://www.agilemodeling.com/style/classDiagram.htm
2. Larman C., Applying UML and Patterns 3rd, 2005, https://aanimesh.files.wordpress.com/2013/09/applying-uml-and-patterns-3rd.pdf
3. Robert C. Martin, Clean Code, 2009, ISBN: 0-13-235088-2
