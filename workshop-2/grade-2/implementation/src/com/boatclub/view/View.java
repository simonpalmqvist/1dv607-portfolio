package com.boatclub.view;

import com.boatclub.controller.UserAction;
import com.boatclub.model.Boat;
import java.util.HashMap;

public class View {

    private ConsoleUI ui;
    private HashMap<UserAction, String> menuOptions = new HashMap<>();
    private HashMap<Boat.Type, String> boatTypeOptions = new HashMap<>();

    public View (ConsoleUI ui) {
        this.ui = ui;

        // Add menu options to be displayed
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
    }

    public void displayWelcomeMessage () {
        ui.showText("Welcome to the Boat Club");
    }

    public void displayExitMessage () {
        ui.showText("Bye Bye");
    }

    public void displayMenu (UserAction[] availableActions) {
        ui.displayOptions(availableActions, menuOptions);
    }

    public void displayAddedMember () {
        ui.showText("New member added");
    }

    public void displayMember (String name, String pno, int id) {
        ui.showText("––––––––––––––––––––––––––");
        ui.showText("Name: " + name);
        ui.showText("Personal number: " + pno);
        ui.showText("ID: " + id);
        ui.showText("--------------------------");
    }

    public String displayUpdateName (String currentName) {
        if (ui.displayYesAndNoQuestion("Change name (" + currentName + ")?")) {
            return ui.getUserInput("Change to");
        }
        return currentName;
    }

    public String displayUpdatePno (String currentPno) {
        if (ui.displayYesAndNoQuestion("Change personal number (" + currentPno+ ")?")) {
            return ui.getUserInput("Change to");
        }
        return currentPno;
    }

    public void displayMemberDeleted () {
        ui.showText("Deleted member");
    }

    public void displayAddedBoat () {
        ui.showText("New boat added");
    }

    public Boat.Type displayUpdateType (Boat.Type currentType) {
        if (ui.displayYesAndNoQuestion("Change type (" + boatTypeOptions.get(currentType) + ")?")) {
            return getInputBoatType();
        }
        return currentType;
    }

    public float displayUpdateLength (float currentLength) {
        if (ui.displayYesAndNoQuestion("Change length (" + currentLength + ")?")) {
            return ui.getUserFloatInput("Change to:");
        }
        return currentLength;
    }

    public void displayBoatDeleted () {
        ui.showText("Deleted boat");
    }

    public void displayMemberNotFound () {
        ui.showText("User not found");
    }

    public UserAction getUserRequest (UserAction[] availableActions) {
        return ui.getUserChoice(availableActions);
    }

    public int getInputMemberId () {
        return ui.getUserIntInput("Members ID");
    }

    public String getInputMemberName () {
        return ui.getUserInput("New members name");
    }

    public String getInputMemberPno () {
        return ui.getUserInput("New members Personal Number");
    }

    public int getInputBoatIndex () {
        return ui.getUserIntInput("Boats index");
    }

    public Boat.Type getInputBoatType () {
        Boat.Type[] availableBoatTypes = Boat.Type.values();

        ui.displayOptions(availableBoatTypes, boatTypeOptions);

        return ui.getUserChoice(availableBoatTypes);
    }

    public float getInputBoatLength () {
        return ui.getUserFloatInput("New boats length");
    }

}
