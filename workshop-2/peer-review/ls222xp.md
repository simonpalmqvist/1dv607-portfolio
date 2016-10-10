# Peer review

## Getting the application running
I couldn't get the application running since I'm running OSX and couldn't get a hold of a computer with Windows on.

## Diagrams
The diagram in overall is understandable but have some issues that could improve the readability.
A lot of the arrows that should symbol a dependency instead have the arrow of a implementation of an interface with adds some confusion when first looking at the diagram [1].
There is also missing dependecies to the Boat and Member class in both controllers and the view.
In Class Diagrams Interfaces should also be presented with the appropriate arrow but ICommandHandler is not included [1].

## Implementation
There is a clear separation between the view and the model which makes the business logic easy to understand.
Each user has a unique ID which is generated from the last user added which is good. Only downside is if the storage changes and the new store can't garuantee the order of the returned members.

The implementation of the code is good. It has high readability thanks to the vertical and horisontal density [2, p76-90].

## Design

The design of the application could improve slightly and might be as it is because the diagrams lacks dependecies between certain classes which show that some improvements can and maybe even should be made.
To follow GRASP and the Creator pattern Larman states that object B can create an instance of object A if one of following cases is true (the more the better):
* B contains or aggregates A
* B records A
* B closely uses A
* B has the initializing data to A
[3, p425]. 

In the implementation Boats and Members are initalized by their controllers which instead might be better to place under the MemberRegistry since that class fulfill more cases in the list above.

Another thing that can be improved is letting the Member class add, delete and update Boats instead of the MemberRegistry since they have the information needed to fulfill the actions. This goes inline with the GRASP information expert pattern explained by Larman [3, p426-427].

The coupling of the Controller part of the application are maybe not that low as it can be because it has a lot of controllers. It therefor might be worth checking if maybe the BoatAdder, BoatDeleter, BoatUpdater might be one class instead of three since they have a lot in common. This is also true for the member controllers and is explained by Larman as the pattern Low coupling [3, p427-428].

## As a developer would the diagrams help you and why/why not?
As explained above the class diagram takes some time to grasp because of the misuse of arrows and the amount of controller classes. However I would still argue that it's understandable.

## What are the strong points of the design/implementation, what do you think is really good and why?
As described under the implementation section the architecture is well done and has a clear separation between view and model.

## What are the weaknesses of the design/implementation, what do you think should be changed and why?
The main weakness is the amount of controllers which make the application a bit hard to follow and some misplacement of initalizing and handling classes.

## Do you think the design/implementation has passed the grade 2 criteria?
I think it passes grade 2 if the design/implementation can get lower coupling.

## References
1. Scott W. Ambler, UML 2 Class Diagrams, 2009, http://www.agilemodeling.com/style/classDiagram.htm
2. Robert C. Martin, Clean Code, 2009, ISBN: 0-13-235088-2
3. Larman C., Applying UML and Patterns 3rd, 2005, https://aanimesh.files.wordpress.com/2013/09/applying-uml-and-patterns-3rd.pdf
