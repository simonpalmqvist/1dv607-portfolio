package com.boatclub.view;

import com.boatclub.controller.MemberFilterAction;
import com.boatclub.controller.UserAction;
import com.boatclub.model.Boat;

import java.util.HashMap;
import java.util.regex.Pattern;

public class View extends ConsoleUI {

    private HashMap<UserAction, String> menuOptions = new HashMap<>();
    private HashMap<Boat.Type, String> boatTypeOptions = new HashMap<>();
    private HashMap<MemberFilterAction, String> memberFilterOptions = new HashMap<>();
    private String memberRowFormat = "| %5s | %30s | %20s | %20s |\n";
    private Pattern pnoPattern = Pattern.compile("[0-9]{6}-[0-9]{4}");

    public View () {
        // Add menu options to be displayed
        menuOptions.put(UserAction.Login, "Login");
        menuOptions.put(UserAction.Logout, "Logout");
        menuOptions.put(UserAction.ListMembers, "List members (compact)");
        menuOptions.put(UserAction.ListMembersVerbose, "List members (verbose)");
        menuOptions.put(UserAction.AddMember, "Create a member");
        menuOptions.put(UserAction.ViewMember, "View a member");
        menuOptions.put(UserAction.UpdateMember, "Update a member");
        menuOptions.put(UserAction.DeleteMember, "Delete a member");
        menuOptions.put(UserAction.AddBoat, "Add members boat");
        menuOptions.put(UserAction.DeleteBoat, "Update members boat");
        menuOptions.put(UserAction.DeleteBoat, "Delete members boat");
        menuOptions.put(UserAction.Exit, "Exit");

        // Add boat type options
        boatTypeOptions.put(Boat.Type.Sailboat, "Sailboat");
        boatTypeOptions.put(Boat.Type.Motorsailer, "Motorsailer");
        boatTypeOptions.put(Boat.Type.KayakOrCanoe, "Kayak/Canoe");
        boatTypeOptions.put(Boat.Type.Other, "Other");

        memberFilterOptions.put(MemberFilterAction.None, "No filter");
        memberFilterOptions.put(MemberFilterAction.MemberWithNameThatStartWithSi, "Only members with name that starts with 'si'");
        memberFilterOptions.put(MemberFilterAction.MemberWithFiveBoats, "Only members with 5 boats");
    }

    public void displayWelcomeMessage () {
        showText("Welcome to the Boat Club");
    }

    public void displayExitMessage () {
        showText("Bye Bye");
    }

    public void displayMenu (UserAction[] availableActions) {
        displayOptions(availableActions, menuOptions);
    }

    public String getInputUsername () {
        return getUserInput("Username");
    }

    public String getInputPassword () {
        return getUserInput("Password");
    }

    public void displayWrongCredentials() {
        showText("Wrong credentials");
    }

    public MemberFilterAction getMemberFilter () {
        MemberFilterAction[] availableActions = MemberFilterAction.values();

        showText("Apply filter on list");
        showText("––––––––––––––––––––––––––");
        displayOptions(availableActions, memberFilterOptions);

        return getUserChoice(availableActions);
    }

    public void displayMemberListHeader () {
        showRow(memberRowFormat, "ID", "Name", "Personal number", "Number of boats");
    }

    public void displayMemberListRow (int id, String name, String pno, int numberOfBoats) {
        showRow(memberRowFormat, id, name, pno, numberOfBoats);
    }

    public void displayAddedMember () {
        showText("New member added");
    }

    public void displayMember (String name, String pno, int id) {
        showText("––––––––––––––––––––––––––");
        showText("Name: " + name);
        showText("Personal number: " + pno);
        showText("ID: " + id);
        showText("--------------------------");
    }

    public String displayUpdateName (String currentName) {
        if (displayYesAndNoQuestion("Change name (" + currentName + ")?")) {
            return getUserInput("Change to");
        }
        return currentName;
    }

    public String displayUpdatePno (String currentPno) {
        if (displayYesAndNoQuestion("Change personal number (" + currentPno+ ")?")) {
            return getUserInput("Change to");
        }
        return currentPno;
    }

    public void displayMemberDeleted () {
        showText("Deleted member");
    }

    public void displayAddedBoat () {
        showText("New boat added");
    }

    public void displayBoat (Boat.Type type, float length) {
        showText("Type: " + boatTypeOptions.get(type));
        showText("Length: " + length);
        showText("--------------------------");
    }

    public Boat.Type displayUpdateType (Boat.Type currentType) {
        if (displayYesAndNoQuestion("Change type (" + boatTypeOptions.get(currentType) + ")?")) {
            return getInputBoatType();
        }
        return currentType;
    }

    public float displayUpdateLength (float currentLength) {
        if (displayYesAndNoQuestion("Change length (" + currentLength + ")?")) {
            return getUserFloatInput("Change to:");
        }
        return currentLength;
    }

    public void displayBoatDeleted () {
        showText("Deleted boat");
    }

    public void displayMemberNotFound () {
        showText("User not found");
    }

    public void displayBoatNotFound() {
        showText("Boat not found");
    }

    public UserAction getUserRequest (UserAction[] availableActions) {
        return getUserChoice(availableActions);
    }

    public int getInputMemberId () {
        return getUserIntInput("Members ID");
    }

    public String getInputMemberName () {
        return getUserInput("New members name");
    }

    public String getInputMemberPno () {
        return getUserPatternInput("New members Personal Number [XXXXXX-XXXX]", pnoPattern);
    }

    public int getInputBoatIndex () {
        return getUserIntInput("Boats index");
    }

    public Boat.Type getInputBoatType () {
        Boat.Type[] availableBoatTypes = Boat.Type.values();

        displayOptions(availableBoatTypes, boatTypeOptions);

        return getUserChoice(availableBoatTypes);
    }

    public float getInputBoatLength () {
        return getUserFloatInput("New boats length");
    }
}
