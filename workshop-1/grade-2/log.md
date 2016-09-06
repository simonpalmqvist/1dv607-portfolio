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
