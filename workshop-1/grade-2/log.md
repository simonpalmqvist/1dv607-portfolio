# Workshop 1 - grade 2

## Identify potential classes, attributes and associations based on requirements

### 1. Authenticate

#### Classes
* Person
* User (Might be extension of Member, Treasurer, Secretary)
* System (a bit too technical?)

#### Attributes
* User have username and password and perhaps a role (or derived role if the roles extends user)

#### Associations
* A Person authenticates as a User
* Or System authenticates User


### 4. Register Boat

#### Classes
* Member (as found for requirement 1)
* Boat
* Berth
* BerthRules
* Membership
* Secretary

#### Attributes
* Boat should have attributes size and type
* Berth should have attribute price
* Membership should have a fee

#### Associations
* Member owns Boat
* Berth assigned to Boat
* Secretary assigns Berth
* Member subscribes to a Membership

### 5. Remove a Boat
Nothing new found for this requirement

### 6. Change a Boat
Nothing new found for this requirement

### 8. Assign Berths

#### Classes
* BerthHistory (to be able to look at previous years allocation?)

### 10. Manage Calendar Event

#### Classes
* Event

#### Associations
* Secretary arranges Event

### 11. List Calendar Events

#### Attributes
* Event has a title and a start date

### 12. Show Calendar Event
Nothing new found for this requirement

## Updates and assumptions after discussions at workshop
* Person/User/System classes used for authentication purposes has been removed because it's too technical and doesn't really explain the domain we try to model.
* Role/class Secretary has also been removed after the assumption that it's not necessary to know which secretary assigned which berth.

## Updates after reading peer review 1
https://docs.google.com/document/d/119ube8O3XE4uT6JVdtoWuk6urQCsr9IexFRRynJW8a4/edit

* Adding 'fee : Money' instead of price attribute for Berth.  Don't totally agree with feedback but highlighting that fee/price is of type Money this attribute is important since according to the use case the membership fee is based on the cost of members berths.
* The rest of the feedback is disregarder since authentication/registration don't belong to this domain. Secretary is not added because we don't need to track which Secretary manages which Berth or Event. Association arrows are not used because each association flows into the right direction top-to-bottom or left-to-right so they are not needed.

## Updates after reading peer review 2
https://github.com/andersmelin/1dv607/blob/master/Workshop-1/Outgoing-peer-reviews/Peer-review:-Simon-Palmqvist.md

* Changing association for Boat (1) docks-at (1) Berth to Boat (0..1) docks-at (1) Berth. This to as the feedback said Berths can be empty.
* Member attends event is as the feedback says don't interesting since it's not mentioned in the use cases. I find the association Lists/Views to be a bit to technical though and after some thinking has the event association changed into following: Boat Club (1) Arranges (*) Events. Which in a more clear way explains the relationship.
* Input that didn't change the model was that, in my view, a Calendar is just a report of Events. And I also didn't include the Secretary for the same reason as for review 1.
