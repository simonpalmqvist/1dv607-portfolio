# Boat Club

## Implementation


## Sequence diagrams

Created by https://www.websequencediagrams.com

### Create member
´´´
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
´´´
