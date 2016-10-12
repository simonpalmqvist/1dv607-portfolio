# Boat Club

## Implementation
Requires Java 8 to run. App can be run in the terminal with command `java -jar BoatClub.jar` or you can open the project in Intellij for example and compile and run the project there.

## Changes after peer review
No changes has been done after the peer review since one of the reviews didn't thought anything needed to change. The other peer review wanted more specific class diagrams that shows all members but since I don't agree with that I will keep only showing the Boat and Member members since they are important to show that the implementation/design fulfills the requirements. 

## Sequence diagrams

Created by https://www.websequencediagrams.com
Therefor I store the "data" for generating the diagrams here under.

### Create member
```
title Create Member Sequence

Router->+Router: showAddMember()

Router->+View: getInputMemberName()
View->+ConsoleUI: getUserInput()
ConsoleUI-->-View: returns input
View-->-Router: returns name

Router->+View: getInputMemberPno()
View->+ConsoleUI: getUserInput()
ConsoleUI-->-View: returns input
View-->-Router: returns pno

Router->+BoatClub: addMember(name, pno)
BoatClub->*Member: member := new
BoatClub->-BoatClub: add(member)

Router->View: showAddedMember()
```

### List members
```
title Create Member Sequence

Router->+Router: showListOfMembersCompact()

Router->+View: displayMembersListHeader()

View->-View: showRow()

Router->+BoatClub: getAllMembers()
BoatClub-->-Router: returns members 

loop members
    Router->+Member: getId()
    Member-->-Router: returns id
    
    Router->+Member: getName()
    Member-->-Router: returns name
    
    Router->+Member: getPno()
    Member-->-Router: returns pno
    
    Router->+Member: getNumberOfBoats()
    Member-->-Router: returns numberOfBoats
    
    Router->+View: displayMemberListRow(id, name, pno, numberOfBoats)
    View->-View: showRow()
end
```
