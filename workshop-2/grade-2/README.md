# Boat Club

## Implementation
Requires Java 8 to run. App can be run in the terminal with command `java -jar BoatClub.jar` or you can open the project in Intellij for example and compile and run the project there.

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
BoatClub->ArrayList<Member>: add(member)

Router->View: showAddedMember()
```

### List members
