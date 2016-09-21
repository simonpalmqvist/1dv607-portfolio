package com.boatclub.view;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class ConsoleUI {

    public enum Action {
        CreateMember,
        Exit
    }

    private Scanner uiInput = new Scanner(System.in);
    private Map<Action, String> actionInstructions = new HashMap<>();

    public ConsoleUI () {
        actionInstructions.put(Action.CreateMember, "Create member");
        actionInstructions.put(Action.Exit, "Quit application");
    }

    public Action getUserRequest (Action[] availableActions) {
        boolean acceptedInputValue = false;
        int choice = 0;

        displayActions(availableActions);

        while (!acceptedInputValue) {
            System.out.print("Action: ");
            if (uiInput.hasNextInt()) {
                choice = uiInput.nextInt();
                acceptedInputValue = choice >= 0 && choice < availableActions.length;
            } else {
                uiInput.next();
            }
        }
        return availableActions[choice];
    }

    public void displayStartupInformation () {
        System.out.println("Welcome to the Boat Club");
    }


    public void displayAddedUser () {
        System.out.println("New member added");
    }

    public void displayExitMessage () {
        System.out.println("ByeBye");
    }

    public String getInputName () {
        System.out.print("Add new members name: ");
        return uiInput.next();
    }

    public String getInputPno () {
        System.out.print("Add new members Personal Number: ");
        return uiInput.next();
    }

    private void displayActions (Action[] availableActions) {
        System.out.println();
        for (int i = 0 ; i < availableActions.length; i++) {
            System.out.println(i + ". " + actionInstructions.get(availableActions[i]));
        }
        System.out.println();
    }

}
