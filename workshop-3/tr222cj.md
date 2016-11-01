# Peer review
workshop result: https://github.com/sticky4loop/ooad-ws3/tree/v1.1

## Running the application
Compiling and running the application worked fine. No bugs where found when running the application.

## Does the implementation and diagrams conform?
Controller PlayGame implements the CardDrawnObserver-interface but this is not reflected in the class diagram. According to the UML standard this should be displayed with a dashed line with a empty arrow [1]. 

Model Game creates an instance of the RulesFactory which is not shown as a dependency in the class diagram. According to the UML standard this should be displayed with a dashed line and an open arrow [1]. This dependency could also be avoided by moving the creation of the RulesFactory to the Dealer class according to the creator pattern [2, p424-425].

Model Player has an association to several CardDrawnObserver but in the diagram it looks like Player implements CardDrawnObserver. The correct UML notation for an association should be a line with an open arrow to the CardDrawnObserver [1].

Dealer implements Player but this is not shown in the class diagram. Should be shown with an UML notation for inheritance which is a line and an empty arrow [1].

## Is the dependency between controller and view handled?
The dependency between controller and view is correctly removed in this application by using an enumeration for the different user actions and let the view determine how the actions should be triggered.

## Is the Strategy Pattern used correctly for the rule variant Soft17?
The strategy pattern is correctly displayed in the class diagram and correctly used in the implementation.

## Is the Strategy Pattern used correctly for the variations of who wins the game?
The strategy pattern is correctly displayed in the class diagram and correctly used in the implementation. As described under the diagram the dependency to dealer could be removed by treating dealer as a Player.
`boolean whoIsWinner(Player dealer, Player player);`

## Is the code duplication solved?
The code duplication is solved by making the NewGameStrategy deal the cards. This works but the coupling could be reduced by letting the dealer deal the cards since it already knows about the deck and then the dependency between the strategy and deck would not be needed. This goes inline with the information expert pattern [2, p420].

## Is the Observer Pattern correctly implemented?
The observer pattern is correctly implemented but not correctly displayed in the class diagram.

## Is the class diagram updated to reflect the changes?
It's updated with all the new classes and interfaces but has some issues already commented on.

## Do you think the design/implementation has passed the grade 2 criteria?
After making sure the diagram and implementation conform it will pass grade 2.

##References
1. Scott W. Ambler, UML 2 Class Diagrams, 2009, http://www.agilemodeling.com/style/classDiagram.htm
2. Larman C., Applying UML and Patterns 3rd, 2005, https://aanimesh.files.wordpress.com/2013/09/applying-uml-and-patterns-3rd.pdf
