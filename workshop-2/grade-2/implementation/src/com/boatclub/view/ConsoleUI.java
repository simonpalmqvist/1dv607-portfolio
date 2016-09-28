package com.boatclub.view;

import com.boatclub.controller.UserAction;
import com.boatclub.model.Boat;

import java.util.HashMap;
import java.util.Scanner;


public class ConsoleUI {

    private Scanner input = new Scanner(System.in);
    private HashMap<UserAction, String> menuOptions = new HashMap<>();
    private HashMap<Boat.Type, String> boatTypeOptions = new HashMap<>();

    public ConsoleUI () {
        // Add menu options to be displayed
        menuOptions.put(UserAction.AddMember, "Create a member");
        menuOptions.put(UserAction.ViewMember, "View a member");
        menuOptions.put(UserAction.UpdateMember, "Update a member");
        menuOptions.put(UserAction.DeleteMember, "Delete a member");
        menuOptions.put(UserAction.AddBoat, "Add members boat");
        menuOptions.put(UserAction.DeleteBoat, "Delete members boat");
        menuOptions.put(UserAction.Exit, "Exit");

        // Add boat type options
        boatTypeOptions.put(Boat.Type.Sailboat, "Sailboat");
        boatTypeOptions.put(Boat.Type.Motorsailer, "Motorsailer");
        boatTypeOptions.put(Boat.Type.KayakOrCanoe, "Kayak/Canoe");
        boatTypeOptions.put(Boat.Type.Other, "Other");
    }

    public void displayWelcomeMessage () {
        System.out.println("Welcome to the Boat Club");
    }

    public void displayExitMessage () {
        System.out.println("Bye Bye");
    }

    public void displayMenu (UserAction[] availableActions) {
        System.out.println();
        displayOptions(availableActions, menuOptions);
        System.out.println();
    }

    public void displayAddedMember () {
        System.out.println("New member added");
    }

    public void displayMember (String name, String pno, int id) {
        System.out.println("––––––––––––––––––––––––––");
        System.out.println("Name: " + name);
        System.out.println("Personal number: " + pno);
        System.out.println("ID: " + id);
        System.out.println("--------------------------");
    }

    public String displayUpdateName (String currentName) {
        return displayUpdateField("name", currentName);
    }

    public String displayUpdatePno (String currentPno) {
        return displayUpdateField("personal number", currentPno);
    }

    public void displayMemberDeleted () {
        System.out.println("Deleted member");
    }

    public void displayAddedBoat () {
        System.out.println("New boat added");
    }

    public void displayBoatDeleted () {
        System.out.println("Deleted boat");
    }

    public void displayMemberNotFound () {
        System.out.println("User not found");
    }

    public UserAction getUserRequest (UserAction[] availableActions) {
        return getUserChoice(availableActions);
    }

    public int getInputMemberId () {
        System.out.print("Members ID: ");
        return input.nextInt();
    }

    public String getInputMemberName () {
        System.out.print("New members name: ");
        return input.next();
    }

    public String getInputMemberPno () {
        System.out.print("New members Personal Number: ");
        return input.next();
    }

    public int getInputBoatIndex () {
        System.out.print("Boats index: ");
        return input.nextInt();
    }

    public Boat.Type getInputBoatType () {
        Boat.Type[] availableBoatTypes = Boat.Type.values();

        System.out.println("New boats type: ");
        displayOptions(availableBoatTypes, boatTypeOptions);

        return getUserChoice(availableBoatTypes);
    }

    public float getInputBoatLength () {
        System.out.print("New boats length: ");
        return input.nextFloat();
    }

    private <T> T getUserChoice (T[] availableOptions) {
        boolean acceptedInputValue = false;
        int choice = -1;

        // Ask for users choice until they respond with an index that exists in available options
        while (!acceptedInputValue) {
            System.out.print("Choice: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                acceptedInputValue = choice >= 0 && choice < availableOptions.length;
            } else {
                input.next();
            }
        }
        System.out.println();

        return availableOptions[choice];
    }

    private <T> void displayOptions (T[] availableOptions, HashMap<T, String> optionTitles) {
        for (int i = 0 ; i < availableOptions.length; i++) {
            T option = availableOptions[i];

            if (optionTitles.containsKey(option)) {
                String title = i + ". " + optionTitles.get(option);
                System.out.println(title);
            }
        }
    }

    private String displayUpdateField (String field, String currentValue) {
        String value = currentValue;

        if (displayYesAndNoQuestion("Change " + field +  " (" + value + ")?")) {
            System.out.print("Change to: ");
            value = input.next();
        }
        return value;
    }

    private boolean displayYesAndNoQuestion (String question) {
        boolean acceptedInputValue = false;
        boolean result = false;

        while (!acceptedInputValue) {
            System.out.print(question + " [Y/N]");
            String answer = input.next().toLowerCase();

            if (answer.equals("y") || answer.equals("n")) {
                result = answer.equals("y");
                acceptedInputValue = true;
            }
        }

        return result;
    }
}
