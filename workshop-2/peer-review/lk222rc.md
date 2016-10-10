# Peer review

## Getting the application running
I could get the application running without any problems. It also satisfied all the requirements and gave error messages when needed.

## Diagrams
Class diagram - correct, not over done, easy to overview
Missing dependency between DAO och Member.

Sequence diagram - are incomplete

## Implementation/Design
getBoatTypeFromMenuSelection contains view specific information
BoatType contains string representations should maybe be view specific

Declaration of Scanner object several times
view.TextString() called several times maybe can be put in the method readString and readInt since they are not used without textString.
Empty constructors

Don't see the point with the interface since its not used in Registry. Maybe better to make a MemberJson implementation as well.

Boat should maybe be handled by Member

## As a developer would the diagrams help you and why/why not?

## What are the strong points of the design/implementation, what do you think is really good and why?

## What are the weaknesses of the design/implementation, what do you think should be changed and why?


## Do you think the design/implementation has passed the grade 2 criteria?
Definitely, the things I have found is minor, this is a great design/implementation.

## References
1. Scott W. Ambler, UML 2 Class Diagrams, 2009, http://www.agilemodeling.com/style/classDiagram.htm
2. Robert C. Martin, Clean Code, 2009, ISBN: 0-13-235088-2
3. Larman C., Applying UML and Patterns 3rd, 2005, https://aanimesh.files.wordpress.com/2013/09/applying-uml-and-patterns-3rd.pdf
