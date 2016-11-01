# Peer review
workshop result: https://drive.google.com/open?id=0B8G53_VFBdHZam5BbVdmQzZ6blE

## Running the application
There where no issues in compiling the code or running the application.

## Does the implementation and diagrams conform?
IView has an association to Game in the implementation which is not shown in the class diagram. The correct uml notation for an association is a line with an open arrow [1].
IHitStrategy has an dependency on Player which is not shown in the class diagram. The correct uml notation for a dependency is a dashed line with an open arrow [1].

## Is the dependency between controller and view handled?
The dependency between controller and view is correctly removed in this application by using an enumeration for the different user actions and let the view determine how the actions should be triggered.

## Is the Strategy Pattern used correctly for the rule variant Soft17?
The strategy pattern is correctly displayed in the class diagram and correctly used in the implementation.

## Is the Strategy Pattern used correctly for the variations of who wins the game?
The strategy pattern is correctly displayed in the class diagram and correctly used in the implementation.

## Is the code duplication solved?
The code duplication is solved by making the Dealer deal the cards which is according to the information expert pattern [2, p420]. A minor fix is to remove the deck as an argument to INewGameStrategy since it's not used.

## Is the Observer Pattern correctly implemented?
The implementation of the observer pattern is debatable since it introduces a dependency between the view and the Game model. By letting the controller subscribe instead of the view that dependency can be removed and it will better align with the information expert pattern since the controller already knows about and uses the Game [2, p420]. The implementation works as intended though.

## Is the class diagram updated to reflect the changes?
It's updated with all the new classes and interfaces but is missing an association as described above.

## Do you think the design/implementation has passed the grade 2 criteria?
I think the design and implementation will pass grade 2.

##References
1. Scott W. Ambler, UML 2 Class Diagrams, 2009, http://www.agilemodeling.com/style/classDiagram.htm
2. Larman C., Applying UML and Patterns 3rd, 2005, https://aanimesh.files.wordpress.com/2013/09/applying-uml-and-patterns-3rd.pdf
